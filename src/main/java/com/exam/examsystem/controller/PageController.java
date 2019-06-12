package com.exam.examsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 14:52
 */
@Controller
@RequestMapping("/page/*")
public class PageController {


    @RequestMapping(value = {"/{base}/{url}.html"})
    public ModelAndView pageCenter(@PathVariable("base") String base,@PathVariable("url") String url) {
        return new ModelAndView(base+"/"+url);

    }
}
