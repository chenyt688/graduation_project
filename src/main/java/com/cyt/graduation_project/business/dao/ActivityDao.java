package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.activity.ActivityChars;
import com.cyt.graduation_project.business.entry.activity.ActivityInfo;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ActivityDao {

    //查询所有的支教活动信息
    @Select("select * from activity_info where del_flag = 1 order by application_time DESC limit #{startIndex},#{pageSize} ")
    ArrayList<ActivityInfo> queryAllActivityInfo(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    //查询所有已经发布的支教活动信息
    @Select("select * from activity_info where del_flag = 1 and review_status = 2 order by activity_end_time DESC limit #{startIndex},#{pageSize} ")
    ArrayList<ActivityInfo> queryAllActivityInfoPublished(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    //获取数量
    @Select("select COUNT(*) from activity_info where del_flag = 1")
    int getActivityAccount();

    //获取已发布活动的数量
    @Select("select COUNT(*) from activity_info where del_flag = 1 and review_status = 2")
    int getActivityAccountPublished();

    //新增支教活动信息
    boolean addActivityInfo(ActivityInfo activityInfo);

    //通过活动id修改支教活动信息（未审核之前可以修改）
    boolean editActivityInfoById(ActivityInfo activityInfo);

    //通过活动id删除支教活动信息（未审核之前可以删除 0表示未审核）
    @Delete("delete from activity_info where review_status = 0 and activity_id = #{activityId}")
    boolean deleteActivityInfoById(int activityId);

    //管理员删除支教活动信息
    @Delete("delete from activity_info where  activity_id = #{activityId}")
    boolean deleteActivity(int activityId);

    //通过用户id查找活动信息
    @Select("select * from activity_info where user_id = #{userId} limit #{startIndex},#{pageSize}")
    ArrayList<ActivityInfo> queryActivityInfoByUserId(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("userId") int userId);


    //通过活动id查找活动信息
    @Select("select * from activity_info where activity_id = #{activityId}")
    ActivityInfo queryActivityInfoByActivityId(ActivityInfo activityInfo);

    //通过活动id查找活动信息
    @Select("select * from activity_info where activity_id = #{activityId}")
    ActivityInfo queryActivityInfoById(int activityId);
    //通过条件查询活动数据

    ArrayList<ActivityInfo> getActivityInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("condition") String condition);




    //通过条件查询已经发布的志愿者活动数据
    ArrayList<ActivityInfo> getActivityPublishInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("condition") String condition);



    //通过活动状态查询活动数据
    @Select("select * from activity_info where review_status = #{state} limit #{startIndex},#{pageSize}")
    ArrayList<ActivityInfo> getActivityInfoByState(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("state") int state);


    //查询已经登录用户申请的志愿活动数量
    @Select("select COUNT(*) from activity_info where user_id = #{userId} and del_flag = 1")
    int queryActivityNumByUserLoging(@Param("userId") int userId);

    //更新支教活动信息状态
    @Update("update activity_info set review_status = #{reviewStatus} where activity_id =#{activityId}")
    public boolean updateActivityState(@Param("activityId") int activityId,@Param("reviewStatus")int reviewStatus);

    //查询对应的省份申报活动的数量
    @Select("select province_name,count(*) as num from activity_info Group by province_name")
    public ArrayList<ActivityChars> getActivityCountByProvinceName();


    @Select("select COUNT(*) from activity_info where activity_id = #{activityId} and del_flag = 1 and review_status = 2")
    int queryActivityState(@Param("activityId") int activityId);

}