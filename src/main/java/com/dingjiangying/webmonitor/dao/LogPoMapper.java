package com.dingjiangying.webmonitor.dao;

import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.LogPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LogPoMapper {
    int countByExample(LogPoExample example);

    int deleteByExample(LogPoExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(LogPo record);

    int insertSelective(LogPo record);

    List<LogPo> selectByExample(LogPoExample example);

    LogPo selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") LogPo record, @Param("example") LogPoExample example);

    int updateByExample(@Param("record") LogPo record, @Param("example") LogPoExample example);

    int updateByPrimaryKeySelective(LogPo record);

    int updateByPrimaryKey(LogPo record);
}