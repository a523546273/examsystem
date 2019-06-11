package com.exam.examsystem.service.impl;

import com.exam.examsystem.dao.MenuResourceDao;
import com.exam.examsystem.service.MenuResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 17:49
 */
@Service
public class MenuResourceServiceImpl implements MenuResourceService {

    @Autowired
    private MenuResourceDao menuResourceDao;
}
