package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.service.UserService;
import com.exam.examsystem.utils.MD5Utils;
import com.exam.examsystem.utils.ResponseDataUtil;
import com.exam.examsystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 13:39
 */
@Controller
@RequestMapping(produces = BizMessageConstants.MEDIATYPE_UTF8_APPLICATION_JOSN)
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("/login/login");
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseData login(HttpServletRequest request, UserVo userVo) {
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

            request.getSession().setAttribute(SessionConstants.WSSIP_OPERATOR_ID, userPo.getUserid());
            request.getSession().setAttribute(SessionConstants.WSSIP_OPERATOR_LOGINNAME, userPo.getLoginname());

        } catch (Exception e) {
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }
}
