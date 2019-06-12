package com.exam.examsystem.req;

import javax.validation.constraints.NotBlank;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 15:32
 */
public class UserForm {

    @NotBlank
    private String loginname;
    @NotBlank
    private String password;
    @NotBlank
    private String mobilePhone;

    private Integer userid;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
