package com.dingjiangying.webmonitor.form;

import com.dingjiangying.webmonitor.po.UserPo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserInfo {
    String username;
    String password;

    public UserPo covertToPo() {
        UserPo user = new UserPo();
        user.setUserName(username);
        user.setUserPassword(password);
        return user;
    }
}
