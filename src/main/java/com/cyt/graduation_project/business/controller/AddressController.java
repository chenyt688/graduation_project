package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.position.*;
import com.cyt.graduation_project.business.service.AddressService;
import com.cyt.graduation_project.sys.util.SelectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    //获取省
    @RequestMapping("/getProvinceInfo")
    public Object getProvinceInfo(){
        ArrayList<Province> proList =addressService.getProvinceInfo();
        return SelectUtil.returnProList(proList);

    }
    //市

    @RequestMapping("/getCityInfo")
    public Object getCityInfo(City city){
        ArrayList<City> cityList = addressService.getCityInfo(city.getProvinceId());
        return  SelectUtil.returnCityList(cityList);
    }
    //区
    @RequestMapping("/getCountyInfo")
    public Object getCountyInfo(County county){
        ArrayList<County> countyList = addressService.getCountyInfo(county.getCityId());
        return SelectUtil.returnCountyList(countyList);
    }
    //乡
    @RequestMapping("/getTownInfo")
    public Object getTownInfo(Town town){
        ArrayList<Town> townList = addressService.getTownInfo(town.getCountyId());
        return SelectUtil.returnTownList(townList);
    }

    //村
    @RequestMapping("/getVillageInfo")
    public Object getVillageInfo(Village village){
        ArrayList<Village> villageList = addressService.getVillageInfo(village.getTownId());
        return SelectUtil.returnVillageList(villageList);
    }



}
