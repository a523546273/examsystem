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

    /**
     * 新增用户信息
     *
     * @param userForm
     * @throws Exception
     */
    @Transactional
    void addUser(UserForm userForm) throws Exception;

    /**
     * 删除用户信息
     *
     * @param userid 用户id
     * @throws Exception
     */
    @Transactional
    boolean removeUser(Integer userid) throws Exception;


    /**
     * 删除用户信息
     *
     * @param ids 用户id
     * @throws Exception
     */
    @Transactional
    boolean removeUserBatch(String ids) throws Exception;


    /**
     * 更新用户状态
     *
     * @param userid
     * @param status 1启用  2注销
     * @return
     * @throws Exception
     */
    @Transactional
    boolean updateStatus(Integer userid, String status) throws Exception;
}
