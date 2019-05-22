package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.relation.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface PictureDao {

    @Insert("insert img_info(img,user_id,img_name,flag) value(#{img},#{userId},#{imgName},0)")
    boolean addPicture(Picture picture);
    @Select("select * from img_info")
    ArrayList<Picture> queryAllPicture();

    @Select("select count(*) from img_info where img =#{img}")
    int queryPictureByImage(Picture picture);
}
