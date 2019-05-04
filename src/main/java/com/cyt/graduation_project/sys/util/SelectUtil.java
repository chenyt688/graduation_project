package com.cyt.graduation_project.sys.util;

import com.cyt.graduation_project.business.entry.position.*;

import java.util.ArrayList;

public class SelectUtil {
    //省
    public static ArrayList<Selection> returnProList(ArrayList<Province> proList){
        ArrayList<Selection> selectionArrayList = new ArrayList<Selection>(proList.size());
        for(int i =0 ; i<proList.size();i++){
            Selection selection = new Selection();
            selection.setLabel(proList.get(i).getProvinceName());
            selection.setValue(proList.get(i).getProvinceId());
            selectionArrayList.add(selection);
        }
        return selectionArrayList;
    }
    //市
    public static ArrayList<Selection> returnCityList(ArrayList<City> cityList){
        ArrayList<Selection> selectionArrayList = new ArrayList<Selection>(cityList.size());
        for(int i =0 ; i<cityList.size();i++){
            Selection selection = new Selection();
            selection.setLabel(cityList.get(i).getCityName());
            selection.setValue(cityList.get(i).getCityId());
            selectionArrayList.add(selection);
        }
        return selectionArrayList;
    }

    //区
    public static ArrayList<Selection> returnCountyList(ArrayList<County> countyList){
        ArrayList<Selection> selectionArrayList = new ArrayList<Selection>(countyList.size());
        for(int i =0 ; i<countyList.size();i++){
            Selection selection = new Selection();
            selection.setLabel(countyList.get(i).getCountyName());
            selection.setValue(countyList.get(i).getCountyId());
            selectionArrayList.add(selection);
        }
        return selectionArrayList;
    }

    //乡镇
    public static ArrayList<Selection> returnTownList(ArrayList<Town> townList){
        ArrayList<Selection> selectionArrayList = new ArrayList<Selection>(townList.size());
        for(int i =0 ; i<townList.size();i++){
            Selection selection = new Selection();
            selection.setLabel(townList.get(i).getTownName());
            selection.setValue(townList.get(i).getTownId());
            selectionArrayList.add(selection);
        }
        return selectionArrayList;
    }

    //村
    public static ArrayList<Selection> returnVillageList(ArrayList<Village> villagList){
        ArrayList<Selection> selectionArrayList = new ArrayList<Selection>(villagList.size());
        for(int i =0 ; i<villagList.size();i++){
            Selection selection = new Selection();
            selection.setLabel(villagList.get(i).getVillageName());
            selection.setValue(villagList.get(i).getVillageId());
            selectionArrayList.add(selection);
        }
        return selectionArrayList;
    }
}
