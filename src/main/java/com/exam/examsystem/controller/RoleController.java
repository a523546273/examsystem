package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.po.RolePo;
import com.exam.examsystem.req.RoleRequest;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.service.RoleService;
import com.exam.examsystem.utils.QueryFilterUtils;
import com.exam.examsystem.utils.ResponseDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hongwei.wang
 * @create: 2019-06-14 10:06
 */
@Controller
@RequestMapping(value = "/role/*", produces = BizMessageConstants.MEDIATYPE_UTF8_APPLICATION_JOSN)
public class RoleController {

    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("roleList")
    @ResponseBody
    public PageResult<RolePo> userList(HttpServletRequest request) {

        RoleRequest queryFilter = QueryFilterUtils.createQueryFilter(request, RoleRequest.class);

        PageResult<RolePo> userPoPageResult = roleService.selectAllRole(queryFilter);

        return userPoPageResult;
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public ResponseData updateStatus(@RequestParam Integer roleid, @RequestParam String validity) {
        try {
            boolean result = roleService.updateStatus(roleid, validity);
            if (!result) {
                ResponseDataUtil.buildError(ResultEnums.ERROR);
            }
        } catch (Exception e) {
            logger.error("更新角色状态", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }


    @RequestMapping("removeRole")
    @ResponseBody
    public ResponseData removeRole(@RequestParam Integer roleid) {
        try {
            boolean result = roleService.removeRole(roleid);
            if (!result) {
                ResponseDataUtil.buildError(ResultEnums.ERROR);
            }
        } catch (Exception e) {
            logger.error("删除角色", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }
}
