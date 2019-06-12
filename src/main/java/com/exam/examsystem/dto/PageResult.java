package com.exam.examsystem.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 11:38
 */
public class PageResult<T> {

    private List<T> data = new ArrayList<>();

    private long count;

    private int code;

    private String msg;

    public PageResult() {

    }

    public PageResult(List<T> data, long count) {
        this.code = 0;
        this.data = data;
        this.count = count;
    }

    public PageResult(List<T> data, long count, String msg) {
        this.code = 1;
        this.data = data;
        this.count = count;
        this.msg = msg;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
