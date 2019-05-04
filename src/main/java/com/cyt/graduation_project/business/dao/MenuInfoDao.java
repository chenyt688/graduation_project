package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.menu.Basemenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuInfoDao {

    //@Select("select * from base_menu")
    List<Basemenu> getBaseMenu();




}
