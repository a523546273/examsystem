package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.po.MenuResourcePo;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.service.MenuResourceService;
import com.exam.examsystem.utils.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-14 15:29
 */
@Controller
@RequestMapping(value = "/menuResource/*", produces = BizMessageConstants.MEDIATYPE_UTF8_APPLICATION_JOSN)
public class MenuResourceController {

    @Autowired
    private MenuResourceService menuResourceService;

    @ResponseBody
    @RequestMapping("selectAllMenuResource")
    public ResponseData<List<MenuResourcePo>> selectAllMenuResource() {
        List<MenuResourcePo> list = menuResourceService.selectAllMenuResource();
        return ResponseDataUtil.buildSuccess("0", "", list);
    }


}
