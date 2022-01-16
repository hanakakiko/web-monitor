package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.po.UserPo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserPo selectUser(String username) {
        return new UserPo();
    }
}
