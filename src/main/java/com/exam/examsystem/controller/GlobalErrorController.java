package com.exam.examsystem.controller;

import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.resp.ResponseData;
import com.exam.examsystem.utils.ResponseDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @项目名称：wyait-manage
 * @包名：com.wyait.manage.web.error
 * @类描述：普通请求统一使用error页面处理，异步请求，返回统一的Result(status,message,data)对象
 * @version：V1.0
 */
@Controller
public class GlobalErrorController  {


    @RequestMapping(value = "/unauthorized")
    @ResponseBody
    public ResponseData unauthorized() {
        return ResponseDataUtil.buildError(ResultEnums.FORBIDDEN);
    }


}
