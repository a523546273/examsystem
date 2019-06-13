package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.dto.MenuResourceDto;
import com.exam.examsystem.po.MenuResourcePo;
import com.exam.examsystem.service.MenuResourceService;
import com.exam.examsystem.utils.UserRequestUtils;
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
@RequestMapping("/index/*")
public class IndexController {

    @Autowired
    private MenuResourceService menuResourceService;

    @RequestMapping("main.html")
    public ModelAndView index(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/index/index");
        String loginname = UserRequestUtils.getCurrentUser().getLoginname();
        List<MenuResourceDto> menuResourcePos = null;

        if ("admin".equals(loginname)) {
            menuResourcePos = menuResourceService.selectMenuResourceByLevels(BizMessageConstants.LEVELS_1);

            for (MenuResourceDto menuResourceDto : menuResourcePos) {
                List<MenuResourceDto> menuResourceDtos = menuResourceService.selectMenuResourceByParentmenuid(menuResourceDto.getMenuid());
                menuResourceDto.setChild(menuResourceDtos);
            }
        } else {

        }

        modelAndView.addObject("menuList", menuResourcePos);

        return modelAndView;
    }

    @RequestMapping("/doCenter")
    public ModelAndView index(String url) {

        return new ModelAndView(url);
    }
}
