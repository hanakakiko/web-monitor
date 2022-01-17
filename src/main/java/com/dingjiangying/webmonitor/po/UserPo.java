package com.dingjiangying.webmonitor.po;


public class UserPo {
    private Integer userId;

    /**
     * 用户名，unique，varchar(50)
     */
    private String userName;

    /**
     * 密码，注入的时候要加密，varchar(50)
     */
    private String userPassword;

    /**
     * 类型，管理员0，用户1
     */
    private Integer userType;

    /**
     * 有几个告警状态的任务
     */
    private Integer alertTaskCount;

    /**
     * 联系方式,json格式{"mail":"1104349906@qq.com","phone":1234567}
     */
    private String contact;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAlertTaskCount() {
        return alertTaskCount;
    }

    public void setAlertTaskCount(Integer alertTaskCount) {
        this.alertTaskCount = alertTaskCount;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
}