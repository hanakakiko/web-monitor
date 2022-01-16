package com.dingjiangying.webmonitor.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {

    /**
     * int auto_increment primary key
     */
    private Integer userId;

    /**
     * 用户名，unique，varchar(50)
     */
    private String userName;

    /**
     * 密码，注入的时候要加密，varchar(50)
     */
    private String userPassword;

    /**
     * 类型，管理员0，用户1
     */
    private Integer userType;

    /**
     * 有几个告警状态的任务
     */
    private Integer alertTaskCount;

    /**
     * 联系方式,json格式{"mail":"1104349906@qq.com","phone":1234567}
     */
    private String contact;

    //    CREATE TABLE `user` (
//            `id` int(11) NOT NULL AUTO_INCREMENT,
//            `username` varchar(20) DEFAULT NULL,
//            `password` varchar(20) DEFAULT NULL,
//            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
//    PRIMARY KEY (`id`)
//) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
}
