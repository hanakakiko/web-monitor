package com.dingjiangying.webmonitor.dao;

import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.TaskPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskPoMapper {
    int countByExample(TaskPoExample example);

    int deleteByExample(TaskPoExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(TaskPo record);

    int insertSelective(TaskPo record);

    List<TaskPo> selectByExample(TaskPoExample example);

    TaskPo selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TaskPo record, @Param("example") TaskPoExample example);

    int updateByExample(@Param("record") TaskPo record, @Param("example") TaskPoExample example);

    int updateByPrimaryKeySelective(TaskPo record);

    int updateByPrimaryKey(TaskPo record);
}