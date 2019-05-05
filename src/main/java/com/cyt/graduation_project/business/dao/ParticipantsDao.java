package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.userinfo.ParticipantsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ParticipantsDao {

    //新增用户报名数据
    @Insert("insert into participants_info(user_id,activity_id,review_status) value(#{userId},#{activityId},1)")
    boolean insertParticipant(@Param("userId") int userId, @Param("activityId") int activityId);


    //判断用户是否已经报名该活动
    @Select("select count(*) from participants_info where user_id=#{userId} and activity_id =#{activityId}")
    int queryParticipantIsExistence(@Param("userId") int userId, @Param("activityId") int activityId);


    //查看最近用户报名的状况
    @Select("select * from participants_info where user_id=#{userId} order by apply_time DESC limit 1")
    ParticipantsInfo queryJoinInfoByUserId(int userId);

}
