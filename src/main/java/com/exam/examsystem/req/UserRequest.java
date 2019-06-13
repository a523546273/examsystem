package com.exam.examsystem.req;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 11:27
 */
public class UserRequest extends BaseRequest {

    private String userType;
    private String mobilePhone;
    private Integer userid;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
