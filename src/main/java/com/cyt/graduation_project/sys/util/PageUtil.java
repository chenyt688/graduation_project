package com.cyt.graduation_project.sys.util;

public class PageUtil {
    //获取数据范围
    public static int getPageArea(int page,int pageSize){
        int pageStart = (page-1)*pageSize;
        return pageStart;
    }
}
