package com.exam.examsystem.service.impl;

import com.exam.examsystem.dao.RoleDao;
import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.po.RolePo;
import com.exam.examsystem.req.RoleRequest;
import com.exam.examsystem.service.RoleService;
import com.exam.examsystem.utils.UserRequestUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-14 09:59
 */
@Service
public class RoleServiceImpl implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);


    @Autowired
    private RoleDao roleDao;

    @Override
    public PageResult<RolePo> selectAllRole(RoleRequest filter) {
        PageHelper.startPage(filter.getPage(), filter.getLimit());
        List<RolePo> list = roleDao.selectAllRole(filter);
        PageInfo<RolePo> pageInfo = new PageInfo<>(list);
        return new PageResult<>(list, pageInfo.getTotal());


    }

    @Override
    public boolean updateStatus(Integer roleid, String validity) throws Exception {
        RolePo rolePo = roleDao.selectByPrimaryKey(roleid);

        if (rolePo == null) {
            logger.info("用户：{}不存在", roleid);
            throw new Exception("用户不存在");
        }
        rolePo.setValidity(validity);
        rolePo.setModifier(UserRequestUtils.getCurrentUserid());
        rolePo.setModifydate(new Date());
        int num = roleDao.updateByPrimaryKey(rolePo);
        if (num == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeRole(Integer roleid) {
        int i = roleDao.deleteByPrimaryKey(roleid);
        if (i == 0)
            return false;

        return true;
    }
}
