package com.dingjiangying.webmonitor.po;

public class AlertRulePo {
    private Integer alertId;

    /**
     * 用户定义的, 同一个用户下不允许重名
     */
    private String alertName;

    /**
     * 告警类型，枚举类，超时；可用率过低；未包含指定元素；包含了不允许的元素等
     */
    private Integer alertType;

    /**
     * 有几个任务正在用它，为0才能删除
     */
    private Integer taskCount;

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName == null ? null : alertName.trim();
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }
}