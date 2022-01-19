package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.util.CollectionUtils;

@Service
public class UserService {
    @Resource
    UserPoMapper userPoMapper;

    public UserPo selectUser(String username) {
        UserPoExample userPoExample = new UserPoExample();
        userPoExample.createCriteria().andUserNameEqualTo(username);
        List<UserPo> userPos = userPoMapper.selectByExample(userPoExample);
        if(!CollectionUtils.isEmpty(userPos)){
            return userPos.get(0);
        }
        return null;
    }

//    public boolean checkLogin(String username, String pwd) {
//
//    }

}
