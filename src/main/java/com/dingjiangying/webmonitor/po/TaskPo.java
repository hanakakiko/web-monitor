package com.dingjiangying.webmonitor.po;

import java.util.Date;

public class TaskPo {
    private Integer taskId;

    /**
     * 用户定义的task_name, 同一个用户下不允许重名
     */
    private String taskName;

    /**
     * 用户要求探测的url，可以重复
     */
    private String taskUrl;

    /**
     * 要在哪些探针上运行，是个列表，对应probe_id
     */
    private String cityList;

    /**
     * 建表的时候就等于current_time
     */
    private Date createTime;

    /**
     * 0是刚创建，1是被调度程序处理过
     */
    private Integer hasHuddled;

    /**
     * 属于哪个用户，跟user表里的userId对应
     */
    private Integer userId;

    /**
     * 应用了哪些告警规则，是个列表
     */
    private Integer alertId;

    /**
     * 有几条未读的告警日志
     */
    private Integer alertCount;

    /**
     * 建表的时候就设置每次update都修改为current_time
     */
    private Date umpdateTime;

    /**
     * 脚本路径，暂时也存在mysql所在服务器上的目录
     */
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