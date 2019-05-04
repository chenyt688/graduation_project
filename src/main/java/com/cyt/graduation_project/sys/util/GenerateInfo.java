package com.cyt.graduation_project.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GenerateInfo {
    //获取唯一账号
    public static String getAccount(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1]+idd[2]+idd[3];
    }

    //获取当前时间
    public static String getCurrentTime(){
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(t);
    }

}
