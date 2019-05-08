package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.ActivityDao;
import com.cyt.graduation_project.business.entry.activity.ActivityChars;
import com.cyt.graduation_project.business.entry.activity.ActivityInfo;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;
    //查询所有的支教活动信息
    public ArrayList<ActivityInfo> queryAllActivityInfo(int page,int pageSize){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.queryAllActivityInfo(startIndex,pageSize);
    }

    //查询所有的已发布支教活动信息
    public ArrayList<ActivityInfo> queryAllActivityInfoPublished(int page,int pageSize){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.queryAllActivityInfoPublished(startIndex,pageSize);
    }

    //获取活动数量
    public int getActivityAccount(){
        return activityDao.getActivityAccount();
    }


    //获取已发布活动数量
    public int getActivityAccountPublished(){
        return activityDao.getActivityAccountPublished();
    }
    //新增支教活动信息
    public boolean addActivityInfo(ActivityInfo activityInfo){
        return activityDao.addActivityInfo(activityInfo);
    }

    //通过活动id修改支教活动信息（未审核之前可以修改）
    public boolean editActivityInfoById(ActivityInfo activityInfo){
        return activityDao.editActivityInfoById(activityInfo);
    }

    //通过活动id删除支教活动信息（未审核之前可以删除 0表示未审核）

    public boolean deleteActivityInfoById(int activityId){
        return activityDao.deleteActivityInfoById(activityId);
    }

    //管理员删除支教活动信息
    public boolean deleteActivity(int activityId){
        return activityDao.deleteActivity(activityId);
    }

    //通过用户id查找活动信息

    public ArrayList<ActivityInfo> queryActivityInfoByUserId(int page,int pageSize,int userId){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.queryActivityInfoByUserId(startIndex,pageSize,userId);
    }

    //通过活动id查找活动信息

    public ActivityInfo queryActivityInfoByActivityId(ActivityInfo activityInfo){
        return activityDao.queryActivityInfoByActivityId(activityInfo);
    }


    //通过条件查询活动数据
    public ArrayList<ActivityInfo> getActivityInfoByCondition(int page,int pageSize,String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.getActivityInfoByCondition(startIndex,pageSize,condition);
    }

    //通过条件查询发布志愿者活动数据
    public ArrayList<ActivityInfo> getActivityPublishInfoByCondition(int page,int pageSize,String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.getActivityPublishInfoByCondition(startIndex,pageSize,condition);
    }

    //已登录状态的用户查询个人申请的志愿活动数据
    public ArrayList<ActivityInfo> getPersonalActivityInfoByUserId(int page,int pageSize,int userId){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.queryActivityInfoByUserId(startIndex,pageSize,userId);
    }

    //通过活动状态查询活动数据
    public ArrayList<ActivityInfo> getActivityInfoByState(int page,int pageSize,int state){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return activityDao.getActivityInfoByState(startIndex,pageSize,state);
    }


    //查询已经登录用户申请的志愿活动数量

    public int queryActivityNumByUserLoging(int userId){
        return activityDao.queryActivityNumByUserLoging(userId);
    }


    //更新支教活动信息状态
    public boolean updateActivityState(int activityId,int reviewStatus){

        return activityDao.updateActivityState(activityId,reviewStatus);

    }


    //查询对应的省份申报活动的数量
    public ArrayList<ActivityChars> getActivityCountByProvinceName(){
        return activityDao.getActivityCountByProvinceName();
    }

}
