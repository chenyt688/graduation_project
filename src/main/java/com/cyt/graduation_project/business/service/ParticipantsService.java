package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.ActivityDao;
import com.cyt.graduation_project.business.dao.ParticipantsDao;
import com.cyt.graduation_project.business.entry.activity.ActivityInfo;
import com.cyt.graduation_project.business.entry.activity.JoinProcess;
import com.cyt.graduation_project.business.entry.relation.SignActivity;
import com.cyt.graduation_project.business.entry.userinfo.ParticipantsInfo;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ParticipantsService {
    @Autowired
    private ParticipantsDao participantsDao;
    @Autowired
    private ActivityDao activityDao;

    //新增用户报名数据
    public boolean insertParticipant(int userId,int activityId){
        return participantsDao.insertParticipant(userId,activityId);
    }


    //判断用户是否已经报名该活动
    public int queryParticipantIsExistence(int userId,int activityId){
        return participantsDao.queryParticipantIsExistence(userId,activityId);
    }

    //查看最近用户报名的状况
    @Transactional
    public ArrayList<JoinProcess> queryActivityInfoByUserId(int userId){
       ArrayList<ParticipantsInfo> participantsInfoList  = participantsDao.queryJoinInfoByUserId(userId);
       ArrayList<JoinProcess> joinProcessArrayList = new ArrayList<JoinProcess>();
       for(ParticipantsInfo participantsInfo:participantsInfoList){
           ActivityInfo activityInfo=  activityDao.queryActivityInfoById(participantsInfo.getActivityId());
           JoinProcess joinProcess = new JoinProcess(participantsInfo.getReviewStatus(),activityInfo.getTopic());
           joinProcessArrayList.add(joinProcess);
       }
       return joinProcessArrayList;
    }

    //登录用户查看自己申请的活动报名状况
    public ArrayList<SignActivity> queryAllJoinInfo(int page, int pageSize, int userId){
        int startIndex =PageUtil.getPageArea(page,pageSize);
        return participantsDao.queryAllJoinInfo(startIndex,pageSize,userId);

    }

    //登录用户查看自己申请的活动的数量
    public int queryParticipantNum(int userId){
        return participantsDao.queryParticipantNum(userId);

    }

    //修改报名用户的报名状态
    public boolean updateJoinState(int userId,int activityId,int reviewStatus){
        return participantsDao.updateJoinState(userId,activityId,reviewStatus);
    }

    //删除报名信息
    public boolean deleteById(int id){
        return participantsDao.deleteById(id);
    }

}
