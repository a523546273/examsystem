package com.exam.examsystem.service;

import com.exam.examsystem.dto.MenuResourceDto;
import com.exam.examsystem.po.MenuResourcePo;

import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 17:49
 */
public interface MenuResourceService {

    /**
     * 查询所有的菜单资源
     *
     * @return
     */
    List<MenuResourcePo> selectAllMenuResource();

    /**
     * 根据级别查询
     *
     * @param levels
     * @return
     */
    List<MenuResourceDto> selectMenuResourceByLevels(String levels);

    /**
     * 根据父节点查询所有子节点的数据
     *
     * @param parentmenuid 父节点
     * @return
     */
    List<MenuResourceDto> selectMenuResourceByParentmenuid(Integer parentmenuid);

}
