package com.dingjiangying.webmonitor.dao;
import com.dingjiangying.webmonitor.po.TaskPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    // 获取所有部门信息
    List<TaskPo> getTasks();

    // 通过id获得部门
    TaskPo getTask(String taskId);

}
