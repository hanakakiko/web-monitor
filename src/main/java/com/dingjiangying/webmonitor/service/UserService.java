package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.po_back.UserPo_backup;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserPo_backup selectUser(String username) {
        return new UserPo_backup();
    }
}
