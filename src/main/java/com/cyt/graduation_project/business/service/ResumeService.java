package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.ResumeDao;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.entry.userinfo.UserResume;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    //通过用户id获取相应的简历

    public UserResume getUserResumeByUserId(User user){
        return resumeDao.getUserResumeByUserId(user);
    }

    //查询所有的简历信息

    public ArrayList<UserResume> getAllUserResume(){
        return resumeDao.getAllUserResume();
    }


    //新增用户简历
    public boolean insertUserResume(UserResume userResume){
        return resumeDao.insertUserResume(userResume);
    }

    //修改用户简历
    public boolean updateUserResume(UserResume userResume){
        return resumeDao.updateUserResume(userResume);
    }


    //通过用户id判断是否拥有简历

    public int getUserResumeNumByUserId(UserResume userResume){
        return resumeDao.getUserResumeNumByUserId(userResume);
    }
}
