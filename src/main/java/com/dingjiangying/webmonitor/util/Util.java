package com.dingjiangying.webmonitor.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Util {
    public static String getCurrentUserName(HttpSession session){
        if (session.getAttribute("currentUser")==null){
            return "游客";
        }
        return (String) session.getAttribute("currentUser");
    }

    public static List<String> getList(String list){//"[1,2,3]"
        String[] strignList = list.replace("[]","").split(",");
        return Arrays.asList(strignList);
    }
}
