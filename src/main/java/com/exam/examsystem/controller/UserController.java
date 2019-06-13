package com.exam.examsystem.controller;

import com.exam.examsystem.constants.BizMessageConstants;
import com.exam.examsystem.constants.SessionConstants;
import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.dto.UserDto;
import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.req.UserForm;
import com.exam.examsystem.req.UserRequest;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.service.UserService;
import com.exam.examsystem.utils.QueryFilterUtils;
import com.exam.examsystem.utils.ResponseDataUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 10:35
 */
@Controller
@RequestMapping(value = "/user/*", produces = BizMessageConstants.MEDIATYPE_UTF8_APPLICATION_JOSN)
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("userList")
    @ResponseBody
    public PageResult<UserPo> userList(HttpServletRequest request) {

        UserRequest queryFilter = QueryFilterUtils.createQueryFilter(request, UserRequest.class);

        PageResult<UserPo> userPoPageResult = userService.selectAllUser(queryFilter);

        return userPoPageResult;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public ResponseData addUser(@Valid UserForm form, HttpServletRequest request) {

        int userid = (int) request.getSession().getAttribute(SessionConstants.WSSIP_OPERATOR_ID);
        form.setUserid(userid);

        try {
            userService.addUser(form);
        } catch (Exception e) {
            logger.error("addUser", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }

    @RequestMapping("removeUser")
    @ResponseBody
    public ResponseData removeUser(@RequestParam Integer userid) {
        try {
            boolean result = userService.removeUser(userid);
            if (!result) {
                ResponseDataUtil.buildError(ResultEnums.ERROR);
            }
        } catch (Exception e) {
            logger.error("removeUser", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public ResponseData updateStatus(@RequestParam Integer userid, @RequestParam String status) {
        try {
            boolean result = userService.updateStatus(userid, status);
            if (!result) {
                ResponseDataUtil.buildError(ResultEnums.ERROR);
            }
        } catch (Exception e) {
            logger.error("removeUser", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }


    @RequestMapping("removeUserBatch")
    @ResponseBody
    public ResponseData removeUserBatch(@RequestParam String ids) {
        try {
            boolean result = userService.removeUserBatch(ids);
            if (!result) {
                ResponseDataUtil.buildError(ResultEnums.ERROR);
            }
        } catch (Exception e) {
            logger.error("removeUser", e);
            return ResponseDataUtil.buildError(e.getMessage());
        }
        return ResponseDataUtil.buildSuccess();
    }

}
