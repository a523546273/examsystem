package com.exam.examsystem.utils;

import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.po.UserPo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hongwei.wang
 * @create: 2019-06-13 11:11
 */
public class UserRequestUtils {

    public static UserPo getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserPo user = (UserPo) request.getSession().getAttribute(SessionConstants.WSSIP_OPERATOR);
        return user;
    }

    public static Integer getCurrentUserid() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        int userid = (int) request.getSession().getAttribute(SessionConstants.WSSIP_OPERATOR_ID);
        return userid;
    }
}
