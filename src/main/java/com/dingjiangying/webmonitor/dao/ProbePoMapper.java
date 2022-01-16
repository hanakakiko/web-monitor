package com.dingjiangying.webmonitor.dao;

import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.ProbePoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProbePoMapper {
    int countByExample(ProbePoExample example);

    int deleteByExample(ProbePoExample example);

    int deleteByPrimaryKey(Integer probeId);

    int insert(ProbePo record);

    int insertSelective(ProbePo record);

    List<ProbePo> selectByExample(ProbePoExample example);

    ProbePo selectByPrimaryKey(Integer probeId);

    int updateByExampleSelective(@Param("record") ProbePo record, @Param("example") ProbePoExample example);

    int updateByExample(@Param("record") ProbePo record, @Param("example") ProbePoExample example);

    int updateByPrimaryKeySelective(ProbePo record);

    int updateByPrimaryKey(ProbePo record);
}