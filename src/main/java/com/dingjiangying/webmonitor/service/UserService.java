package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserPoMapper userPoMapper;

    public UserPo selectUser(String username) {
        return new UserPo();
    }

//    public boolean checkLogin(String username, String pwd) {
//
//    }

}
