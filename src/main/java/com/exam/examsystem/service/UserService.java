package com.exam.examsystem.service;

import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.req.UserForm;
import com.exam.examsystem.req.UserRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    /**
     * 查询所有用户信息  但是不包含密码等信息
     *
     * @return
     */
    PageResult<UserPo> selectAllUser(UserRequest filter);

    @Transactional
    void addUser(UserForm userForm) throws Exception;
}
