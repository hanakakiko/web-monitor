package com.dingjiangying.webmonitor.po;

import java.util.Date;

public class TaskPo {
    private Integer taskId;

    private String taskName;

    private String taskUrl;

    private String cityList;

    private Date createTime;

    private Integer hasHuddled;

    private Integer userId;

    private Integer alertId;

    private Integer alertCount;

    private Date umpdateTime;

    private String scriptPath;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl == null ? null : taskUrl.trim();
    }

    public String getCityList() {
        return cityList;
    }

    public void setCityList(String cityList) {
        this.cityList = cityList == null ? null : cityList.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHasHuddled() {
        return hasHuddled;
    }

    public void setHasHuddled(Integer hasHuddled) {
        this.hasHuddled = hasHuddled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public Integer getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(Integer alertCount) {
        this.alertCount = alertCount;
    }

    public Date getUmpdateTime() {
        return umpdateTime;
    }

    public void setUmpdateTime(Date umpdateTime) {
        this.umpdateTime = umpdateTime;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath == null ? null : scriptPath.trim();
    }
}