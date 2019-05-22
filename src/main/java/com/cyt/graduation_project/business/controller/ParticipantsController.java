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
import java.util.ArrayList;

@RestController
@CrossOrigin
public class ParticipantsController {
    @Autowired
    private ParticipantsService participantsService;

    //新增用户报名数据
    @RequestMapping(value = "/insertParticipant",method = RequestMethod.PUT)
    public Object insertParticipant(int userId,int activityId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        return participantsService.insertParticipant(user.getUserId(),activityId);
    }


    //判断用户是否已经报名该活动
    @RequestMapping(value = "/queryParticipantIsExistence",method = RequestMethod.PUT)
    public Object queryParticipantIsExistence(int userId,int activityId,HttpServletRequest request){
        String flag = "S";
        User user = (User) request.getSession().getAttribute("userInfo");
        int count = participantsService.queryParticipantIsExistence(user.getUserId(),activityId);

        if(count >= 1){
            flag = "F";
        }
        return flag;
    }


    //查看最近用户报名的状况
    @RequestMapping("/queryJoinByUserId")
    public Object queryJoinByUserId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        ArrayList<JoinProcess> joinProcessList = participantsService.queryActivityInfoByUserId(user.getUserId());
        if(joinProcessList==null || joinProcessList.size() == 0){
            return "F";
        }
        return  joinProcessList;

    }


    //登录用户查看自己申请的活动报名状况
    @RequestMapping(value = "/queryAllJoinInfo",method = RequestMethod.PUT)
    public Object queryAllJoinInfo(int page, int pageSize,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null){
            return participantsService.queryAllJoinInfo(page,pageSize,user.getUserId());
        }
        return "";

    }

    //登录用户查看自己申请的活动的数量
    @RequestMapping("/queryParticipantNum")
    public int queryParticipantNum(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null){
            return participantsService.queryParticipantNum(user.getUserId());
        }
        return 0;


    }

    //修改报名用户的报名状态
    @RequestMapping(value = "/updateJoinState",method = RequestMethod.PUT)
    public boolean updateJoinState(int userId,int activityId,int reviewStatus){
        return participantsService.updateJoinState(userId,activityId,reviewStatus);
    }

    //删除报名信息
    @RequestMapping(value = "/deleteById",method = RequestMethod.PUT)
    public Object deleteById(int id){
        return participantsService.deleteById(id);
    }
}
