package com.dingjiangying.webmonitor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertRuleVo {

    private Integer alertId;

    /**
     * 用户定义的, 同一个用户下不允许重名
     */
    private String alertName;

    /**
     * 告警类型，枚举类，超时；可用率过低；未包含指定元素；包含了不允许的元素等
     * @see(com.dingjiangying.webmonitor.enums.AlertTypeEnum)
     */
    private Integer alertType;

    /**
     * 有几个任务正在用它，为0才能删除
     */
    private Integer taskCount;

    /**
     * 单位ms的时间，单位%的可用率，或者元素名称列表
     */
    private String alertParam;

    private Integer userId;

    /**
     * 1 checked 0 not
     */
    private Integer checked;
}
