package com.exam.examsystem.resp;

import com.exam.examsystem.enums.ResultEnums;

import java.io.Serializable;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 14:12
 */
public class ResponseData<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    private boolean success;


    public ResponseData(String code, String msg, T data, boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public ResponseData(String code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ResponseData(ResultEnums resultEnums, boolean success) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.success = success;
    }

    public ResponseData(ResultEnums resultEnums, T data, boolean success) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
        this.success = success;
    }

    public ResponseData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
