package com.dingjiangying.webmonitor.po;

public class UserPo {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userType;

    private Integer alertTaskCount;

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