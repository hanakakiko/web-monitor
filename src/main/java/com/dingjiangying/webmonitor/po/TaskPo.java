package com.dingjiangying.webmonitor.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskPo {

    private String taskId;
    private String taskName;
    private String cityList;
    private Timestamp createTime;
    private Integer hasHuddled;
    private String userId;
    private String alertId;

}
