package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.entry.userinfo.UserResume;
import com.cyt.graduation_project.business.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    //通过用户id获取相应的简历
    @RequestMapping(value = "/getUserResumeByUserId",method = RequestMethod.PUT)
    public UserResume getUserResumeByUserId(HttpServletRequest request,Integer userIdStr){
        User user = (User) request.getSession().getAttribute(userIdStr+"");
        UserResume resume  = resumeService.getUserResumeByUserId(user);
        if(user != null){       //判断用户未登录前台界面不可操作
            if(resume == null){
                resume.setUserCareer("");
            }

        }

        return resume;
    }


    //通过用户id获取相应的简历
    @RequestMapping(value = "/getUserResumeInfoByUserId", method = RequestMethod.PUT)
    public UserResume getUserResumeInfoByUserId(int userId){
        UserResume resume  = resumeService.getUserResumeInfoByUserId(userId);

        return resume;
    }

    //查询所有的简历信息
    @RequestMapping("/getAllUserResume")
    public ArrayList<UserResume> getAllUserResume(){

         return resumeService.getAllUserResume();

    }

    //新增用户简历或者修改简历
    @RequestMapping("/insertOrEditUserResume")
    public Object insertOrEditUserResume(UserResume userResume){
        boolean flag = false;
        int num = resumeService.getUserResumeNumByUserId(userResume);
        userResume = dealUndefined(userResume);
        if(num == 0){
            flag = resumeService.insertUserResume(userResume);
        }else {
            return resumeService.updateUserResume(userResume);
        }
        return flag;
    }
    public UserResume dealUndefined(UserResume userResume){
        if (userResume.getUserCareer().equals("undefined")){
            userResume.setUserCareer(" ");
        }
        if (userResume.getEducationLevel().equals("undefined")){
            userResume.setEducationLevel(" ");
        }
        if (userResume.getTargetSubjectName().equals("undefined")){
            userResume.setTargetSubjectName(" ");
        }
        if (userResume.getSecondSubjectName().equals("undefined")){
            userResume.setSecondSubjectName(" ");
        }
        if (userResume.getEducation().equals("undefined")){
            userResume.setEducation(" ");
        }if (userResume.getHonor().equals("undefined")){
            userResume.setHonor(" ");
        }
        if (userResume.getHobby().equals("undefined")){
            userResume.setHobby(" ");
        }
        if (userResume.getSelfIntroduction().equals("undefined")){
            userResume.setSelfIntroduction(" ");
        }
        if (userResume.getExperience().equals("undefined")){
            userResume.setExperience(" ");
        }
        return userResume;
    }




}
