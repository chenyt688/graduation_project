package com.cyt.graduation_project.sys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatUtil {
    public static String dateFormat(String logDate){
        //将字符串转化为时间
        Date logDate1 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z", Locale.US);
        try{
            logDate1 = sdf.parse(logDate);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        //转换时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(logDate1);
    }

    public static String dateFormat2(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date t = new Date();
        try {
            t = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(t);

    }

    public static String dateFormat3(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date t = new Date();
        try {
            t = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(t);

    }
}
