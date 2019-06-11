package com.exam.examsystem.dao;

import com.exam.examsystem.po.MenuResourcePo;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuResourceDao {
    int deleteByPrimaryKey(Integer menuid);

    int insert(MenuResourcePo record);

    int insertSelective(MenuResourcePo record);

    MenuResourcePo selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(MenuResourcePo record);

    int updateByPrimaryKey(MenuResourcePo record);
}