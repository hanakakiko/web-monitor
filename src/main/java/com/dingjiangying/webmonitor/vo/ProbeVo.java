package com.dingjiangying.webmonitor.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProbeVo {

    /**
     * 探针名称，管理员创建时输入
     */
    private String probeName;

    /**
     * 探针是管理员创建的还是用户创建的，管理员0，用户1
     */
    private Integer probeType;

    /**
     * 探针状态，未运行（创建未启动或被管理员关闭）0，运行中1，满负荷2，无心跳（故障）3
     */
    private Integer probeStatus;

    /**
     * 正在运行的该用户的任务name列表，varchar(1024)
     */
    private List<String> taskList;

}
