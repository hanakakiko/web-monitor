package com.dingjiangying.webmonitor.po;

import java.sql.Time;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class logPo {

    /**
     * int auto_increment primary key
     */
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
    private Timestamp timestamp;

    /**
     * 是否被告警程序检测过了（方便起见，不再有程序定时更新summary信息，用户查看的时候现算）
     */
    private Integer hasHandled;

    /**
     * 执行任务用时（Time能表示时间段吗？还是时间点？）
     */
    private Time totalTime;

    /**
     * 执行任务状态码（200ok还是别的）
     */
    private Integer errorCode;

    /**
     * 执行puppeteer脚本的输出，在数据库某个目录下为每个logId建一个目录存放它的输出，里面可能有.har文件，可能有.jpg，.pdf
     */
    private String scriptOutputPath;

}
