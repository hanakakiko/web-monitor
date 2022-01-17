package com.dingjiangying.webmonitor.util;

import javax.servlet.http.HttpSession;

public class Util {
    public static String getCurrentUserName(HttpSession session){
        if (session.getAttribute("currentUser")==null){
            return "游客";
        }
        return (String) session.getAttribute("currentUser");
    }
}
