package com.exam.examsystem.dao;

import com.exam.examsystem.po.RoleMenuPo;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenuPo record);

    int insertSelective(RoleMenuPo record);

    RoleMenuPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenuPo record);

    int updateByPrimaryKeyWithBLOBs(RoleMenuPo record);

    int updateByPrimaryKey(RoleMenuPo record);
}