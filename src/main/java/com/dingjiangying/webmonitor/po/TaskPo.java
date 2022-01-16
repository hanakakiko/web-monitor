package com.dingjiangying.webmonitor.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskPo {

    /**
     * int auto_increment primary key
     */
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

//    /**
//     * 探测频率，是个枚举类型，1min、5min、15min、60min等，暂时不用
//     */
//    private Integer cycle;

    /**
     * 脚本路径，暂时也存在mysql所在服务器上的目录
     */
    private String scriptPath;

    /**
     * 建表的时候就等于current_time
     */
    private Timestamp createTime;

    /**
     * 建表的时候就设置每次update都修改为current_time
     */
    private Timestamp umpdateTime;

    /**
     * 0是刚创建，1是被调度程序处理过
     */
    private Integer hasHandled;

    /**
     * 属于哪个用户，跟user表里的userId对应
     */
    private String userId;

    /**
     * 应用了哪些告警规则，是个列表
     */
    private String alertId;

    /**
     * 有几条未读的告警日志
     */
    private Integer alertCount;

}
