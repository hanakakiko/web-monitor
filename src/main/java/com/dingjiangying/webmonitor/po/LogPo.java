package com.dingjiangying.webmonitor.po;

import java.util.Date;

public class LogPo {
    private Integer logId;

    /**
     * 所属探针
     */
    private Integer probeId;

    /**
     * 所属任务
     */
    private Integer taskId;

    /**
     * 时间戳
     */
    private Date timestamp;

    /**
     * 是否被告警程序检测过了（方便起见，不再有程序定时更新summary信息，用户查看的时候现算）
     */
    private Integer hasHandled;

    /**
     * 执行任务用时（Time能表示时间段吗？还是时间点？）
     */
    private Long totalTime;

    /**
     * 执行任务状态码（200ok还是别的）
     */
    private Integer errorCode;

    /**
     * 执行puppeteer脚本的输出，在数据库某个目录下为每个logId建一个目录存放它的输出，里面可能有.har文件，可能有.jpg，.pdf
     */
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