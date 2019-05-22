package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.relation.SignActivity;
import com.cyt.graduation_project.business.entry.userinfo.ParticipantsInfo;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ParticipantsDao {

    //新增用户报名数据
    @Insert("insert into participants_info(user_id,activity_id,review_status) value(#{userId},#{activityId},1)")
    boolean insertParticipant(@Param("userId") int userId, @Param("activityId") int activityId);


    //判断用户是否已经报名该活动
    @Select("select count(*) from participants_info where user_id=#{userId} and activity_id =#{activityId}")
    int queryParticipantIsExistence(@Param("userId") int userId, @Param("activityId") int activityId);


    //查看最近用户报名的状况
    @Select("select * from participants_info where user_id=#{userId} order by apply_time")
    ArrayList<ParticipantsInfo> queryJoinInfoByUserId(int userId);



    //登录用户查看自己申请的活动报名状况
    ArrayList<SignActivity> queryAllJoinInfo(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("userId") int userId);

    //登录用户查看自己申请的活动的数量
    int queryParticipantNum(int userId);

    //条件查询活动
    ArrayList<ParticipantsInfo> queryJoinInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize,@Param("condition") String condition);

    //条件查询查询数量
    int queryJoinNumByCondition(@Param("condition") String condition);

    //修改报名状态
    @Update("update participants_info set review_status =#{reviewStatus} where user_id=#{userId} and activity_id=#{activityId}")
    boolean updateJoinState(@Param("userId") int userId, @Param("activityId") int activityId,@Param("reviewStatus") int reviewStatus);

    //删除报名信息
    @Delete("delete from participants_info where id =#{id}")
    boolean deleteById(int id);


}
