package com.dingjiangying.webmonitor.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactVo {

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 电话
     */
    private String phone;
}
