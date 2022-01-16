package com.dingjiangying.webmonitor.form;

import com.dingjiangying.webmonitor.po_back.UserPo_backup;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserInfo {
    String username;
    String password;

    public UserPo_backup covertToPo(){
        return new UserPo_backup(null,username,password);
    }
}
