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
import com.exam.examsystem.utils.UserRequestUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

        po.setPassword(DigestUtils.md5Hex(userForm.getPassword()));
        po.setStatus(BizMessageConstants.USER_STATUS_1);
        po.setDeleted(BizMessageConstants.USER_DELETED_0);
        userDao.insert(po);
    }

    @Override
    public boolean removeUser(Integer userid) throws Exception {
        UserPo userPo = userDao.selectByPrimaryKey(userid);
        if (userPo == null) {
            logger.info("用户：{}不存在", userid);
            throw new Exception("用户不存在");
        }
        userPo.setDeleted(BizMessageConstants.USER_DELETED_1);
        userPo.setModifier(UserRequestUtils.getCurrentUserid());
        userPo.setModifydate(new Date());
        int num = userDao.updateByPrimaryKey(userPo);
        if (num == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUserBatch(String ids) throws Exception {
        Integer currentUserid = UserRequestUtils.getCurrentUserid();
        int i = userDao.removeUserBatch(ids, currentUserid);
        if (i == 0) {
            return false;
        }
        return true;
    }


    @Override
    public boolean updateStatus(Integer userid, String status) throws Exception {

        UserPo userPo = userDao.selectByPrimaryKey(userid);
        if (userPo == null) {
            logger.info("用户：{}不存在", userid);
            throw new Exception("用户不存在");
        }

        userPo.setStatus(status);
        userPo.setModifier(UserRequestUtils.getCurrentUserid());
        userPo.setModifydate(new Date());
        int num = userDao.updateByPrimaryKey(userPo);
        if (num == 0) {
            return false;
        }
        return true;
    }

}
