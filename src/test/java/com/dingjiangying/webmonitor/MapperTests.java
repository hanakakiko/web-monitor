package com.dingjiangying.webmonitor;

import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MapperTests {

    @Autowired
    UserPoMapper userPoMapper;


    @Test
    void contextLoads() throws SQLException {
        //insert
        UserPo userPo = new UserPo();
        userPo.setUserName("anyang");
        userPo.setUserPassword("pwd_sha");
        userPoMapper.insert(userPo);

        //search
        UserPoExample example = new UserPoExample();
        UserPoExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo("anyang");
        List<UserPo> users = userPoMapper.selectByExample(example);
        if (users != null) {
            for (UserPo u : users) {
                u.setContact("new_contact");
//                update
                userPoMapper.updateByPrimaryKey(u);
//                System.out.println(u.getUserName());
            }
        }

        example = new UserPoExample();
        criteria = example.createCriteria();
        criteria.andUserNameEqualTo("anyang");
        users = userPoMapper.selectByExample(example);
        if (users != null) {
            for (UserPo u : users) {
                u.setContact("new_contact");
                //update
                System.out.println(u.getUserName());
                System.out.println(u.getContact());
            }
        }

        //delete
        //result 是删除成功的数据条数
        int result = userPoMapper.deleteByExample(example);
        System.out.println(result);
    }

    private void testMail() {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setSubject("邮件发送测试");
//        simpleMailMessage.setText("测试下");
//        simpleMailMessage.setFrom("1104349906@qq.com");
//        simpleMailMessage.setTo("2000022759@stu.pku.edu.cn");
//        javaMailSender.send(simpleMailMessage);
    }

}
