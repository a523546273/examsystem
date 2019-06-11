package com.exam.examsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 15:29
 */
@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public ModelAndView index(HttpServletRequest request) {



        return new ModelAndView("/index/index");
    }
}
