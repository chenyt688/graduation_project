package com.cyt.graduation_project.sys.util;

import com.cyt.graduation_project.business.entry.position.Position;

public class AddressUtil {
    public static Object returnAddress(String[] tempAdd){
        Position position = new Position();
        int size = tempAdd.length;
        switch (size){
            case 0:
                position.setProvinceId(0);
                position.setCityId(0);
                position.setCountyId(0);
                position.setTownId(0);
                position.setVillageId(0);
                break;
            case 1:
                position.setProvinceId(Long.parseLong(tempAdd[0]));
                position.setCityId(0);
                position.setCountyId(0);
                position.setTownId(0);
                position.setVillageId(0);
                break;
            case 2:
                position.setProvinceId(Long.parseLong(tempAdd[0]));
                position.setCityId(Long.parseLong(tempAdd[1]));
                position.setCountyId(0);
                position.setTownId(0);
                position.setVillageId(0);
                break;
            case 3:
                position.setProvinceId(Long.parseLong(tempAdd[0]));
                position.setCityId(Long.parseLong(tempAdd[1]));
                position.setCountyId(Long.parseLong(tempAdd[2]));
                position.setTownId(0);
                position.setVillageId(0);
                break;
            case 4:
                position.setProvinceId(Long.parseLong(tempAdd[0]));
                position.setCityId(Long.parseLong(tempAdd[1]));
                position.setCountyId(Long.parseLong(tempAdd[2]));
                position.setTownId(Long.parseLong(tempAdd[3]));
                position.setVillageId(0);
                break;
            case 5:
                position.setProvinceId(Long.parseLong(tempAdd[0]));
                position.setCityId(Long.parseLong(tempAdd[1]));
                position.setCountyId(Long.parseLong(tempAdd[2]));
                position.setTownId(Long.parseLong(tempAdd[3]));
                position.setVillageId(Long.parseLong(tempAdd[4]));
                break;
        }

        return position;
    }
}
