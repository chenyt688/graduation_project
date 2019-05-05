package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.activity.JoinProcess;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class ParticipantsController {
    @Autowired
    private ParticipantsService participantsService;

    //新增用户报名数据
    @RequestMapping(value = "/insertParticipant",method = RequestMethod.PUT)
    public Object insertParticipant(int userId,int activityId){
        return participantsService.insertParticipant(userId,activityId);
    }


    //判断用户是否已经报名该活动
    @RequestMapping(value = "/queryParticipantIsExistence",method = RequestMethod.PUT)
    public Object queryParticipantIsExistence(int userId,int activityId){
        String flag = "S";
        int count = participantsService.queryParticipantIsExistence(userId,activityId);

        if(count >= 1){
            flag = "F";
        }
        return flag;
    }


    //查看最近用户报名的状况
    @RequestMapping("/queryJoinByUserId")
    public Object queryJoinByUserId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        JoinProcess joinProcess = participantsService.queryActivityInfoByUserId(user.getUserId());
        System.out.println(joinProcess);
        return  joinProcess;
    }
}
