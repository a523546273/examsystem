package com.exam.examsystem.utils;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.examsystem.resp.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: hongwei.wang
 * @create: 2019-06-13 16:55
 */
public class ShiroFilterUtils {
    private static final Logger logger = LoggerFactory
            .getLogger(ShiroFilterUtils.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param request
     * @return
     * @描述：判断请求是否是ajax
     */
    public static boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            logger.debug("shiro工具类【wyait-manager-->ShiroFilterUtils.isAjax】当前请求,为Ajax请求");
            return Boolean.TRUE;
        }
        logger.debug("shiro工具类【wyait-manager-->ShiroFilterUtils.isAjax】当前请求,非Ajax请求");
        return Boolean.FALSE;
    }

    /**
     * @param response
     * @param result
     * @描述：response输出json
     */
    public static void out(HttpServletResponse response, ResponseData result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");//设置编码
            response.setContentType("application/json");//设置返回类型
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(result));//输出
            logger.error("用户在线数量限制【wyait-manage-->ShiroFilterUtils.out】响应json信息成功");
        } catch (Exception e) {
            logger.error("用户在线数量限制【wyait-manage-->ShiroFilterUtils.out】响应json信息出错", e);
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
