package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.service.UserService;
import com.exam.examsystem.utils.ResponseDataUtil;
import com.exam.examsystem.vo.UserVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 13:39
 */
@Controller
@RequestMapping(produces = BizMessageConstants.MEDIATYPE_UTF8_APPLICATION_JOSN)
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private EhCacheManager ecm;

    @RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("/login/login");
    }

   /* @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseData login(HttpServletRequest request, UserVo userVo, boolean rememberMe) {
        try {
            UserPo userPo = userService.selectByMobilePhone(userVo.getMobilePhone());
            if (userPo == null) {
                return ResponseDataUtil.buildError(ResultEnums.NO_USER);
            }

            String password = MD5Utils.MD5Encode(userVo.getPassword(), userPo.getSlat());

            if (!userPo.getPassword().equals(password)) {
                // return ResponseDataUtil.buildError(ResultEnums.NO_USER);
            }

            if (!"1".equals(userPo.getStatus())) {
                return ResponseDataUtil.buildError(ResultEnums.USER_STATUS_ERROR);
            }

            request.getSession().setAttribute(SessionConstants.WSSIP_OPERATOR, userPo);
            request.getSession().setAttribute(SessionConstants.WSSIP_OPERATOR_ID, userPo.getUserid());
            request.getSession().setAttribute(SessionConstants.WSSIP_OPERATOR_LOGINNAME, userPo.getLoginname());

        } catch (Exception e) {
            logger.error("登录异常", e);
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }*/


    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public ResponseData login(UserVo userVo, boolean rememberMe) {

        UserPo existUser = this.userService.selectByMobilePhone(userVo.getMobilePhone());

        if (existUser == null) {
            return ResponseDataUtil.buildError(ResultEnums.USER_NULL);
        }

        try {
            // 1、 封装用户名、密码、是否记住我到token令牌对象 [支持记住我]
            AuthenticationToken token = new UsernamePasswordToken(
                    userVo.getMobilePhone(), DigestUtils.md5Hex(userVo.getPassword()),
                    rememberMe);
            // 2、 Subject调用login
            Subject subject = SecurityUtils.getSubject();
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.debug("用户登录，用户验证开始！user=" + userVo.getMobilePhone());
            subject.login(token);

        } catch (UnknownAccountException uae) {
            logger.error("用户登录，用户验证未通过：未知用户！user=" + userVo.getMobilePhone(), uae);
            return ResponseDataUtil.buildError(ResultEnums.NO_USER);
        } catch (IncorrectCredentialsException ice) {
            // 获取输错次数
            logger.error("用户登录，用户验证未通过：错误的凭证，密码输入错误！user=" + userVo.getMobilePhone(),
                    ice);
            return ResponseDataUtil.buildError(ResultEnums.NO_USER);
        } catch (LockedAccountException lae) {
            logger.error("用户登录，用户验证未通过：账户已锁定！user=" + userVo.getMobilePhone(), lae);
            return ResponseDataUtil.buildError(ResultEnums.NO_USER);
        } catch (ExcessiveAttemptsException eae) {
            logger.error(
                    "用户登录，用户验证未通过：错误次数大于5次,账户已锁定！user=.getMobile()" + userVo.getMobilePhone(), eae);

            // 这里结合了，另一种密码输错限制的实现，基于redis或mysql的实现；也可以直接使用RetryLimitHashedCredentialsMatcher限制5次
            return ResponseDataUtil.buildError(ResultEnums.USER_PASSWORD_ERROR);
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("用户登录，用户验证未通过：认证异常，异常信息如下！user=" + userVo.getMobilePhone(),
                    ae);
            return ResponseDataUtil.buildError(ResultEnums.NO_USER);
        } catch (Exception e) {
            logger.error("登录异常", e);
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }

        Cache<String, AtomicInteger> passwordRetryCache = ecm
                .getCache("passwordRetryCache");
        if (null != passwordRetryCache) {
            int retryNum = (passwordRetryCache.get(existUser.getMobilePhone()) == null ? 0
                    : passwordRetryCache.get(existUser.getMobilePhone())).intValue();
            logger.debug("输错次数：" + retryNum);
            if (retryNum > 0 && retryNum < 6) {

                return ResponseDataUtil.buildError("用户名或密码错误" + retryNum + "次,再输错"
                        + (6 - retryNum) + "次账号将锁定");
            }
        }

        return ResponseDataUtil.buildSuccess();
    }


    @RequestMapping("/logout")
    public ModelAndView toLogin() {
        return new ModelAndView("/login/login");
    }

}
