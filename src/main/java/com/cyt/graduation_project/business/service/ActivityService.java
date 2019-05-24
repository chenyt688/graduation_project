package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.ActivityDao;
import com.cyt.graduation_project.business.dao.AddressDao;
import com.cyt.graduation_project.business.entry.activity.ActivityChars;
import com.cyt.graduation_project.business.entry.activity.ActivityInfo;
import com.cyt.graduation_project.business.entry.activity.AnalysisData;
import com.cyt.graduation_project.business.entry.position.Province;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private AddressDao addressDao;

    //查询所有的支教活动信息
    public ArrayList<ActivityInfo> queryAllActivityInfo(int page, int pageSize) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.queryAllActivityInfo(startIndex, pageSize);
    }

    //查询所有的已发布支教活动信息
    public ArrayList<ActivityInfo> queryAllActivityInfoPublished(int page, int pageSize) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.queryAllActivityInfoPublished(startIndex, pageSize);
    }

    //获取活动数量
    public int getActivityAccount() {
        return activityDao.getActivityAccount();
    }


    //获取已发布活动数量
    public int getActivityAccountPublished() {
        return activityDao.getActivityAccountPublished();
    }

    //新增支教活动信息
    public boolean addActivityInfo(ActivityInfo activityInfo) {
        return activityDao.addActivityInfo(activityInfo);
    }

    //通过活动id修改支教活动信息（未审核之前可以修改）
    public boolean editActivityInfoById(ActivityInfo activityInfo) {
        return activityDao.editActivityInfoById(activityInfo);
    }

    //通过活动id删除支教活动信息（未审核之前可以删除 0表示未审核）

    public boolean deleteActivityInfoById(int activityId) {
        return activityDao.deleteActivityInfoById(activityId);
    }

    //管理员删除支教活动信息
    public boolean deleteActivity(int activityId) {
        return activityDao.deleteActivity(activityId);
    }

    //通过用户id查找活动信息

    public ArrayList<ActivityInfo> queryActivityInfoByUserId(int page, int pageSize, int userId) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.queryActivityInfoByUserId(startIndex, pageSize, userId);
    }

    //通过活动id查找活动信息

    public ActivityInfo queryActivityInfoByActivityId(ActivityInfo activityInfo) {
        return activityDao.queryActivityInfoByActivityId(activityInfo);
    }


    //通过条件查询活动数据
    public ArrayList<ActivityInfo> getActivityInfoByCondition(int page, int pageSize, String condition) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.getActivityInfoByCondition(startIndex, pageSize, condition);
    }

    //通过条件查询发布志愿者活动数据
    public ArrayList<ActivityInfo> getActivityPublishInfoByCondition(int page, int pageSize, String condition) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.getActivityPublishInfoByCondition(startIndex, pageSize, condition);
    }

    //已登录状态的用户查询个人申请的志愿活动数据
    public ArrayList<ActivityInfo> getPersonalActivityInfoByUserId(int page, int pageSize, int userId) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.queryActivityInfoByUserId(startIndex, pageSize, userId);
    }

    //通过活动状态查询活动数据
    public ArrayList<ActivityInfo> getActivityInfoByState(int page, int pageSize, int state) {
        int startIndex = PageUtil.getPageArea(page, pageSize);
        return activityDao.getActivityInfoByState(startIndex, pageSize, state);
    }


    //查询已经登录用户申请的志愿活动数量

    public int queryActivityNumByUserLoging(int userId) {
        return activityDao.queryActivityNumByUserLoging(userId);
    }


    //更新支教活动信息状态
    public boolean updateActivityState(int activityId, int reviewStatus) {

        return activityDao.updateActivityState(activityId, reviewStatus);

    }


    //查询对应的省份申报活动的数量
    public ArrayList<ActivityChars> getActivityCountByProvinceName(String year) {
        return activityDao.getActivityCountByProvinceName(year);
    }


    //根据年份获取每个省发布的支教志愿者活动的数量
    public ArrayList<AnalysisData> getProvinctNumByYear() {

        //用于保存预测各个身份的值
        ArrayList<AnalysisData> analysisDataArrayList = new ArrayList<AnalysisData>();
        //获取发布活动的最早年份
        String year = activityDao.getYear();
        int yearStart = Integer.parseInt(year.substring(0, 4));
        //获取活动发布最晚年份
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int yearLatest = c.get(Calendar.YEAR);

        //获取所有的省份
        ArrayList<Province> provinceArrayList = addressDao.getAllProvinceName();
        //第一个取平均值
        ArrayList<ActivityChars> activityChars1 = activityDao.getProvinctNumByYear(yearStart + "");
        ArrayList<ActivityChars> activityChars2 = activityDao.getProvinctNumByYear(yearStart + 1 + "");
        ArrayList<ActivityChars> activityChars3 = activityDao.getProvinctNumByYear(yearStart + 2 + "");
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int k = 0;
        double xishu = 0.5;
        for (Province p : provinceArrayList) {
            for (ActivityChars ac : activityChars1) {
                if (ac.getProvinceName().equals(p.getProvinceName())) {
                    val1 = ac.getNum();
                    break;
                }
            }
            for (ActivityChars ac : activityChars2) {
                if (ac.getProvinceName().equals(p.getProvinceName())) {
                    val2 = ac.getNum();
                    break;
                }
            }
            for (ActivityChars ac : activityChars3) {
                if (ac.getProvinceName().equals(p.getProvinceName())) {
                    val3 = ac.getNum();
                    break;
                }
            }
            double avg = (val1 + val2 + val3) / 3;
            double lastVal = xishu * activityChars1.get(0).getNum() + avg * xishu;
            AnalysisData data = new AnalysisData();
            data.setProvinceName(p.getProvinceName());
            data.setNum(lastVal);
            analysisDataArrayList.set(k, data);
            k++;
        }
        int val4 = 0;
        int j = 0;
        for(yearStart=yearStart+1;yearStart <= yearLatest;yearStart++){
            ArrayList<ActivityChars> activityChars4 = activityDao.getProvinctNumByYear(yearStart + "");
            for (Province p : provinceArrayList) {
                for (ActivityChars ac : activityChars4) {
                    if (ac.getProvinceName().equals(p.getProvinceName())) {
                        val4 = ac.getNum();
                        break;
                    }

                }
                double d =0;
                for (AnalysisData data:analysisDataArrayList){
                    if(data.getProvinceName().equals(p.getProvinceName())){
                        d = data.getNum();
                        break;
                    }
                }

                double lastVal = xishu * val4 + d * xishu;
                AnalysisData data = new AnalysisData();
                data.setProvinceName(p.getProvinceName());
                data.setNum(lastVal);
                analysisDataArrayList.set(j, data);
                j++;
            }
        }
        return analysisDataArrayList;

    }
}
