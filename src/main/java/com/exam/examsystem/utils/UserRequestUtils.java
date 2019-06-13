package com.exam.examsystem.utils;

import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.po.UserPo;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hongwei.wang
 * @create: 2019-06-13 11:11
 */
public class UserRequestUtils {

    public static UserPo getCurrentUser() {
        UserPo userPo = (UserPo) SecurityUtils.getSubject().getPrincipal();
        return userPo;
    }

    public static Integer getCurrentUserid() {
        UserPo userPo = (UserPo) SecurityUtils.getSubject().getPrincipal();
        return userPo.getUserid();
    }
}
