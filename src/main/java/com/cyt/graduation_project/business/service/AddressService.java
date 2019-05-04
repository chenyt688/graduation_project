package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.AddressDao;
import com.cyt.graduation_project.business.entry.position.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    //获取省
    public ArrayList<Province> getProvinceInfo(){
        return addressDao.getProvinceInfo();
    }

    //获取城市通过provinceId

    public ArrayList<City> getCityInfo(long provinceId){
        return addressDao.getCityInfo(provinceId);
    }


    //获取区通过cityId

    public ArrayList<County> getCountyInfo(long cityId){
        return addressDao.getCountyInfo(cityId);
    }

    //获取乡镇通过countyId

    public ArrayList<Town> getTownInfo(long countyId){
        return addressDao.getTownInfo(countyId);
    }

    //获取村通过countyId

    public ArrayList<Village> getVillageInfo(long townId){
        return addressDao.getVillageInfo(townId);
    }


    //获取地址名

    public Position getPositionInfo(Position position){
        return addressDao.getPositionInfo(position);
    }

    //多条件查询
    public Position getPositionInfoName(Position position){
        return addressDao.getPositionInfoName(position);
    }



    //省名


    public String getProvinceNameById(long provinceId){
        return addressDao.getProvinceNameById(provinceId);
    }

    //获取城市名

    public String getCityNameById(long cityId){
        return addressDao.getCityNameById(cityId);
    }


    //获取区名

    public String  getCountyNameById(long cityId){
        return addressDao.getCountyNameById(cityId);
    }

    //获取乡镇名

    public String getTownNameById(long countyId){
        return addressDao.getTownNameById(countyId);
    }

    //获取村名

    public String getVillageNameById(long villageId){
        return addressDao.getVillageNameById(villageId);
    }

}
