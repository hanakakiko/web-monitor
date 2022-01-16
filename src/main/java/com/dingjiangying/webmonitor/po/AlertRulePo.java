package com.dingjiangying.webmonitor.po;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertRulePo {
    /**
     * int auto_increment primary key
     */
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
     * 告警参数，与alertType联合使用，比如超时阈值，可用率阈值，未包含的元素名，包含的元素名
     */
    private Map<String, Object> param;

    /**
     * 有几个任务正在用它，为0才能删除
     */
    private Integer taskCount;

}
