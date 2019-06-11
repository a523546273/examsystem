package com.exam.examsystem.dao;

import com.exam.examsystem.po.RoleUserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleUserPo record);

    int insertSelective(RoleUserPo record);

    RoleUserPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleUserPo record);

    int updateByPrimaryKey(RoleUserPo record);
}