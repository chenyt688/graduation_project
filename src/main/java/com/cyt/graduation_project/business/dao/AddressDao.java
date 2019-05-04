package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.position.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AddressDao {
    //获取省
    @Select("select province_id,province_name from j_position_province")
    ArrayList<Province> getProvinceInfo();

    //获取城市通过provinceId
    @Select("select * from j_position_city where province_id = #{provinceId}")
    ArrayList<City> getCityInfo(long provinceId);


    //获取区通过cityId
    @Select("select * from j_position_county where city_id = #{cityId}")
    ArrayList<County> getCountyInfo(long cityId);

    //获取乡镇通过countyId
    @Select("select * from j_position_town where county_id = #{countyId}")
    ArrayList<Town> getTownInfo(long countyId);

    //获取村通过countyId
    @Select("select * from j_position_village where town_id = #{townId}")
    ArrayList<Village> getVillageInfo(long townId);

    @Select("select * from j_position where  province_id = #{provinceId} and city_id = #{cityId} and county_id = #{countyId} and town_id = #{townId} and village_id = #{villageId}")
    Position getPositionInfo(Position position);

    @Select("select * from j_position where  province_id = #{provinceId} or city_id = #{cityId} or county_id = #{countyId} or town_id = #{townId} or village_id = #{villageId}")
    Position getPositionInfoName(Position position);


    //省名

    @Select("select province_name from j_position_province where province_id = #{provinceId}")
    String getProvinceNameById(long provinceId);

    //获取城市名
    @Select("select city_name from j_position_city where city_id = #{cityId}")
    String getCityNameById(long cityId);


    //获取区名
    @Select("select county_name from j_position_county where county_id = #{countyId}")
    String  getCountyNameById(long cityId);

    //获取乡镇名
    @Select("select town_name from j_position_town where town_id = #{townId}")
    String getTownNameById(long countyId);

    //获取村名
    @Select("select village_name from j_position_village where village_id = #{villageId} ")
    String getVillageNameById(long villageId);






}
