package com.dingjiangying.webmonitor.po;

public class ProbePo {
    private Integer probeId;

    private String probeName;

    private String sshPwd;

    private Integer probeType;

    private Integer probeStatus;

    private Integer userId;

    private String taskList;

    private String activeTaskList;

    public Integer getProbeId() {
        return probeId;
    }

    public void setProbeId(Integer probeId) {
        this.probeId = probeId;
    }

    public String getProbeName() {
        return probeName;
    }

    public void setProbeName(String probeName) {
        this.probeName = probeName == null ? null : probeName.trim();
    }

    public String getSshPwd() {
        return sshPwd;
    }

    public void setSshPwd(String sshPwd) {
        this.sshPwd = sshPwd == null ? null : sshPwd.trim();
    }

    public Integer getProbeType() {
        return probeType;
    }

    public void setProbeType(Integer probeType) {
        this.probeType = probeType;
    }

    public Integer getProbeStatus() {
        return probeStatus;
    }

    public void setProbeStatus(Integer probeStatus) {
        this.probeStatus = probeStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTaskList() {
        return taskList;
    }

    public void setTaskList(String taskList) {
        this.taskList = taskList == null ? null : taskList.trim();
    }

    public String getActiveTaskList() {
        return activeTaskList;
    }

    public void setActiveTaskList(String activeTaskList) {
        this.activeTaskList = activeTaskList == null ? null : activeTaskList.trim();
    }
}