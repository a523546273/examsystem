package com.exam.examsystem.utils;

import com.exam.examsystem.enums.ResultEnums;
import com.exam.examsystem.resp.ResponseData;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 14:13
 */
public class ResponseDataUtil {

    private final static boolean TRUE = true;
    private final static boolean FALSE = false;

    /**
     * 带实体的统一返回
     *
     * @param data 实体
     * @param <T>  实体类型
     * @return
     */
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResultEnums.SUCCESS, data, TRUE);
    }

    public static ResponseData buildSuccess() {
        return new ResponseData(ResultEnums.SUCCESS, TRUE);
    }

    public static ResponseData buildSuccess(String msg) {
        return new ResponseData(ResultEnums.SUCCESS.getCode(), msg, TRUE);
    }

    public static ResponseData buildSuccess(String code, String msg) {
        return new ResponseData(code, msg, TRUE);
    }

    public static <T> ResponseData buildSuccess(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data, TRUE);
    }

    public static ResponseData buildSuccess(ResultEnums resultEnums) {
        return new ResponseData(resultEnums, TRUE);
    }

    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResultEnums.ERROR, data, FALSE);
    }

    public static ResponseData buildError() {
        return new ResponseData(ResultEnums.ERROR, FALSE);
    }

    public static ResponseData buildError(String msg) {
        return new ResponseData(ResultEnums.ERROR.getCode(), msg, FALSE);
    }

    public static ResponseData buildError(String code, String msg) {
        return new ResponseData(code, msg, FALSE);
    }

    public static <T> ResponseData buildError(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data, FALSE);
    }

    public static ResponseData buildError(ResultEnums resultEnums) {
        return new ResponseData(resultEnums, FALSE);
    }
}
