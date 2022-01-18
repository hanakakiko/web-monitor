package com.dingjiangying.webmonitor.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Util {
    public static String getCurrentUserName(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "游客";
        }
        return (String) session.getAttribute("currentUser");
    }

    public static Integer getCurrentUserId(HttpSession session) {
        Integer currentUserId = (Integer) session.getAttribute("currentUserId");
        return currentUserId;
    }

    public static List<String> getList(String list) {//"[1,2,3]"
        if(Strings.isNotBlank(list)){
            String[] strignList = list.replace("[]", "").split(",");
            return Arrays.asList(strignList);
        }
        return new ArrayList<>();
    }

    public static String getFromList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                result.append(",");
            }
            result.append(list.get(i).toString());
        }
        return result.toString();
    }

    public static Timestamp getCurrentTime() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return currentTime;
    }

    public static Date stringToDate(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");//日期格式
        String tiem = sformat.format(date);

        return tiem;
    }

    public static void main(String[] args) {
        System.out.println(dateToString(new Date()));
    }
}
