package com.exam.examsystem.service.impl;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.dao.UserDao;
import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.req.UserForm;
import com.exam.examsystem.req.UserRequest;
import com.exam.examsystem.service.UserService;
import com.exam.examsystem.utils.MD5Utils;
import com.exam.examsystem.utils.SlatUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public PageResult<UserPo> selectAllUser(UserRequest filter) {

        PageHelper.startPage(filter.getPage(), filter.getLimit());
        List<UserPo> userPos = userDao.selectAllUser(filter);
        PageInfo<UserPo> pageInfo = new PageInfo<>(userPos);

        return new PageResult<>(userPos, pageInfo.getTotal());
    }

    @Override
    public void addUser(UserForm userForm) throws Exception {

        UserPo po1 = userDao.selectByMobilePhone(userForm.getMobilePhone());
        if (po1 != null) {
            throw new Exception(BizMessageConstants.USER_MOBILE_EXIT);
        }

        UserPo po2 = userDao.selectByLoginname(userForm.getLoginname());
        if (po2 != null) {
            throw new Exception(BizMessageConstants.USER_LOGINNAME_EXIT);
        }

        UserPo po = new UserPo();
        BeanUtils.copyProperties(userForm, po);
        po.setCreatedate(new Date());

        String slat = SlatUtils.generateVerifyCode();
        po.setSlat(slat);

        po.setPassword(MD5Utils.MD5Encode(userForm.getPassword(), slat));
        po.setStatus(BizMessageConstants.USER_STATUS_1);
        userDao.insert(po);
    }
}
