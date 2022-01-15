package com.dingjiangying.webmonitor.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {
    Integer id;

    String username;

    String password;

//    CREATE TABLE `user` (
//            `id` int(11) NOT NULL AUTO_INCREMENT,
//            `username` varchar(20) DEFAULT NULL,
//            `password` varchar(20) DEFAULT NULL,
//            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
//    PRIMARY KEY (`id`)
//) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
}
