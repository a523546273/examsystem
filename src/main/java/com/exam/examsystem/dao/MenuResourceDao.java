package com.exam.examsystem.dao;

import com.exam.examsystem.dto.MenuResourceDto;
import com.exam.examsystem.po.MenuResourcePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuResourceDao {
    int deleteByPrimaryKey(Integer menuid);

    int insert(MenuResourcePo record);

    int insertSelective(MenuResourcePo record);

    MenuResourcePo selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(MenuResourcePo record);

    int updateByPrimaryKey(MenuResourcePo record);

    List<MenuResourcePo> selectAllMenuResource();

    List<MenuResourceDto> selectMenuResourceByLevels(@Param("levels") String levels);

    List<MenuResourceDto> selectMenuResourceByParentmenuid(@Param("parentmenuid")Integer parentmenuid);
}