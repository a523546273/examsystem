package com.exam.examsystem.enums;

/**
 * @author: hongwei.wang
 * @create: 2019-06-11 14:14
 */
public enum ResultEnums {

    SUCCESS("0", "请求成功"),
    ERROR("1", "请求失败"),
    SYSTEM_ERROR("10001", "请求服务器异常"),
    NO_USER("10002", "用户名或者密码错误"),
    USER_STATUS_ERROR("10003", "用户状态异常"),
    USER_UPDATE("10004", "当前用户的信息或权限已变更，重新登录后生效"),
    VERIFY_CODE_ERROR("20002", "业务参数错误"),
    USER_PASSWORD_ERROR("10005", "用户名或密码错误次数大于5次,账户已锁定!</br>" +
            "<span style='color:red;font-weight:bold; '>2分钟后可再次登录，或联系管理员解锁</span>"),
    USER_NULL("10006", "用户不存在"),

    FORBIDDEN("403", "权限不足");

    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
