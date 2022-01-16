package com.dingjiangying.webmonitor.dao;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 获取所有部门信息
    List<UserPo> getUsers();

    // 通过id获得部门
    UserPo getUserById(Integer userId);

    UserPo getUserByName(String Username);

    Long insertUser(@Param("po") UserPo po);

}
