package com.exam.examsystem.dao;

import com.exam.examsystem.po.RolePo;
import com.exam.examsystem.req.RoleRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    int deleteByPrimaryKey(Integer roleid);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    RolePo selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);

    List<RolePo> selectAllRole(RoleRequest filter);
}