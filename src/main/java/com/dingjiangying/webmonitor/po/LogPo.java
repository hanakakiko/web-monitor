package com.dingjiangying.webmonitor.po;

import java.util.Date;

public class LogPo {
    private Integer logId;

    private Integer probeId;

    private Integer taskId;

    private Date timestamp;

    private Integer hasHandled;

    private Long totalTime;

    private Integer errorCode;

    private String scriptOutputPath;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getProbeId() {
        return probeId;
    }

    public void setProbeId(Integer probeId) {
        this.probeId = probeId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getHasHandled() {
        return hasHandled;
    }

    public void setHasHandled(Integer hasHandled) {
        this.hasHandled = hasHandled;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getScriptOutputPath() {
        return scriptOutputPath;
    }

    public void setScriptOutputPath(String scriptOutputPath) {
        this.scriptOutputPath = scriptOutputPath == null ? null : scriptOutputPath.trim();
    }
}