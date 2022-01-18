package com.dingjiangying.webmonitor.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个是dashboard页面展示的vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryVo {

    /**
     * 平均用时（156ms）
     */
    private String averageTime;

    /**
     * 平均可用率（98.5%）
     */
    private String averageAvailability;

    /**
     * 平均可用率前三的探针
     */
    private List<ProbeVo> probeList;

    /**
     * 平均可用率前三的任务
     */
    private List<TaskVo> taskList;

}
