package com.exam.examsystem.service;

import com.exam.examsystem.po.MenuResourcePo;

import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 17:49
 */
public interface MenuResourceService {

    /**
     * 查询所有的菜单资源
     * @return
     */
    List<MenuResourcePo> selectAllMenuResource();
}
