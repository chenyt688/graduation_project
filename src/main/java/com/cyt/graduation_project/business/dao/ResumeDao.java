package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.entry.userinfo.UserResume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ResumeDao {
    //通过用户id获取相应的简历
    @Select("select * from user_resume where user_id = #{userId}")
    UserResume getUserResumeByUserId(User User);

    //查询所有的简历信息
    @Select("select * from user_resume where del_flag = 1")
    ArrayList<UserResume> getAllUserResume();

    //新增用户简历
    boolean insertUserResume(UserResume userResume);

    //修改用户简历
    boolean updateUserResume(UserResume userResume);

    //通过用户id判断是否拥有简历
    @Select("select count(*) from user_resume where user_id = #{userId}")
    int getUserResumeNumByUserId(UserResume userResume);


}
