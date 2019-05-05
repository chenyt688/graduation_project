package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.ActivityDao;
import com.cyt.graduation_project.business.dao.ParticipantsDao;
import com.cyt.graduation_project.business.entry.activity.ActivityInfo;
import com.cyt.graduation_project.business.entry.activity.JoinProcess;
import com.cyt.graduation_project.business.entry.userinfo.ParticipantsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public JoinProcess queryActivityInfoByUserId(int userId){
       ParticipantsInfo participantsInfo  = participantsDao.queryJoinInfoByUserId(userId);
       ActivityInfo activityInfo=  activityDao.queryActivityInfoById(participantsInfo.getActivityId());
       JoinProcess joinProcess = new JoinProcess(participantsInfo.getReviewStatus(),activityInfo.getTopic());
       return joinProcess;
    }
}
