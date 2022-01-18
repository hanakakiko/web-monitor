package com.dingjiangying.webmonitor.vo;

import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskVo {

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
     * 要在哪些探针上运行，是个probeId列表
     */
    private List<Integer> probeList;

    /**
     * probeId转换成名字
     */
    private String probeListNames;

    //    /**
    //     * 探测频率，是个枚举类型，1min、5min、15min、60min等，暂时不用
    //     */
    //    private Integer cycle;

    /**
     * 脚本路径，暂时也存在mysql所在服务器上的目录,前端处理成一个按钮，点进去看详情
     */
//    private String scriptPath;

    private String script;



    /**
     * 建表的时候就等于current_time
     */
    private String createTime;

    /**
     * 建表的时候就设置每次update都修改为current_time
     */
    private String umpdateTime;

    /**
     * 应用了哪些告警规则，是个列表
     */
    private List<String> alertNameList;

    /**
     * 0是刚创建，1是被调度程序处理过
     */
    private Integer hasHuddled;
}
