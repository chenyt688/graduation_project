package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.userinfo.RecipientInfo;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface RecipientDao {
    //新增受助人信息
    @Insert("insert into recipient_info(user_id,user_name,user_id_card,user_phone,user_img_url,family_status," +
            "prove_img_url,self_acc_book_img_url,village_letter_img_url,town_prove_img_url,student_list_img_url" +
            ",qrcode_url,review_status,del_flag) value(#{userId},#{userName},#{userIdCard},#{userPhone},#{userImgUrl}," +
            "#{familyStatus},#{provImgUrl},#{selfAccBookImgUrl},#{villageLetterImgUrl},#{townProveImgUrl}," +
            "#{studentListImgUrl},#{studentListImgUrl},1,1) ")
    boolean inserRecipientInfo(RecipientInfo recipientInfo);


    //查询用户是否已经申请
    @Select("select count(*) from recipient_info where user_id =#{userId} and del_flag =1")
    int judgeIsExistence(int userId);

    //管理员查询所有申请资助的用户
    @Select("select * from recipient_info where del_flag = 1 or user_name like CONCAT(CONCAT('%', #{condition}), '%')" +
            " limit #{startIndex},#{pageSize}")
    ArrayList<RecipientInfo> queryAllRecipientInfo(@Param("startIndex") int startIndex, @Param("pageSize")
            int pageSize,@Param("condition") String condition);

    //用户只能查看通过的审核的受助用户
    @Select("select * from recipient_info where review_status =2 or user_name like CONCAT(CONCAT('%', #{condition}), '%')" +
            " limit #{startIndex},#{pageSize}")
    ArrayList<RecipientInfo> queryPublishRecipientInfo(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize,
                                                       @Param("condition") String condition);

    //管理员查询所有的申请用户数量
    @Select("select count(*) from recipient_info where del_flag = 1 or user_name like CONCAT(CONCAT('%', #{condition}), '%')")
    int queryAllRecipientInfoNum(@Param("condition") String condition);


    //用户查询审核通过的申请用户数量
    @Select("select count(*) from recipient_info where review_status =2 and " +
            "del_flag = 1 or user_name like CONCAT(CONCAT('%', #{condition}), '%')")
    int queryPublishRecipientInfoNum(@Param("condition") String condition);


    //管理员删除申请用户
    @Delete("delete from recipient_info where user_id =#{userId}")
    boolean deleteRecipientInfoByUserId(int userId);

    //管理员更新申请用户状态
    @Update("update recipient_info set review_status =#{review_status} where user_id =#{userId}")
    boolean updateRecipientInfoByUserId(int userId,int reviewStatus);

}

