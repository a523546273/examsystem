package com.exam.examsystem.service;

import com.exam.examsystem.po.UserPo;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 14:56
 */
public interface UserService {

    /**
     * 根据手机号查询用户信息
     *
     * @param mobilePhone
     * @return
     */
    UserPo selectByMobilePhone(String mobilePhone);
}
