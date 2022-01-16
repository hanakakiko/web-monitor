package com.dingjiangying.webmonitor.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertPo {

    private String alertId;
    private String taskName;
    private String taskUrl;
    private String cityList;
    private Timestamp createTime;
    private Integer hasHuddled;
    private String userId;
    private String alertId;

}
