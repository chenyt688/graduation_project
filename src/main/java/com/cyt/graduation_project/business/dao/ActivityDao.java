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


    //查询所有已经发布的支教活动信息      and sysdate() < activity_end_time
    @Select("select * from activity_info where del_flag = 1 and review_status in (2,4)  order by activity_end_time DESC limit #{startIndex},#{pageSize} ")
    ArrayList<ActivityInfo> queryAllActivityInfoPublished(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    ArrayList<ActivityInfo> queryAllActivityInfoPublishedByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize ,@Param("condition") String condition);

    int queryAllActivityNumPublishedByCondition(@Param("condition") String condition);

    //获取数量
    @Select("select COUNT(*) from activity_info where del_flag = 1")
    int getActivityAccount();

    //获取已发布活动的数量             and sysdate() < activity_end_time
    @Select("select COUNT(*) from activity_info where del_flag = 1 and review_status in (2,4)")
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

    //通过用户id查找活动信息
    @Select("select count(*) from activity_info where user_id = #{userId}")
   int queryActivityNumByUserId(@Param("userId") int userId);


    //通过活动id查找活动信息
    @Select("select * from activity_info where activity_id = #{activityId}")
    ActivityInfo queryActivityInfoByActivityId(ActivityInfo activityInfo);

    //通过活动id查找活动信息
    @Select("select * from activity_info where activity_id = #{activityId}")
    ActivityInfo queryActivityInfoById(int activityId);
    //通过条件查询活动数据

    ArrayList<ActivityInfo> getActivityInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("condition") String condition);

    int getActivityNumByCondition(@Param("condition") String condition);



    //通过条件查询已经发布的志愿者活动数据
    ArrayList<ActivityInfo> getActivityPublishInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("condition") String condition);



    //通过活动状态查询活动数据
    @Select("select * from activity_info where review_status = #{state} limit #{startIndex},#{pageSize}")
    ArrayList<ActivityInfo> getActivityInfoByState(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("state") int state);

    //通过活动状态查询活动数据
    @Select("select count(*) from activity_info where review_status = #{state}")
   int getActivityNumByState( @Param("state") int state);

    //查询已经登录用户申请的志愿活动数量
    @Select("select COUNT(*) from activity_info where user_id = #{userId} and del_flag = 1")
    int queryActivityNumByUserLoging(@Param("userId") int userId);

    //更新支教活动信息状态
    @Update("update activity_info set review_status = #{reviewStatus} where activity_id =#{activityId}")
    public boolean updateActivityState(@Param("activityId") int activityId,@Param("reviewStatus")int reviewStatus);

    //查询对应的省份申报活动的数量
    @Select("select province_name,count(*) as num from activity_info where  application_time like CONCAT(CONCAT('%', #{year}), '%') and review_status in (2,4) Group by province_name")
    public ArrayList<ActivityChars> getActivityCountByProvinceName(@Param("year") String year);


    @Select("select COUNT(*) from activity_info where activity_id = #{activityId} and del_flag = 1 and review_status = 2")
    int queryActivityState(@Param("activityId") int activityId);

    //根据年份获取每个省发布的支教志愿者活动的数量
    @Select("select pp.province_name,count(ai.province_name) as num  from j_position_province as pp " +
            "left join activity_info  as ai on ai.province_name=pp.province_name " +
            "where review_status in (2,4) and application_time like CONCAT(CONCAT('%', #{year}), '%') Group by pp.province_name")
    public ArrayList<ActivityChars> getProvinctNumByYear(@Param("year") String year);


    //读取发布志愿者活动最早的年份
    @Select("select application_time from activity_info  order by activity_end_time  ASC limit 1")
    public String getYear();

    @Select(" select count(*) from activity_info where\n" +
            "        activity_address like CONCAT(CONCAT('%', #{condition}), '%') or\n" +
            "        topic like CONCAT(CONCAT('%', #{condition}), '%') or\n" +
            "        province_name like CONCAT(CONCAT('%', #{condition}), '%')\n" +
            "        and del_flag = 1")
    public int getActivityCountByCondition(@Param("condition") String condition);


    @Select(" select count(*) from activity_info where\n" +
            "        activity_address like CONCAT(CONCAT('%', #{condition}), '%') or\n" +
            "        topic like CONCAT(CONCAT('%', #{condition}), '%') or\n" +
            "        province_name like CONCAT(CONCAT('%', #{condition}), '%')\n" +
            "        and del_flag = 1 and review_status in (2,4)")
    public int getActivityCountByCondition2(@Param("condition") String condition);



}