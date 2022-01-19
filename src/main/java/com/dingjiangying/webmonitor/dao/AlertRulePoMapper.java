package com.dingjiangying.webmonitor.dao;

import com.dingjiangying.webmonitor.po.AlertRulePo;
import com.dingjiangying.webmonitor.po.AlertRulePoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AlertRulePoMapper {
    int countByExample(AlertRulePoExample example);

    int deleteByExample(AlertRulePoExample example);

    int deleteByPrimaryKey(Integer alertId);

    int insert(AlertRulePo record);

    int insertSelective(AlertRulePo record);

    List<AlertRulePo> selectByExample(AlertRulePoExample example);

    AlertRulePo selectByPrimaryKey(Integer alertId);

    int updateByExampleSelective(@Param("record") AlertRulePo record, @Param("example") AlertRulePoExample example);

    int updateByExample(@Param("record") AlertRulePo record, @Param("example") AlertRulePoExample example);

    int updateByPrimaryKeySelective(AlertRulePo record);

    int updateByPrimaryKey(AlertRulePo record);
}