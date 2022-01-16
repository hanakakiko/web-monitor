package com.dingjiangying.webmonitor.po;

public class ProbePo {
    private Integer probeId;

    /**
     * 探针名称，管理员创建时输入
     */
    private String probeName;

    /**
     * 探针ssh用户名和ip和端口号和密码:"root@101.200.161.136:2222 password"
     */
    private String sshPwd;

    /**
     * 探针是管理员创建的还是用户创建的，管理员0，用户1
     */
    private Integer probeType;

    /**
     * 探针状态，未运行（创建未启动或被管理员关闭）0，运行中1，满负荷2，无心跳（故障）3
     */
    private Integer probeStatus;

    /**
     * 探针是谁创建的
     */
    private Integer userId;

    /**
     * 正在运行的任务id列表，varchar(1024)
     */
    private String taskList;

    /**
     * 待更新的任务id列表，varchar(1024)
     */
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