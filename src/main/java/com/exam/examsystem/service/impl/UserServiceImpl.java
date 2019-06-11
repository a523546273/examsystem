package com.exam.examsystem.service.impl;

import com.exam.examsystem.dao.UserDao;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 14:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserPo selectByMobilePhone(String mobilePhone) {
        return userDao.selectByMobilePhone(mobilePhone);
    }
}
