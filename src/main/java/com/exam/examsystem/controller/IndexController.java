package com.exam.examsystem.controller;

import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.po.MenuResourcePo;
import com.exam.examsystem.service.MenuResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 15:29
 */
@Controller
public class IndexController {

    @Autowired
    private MenuResourceService menuResourceService;

    @RequestMapping("/index.html")
    public ModelAndView index(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/index/index");
        String loginname = (String) request.getSession().getAttribute(SessionConstants.WSSIP_OPERATOR_LOGINNAME);
        List<MenuResourcePo> menuResourcePos =null;
        if ("admin".equals(loginname)) {
             menuResourcePos = menuResourceService.selectAllMenuResource();
        }
        modelAndView.addObject("menuList",menuResourcePos);

        return modelAndView;
    }
}
