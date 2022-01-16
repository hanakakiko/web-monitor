package com.dingjiangying.webmonitor.form;

import com.dingjiangying.webmonitor.po.UserPo;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserInfo {
    String username;
    String password;

    public UserPo covertToPo(){
        return new UserPo(null,username,password,1,0,null);
    }
}
