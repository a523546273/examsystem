package com.exam.examsystem.interceptor;

import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.service.UserService;
import com.exam.examsystem.utils.ShiroFilterUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: hongwei.wang
 * @create: 2019-06-13 16:55
 */
public class UserActionInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(UserActionInterceptor.class);

    @Autowired
    private UserService userService;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final String kickoutUrl = "/loginOut"; // 退出后重定向的地址

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object obj) throws Exception {
        // TODO Auto-generated method stub
        logger.debug("请求到达后台方法之前调用（controller之前）");
        // 1. SecurityUtils获取session中的用户信息
        // HttpSession session=request.getSession();
        UserPo user = (UserPo) SecurityUtils.getSubject().getPrincipal();
        if (user != null && StringUtils.isNotEmpty(user.getMobilePhone())) {
            // 2. 获取数据库中的用户数据
            UserPo dataUser = userService.selectByMobilePhone(user.getMobilePhone());
            // 3. 对比session中用户的version和数据库中的是否一致
            if (dataUser != null) {
                // 3.1 一样，放行
                return true;
            } else {
                // 3.2 不一样，这里统一做退出登录处理；//TODO 使用redis缓存用户权限数据，根据用户更新、用户权限更新；做对应的处理。
                SecurityUtils.getSubject().logout();
                ShiroFilterUtils.isAjax(request);
            }
        }
        return false;
    }


}
