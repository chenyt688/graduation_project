package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.diary.Diary;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface DiaryDao {

    //管理员根据日记id删除日记
    @Delete("delete from diary where diary_id = #{diaryId}")
    boolean deleteDiaryByDiaryId(int diaryId);

    //一般用户删除自己的日记信息根据user_id 和 diary_id

    @Delete("delete from diary where diary_id = #{diaryId} and user_id =#{userId}")
    boolean deleteDiaryByDiaryIdAndUserId(@Param("diaryId") int diaryId, @Param("userId") int userId);

    //管理员查询所有的日记信息
    @Select("select * from diary limit #{startIndex},#{pageSize}")
    ArrayList<Diary> queryAllDiary(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize );

    //用户查询自己的日记日记信息
    @Select("select * from diary where user_id =#{userId} limit #{startIndex},#{pageSize}")
    ArrayList<Diary> queryAllDiaryByUserId(@Param("userId") int userId,@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    //管理员查询日记数量
    @Select("select count(*) from diary")
    int queryDiaryNum();

    //用户查询日记数量
    @Select("select count(*) from diary where user_id =#{userId}")
    int queryDiaryNumByUserId(int userId);

    //修改日记信息
    @Update("Update diary set diary_topic=#{diaryTopic},diary_time=#{diaryTime},weather=#{weather}," +
            "diary_show=#{diaryShow},diary_content=#{diaryContent} where diary_id = #{diaryId}")
    boolean updateDiaryByDiaryId(Diary diary);

    //新增日记
    @Insert("insert into diary(diary_topic,diary_time,weather,diary_show,diary_content,user_id,user_account,user_name) " +
            "value(#{diaryTopic},#{diaryTime},#{weather},#{diaryShow},#{diaryContent},#{userId},#{userAccount},#{userName}) ")
    boolean insertDiary(Diary diary);

    //通过日记id查找日记信息

    @Select("select * from diary where diary_id =#{diaryId}")
    Diary queryDiaryByDiaryId(int diaryId);

    //管理员模糊查询
    @Select("select * from diary where diary_topic like CONCAT(CONCAT('%', #{condition}), '%')  limit #{startIndex},#{pageSize}")
    ArrayList<Diary> queryAllDiaryByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize ,@Param("condition") String condition);


    //用户模糊查询
    @Select("select * from diary where user_id =#{userId} and diary_topic like CONCAT(CONCAT('%', #{condition}), '%')  limit #{startIndex},#{pageSize}")
    ArrayList<Diary> queryDiaryByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize ,@Param("condition")
            String condition,@Param("userId") int userId);


    //查看他人可见的日记信息
    @Select("select * from diary where diary_show =1 limit #{startIndex},#{pageSize}")
    ArrayList<Diary> queryPublishDiary(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize );


    //查询日他人可见记数量
    @Select("select count(*) from diary where diary_show =1")
    int queryPublishDiaryNum();




}
