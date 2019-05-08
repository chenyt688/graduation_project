package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.position.Position;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.AddressService;
import com.cyt.graduation_project.business.service.UserService;
import com.cyt.graduation_project.sys.util.AddressUtil;
import com.cyt.graduation_project.sys.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    /**
     * 查询用户数据并分页
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getAllUserInfo", method = RequestMethod.PUT)
    @ResponseBody
    public Object getAllUserInfo(int page,int pageSize){
        return userService.getAllUserInfo(page,pageSize);
    }

    @RequestMapping(value = "/deleteUserInfoByUserId", method = RequestMethod.PUT)
    @ResponseBody
    //删除用户数据通过用户id
    public String deleteUserInfoByUserId(String userId){
        String flag = "S";
        boolean statu = userService.deleteUserInfoByUserId(userId);
        if(statu != true){
            flag = "F";
        }
        return flag;
    }

    @RequestMapping(value = "/deleteMulUserInfoByUserId", method = RequestMethod.PUT)
    @ResponseBody
    //批量删除用户数据通过用户id
    public String deleteMulUserInfoByUserId(String userId){
        String flag = "S";
        System.out.println(userId);
        boolean statu = userService.deleteMulUserInfoByUserId(userId);
        if(statu != true){
            flag = "F";
        }
        return flag;
    }

    //获取用户数量
    @RequestMapping("/getUserInfoNum")
    @ResponseBody
    public Object getUserInfoNum(){
        return userService.getUserInfoNum();
    }

    //获取用户数量通过条件查询
    @RequestMapping(value = "/getUserInfoNumByCondition", method = RequestMethod.PUT)
    @ResponseBody
    public Object getUserInfoNumByCondition(String inputCondition){
        if(inputCondition == "" || inputCondition == null){
            return userService.getUserInfoNum();
        }
        return userService.getUserInfoNumByCondition(inputCondition);
    }

    /**
     * 条件查询用户数据并分页
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getUserInfoByCondition", method = RequestMethod.PUT)
    @ResponseBody
    public Object getUserInfoByCondition(int page,int pageSize,String inputCondition){

        if(inputCondition.trim().equals("") || inputCondition == null){
            return userService.getAllUserInfo(page,pageSize);
        }
        return userService.getUserInfoByCondition(page,pageSize,inputCondition);
    }


    /**
     * 增加或者修改用户数据
     * @param user
     * @param speAdd
     * @param opeType
     * @return
     */

    @RequestMapping(value = "/addOrEditUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object addOrEditUserInfo(User user,String speAdd,String opeType){

        boolean flag = false;
        if(user.getUserBirth().contains("GMT")){
            //将中国标准时间转换为 yyyy-mm-dd格式
            user.setUserBirth(DateFormatUtil.dateFormat(user.getUserBirth()));
        }
        //设置默认密码
        if(user.getUserPassword() == null || user.getUserPassword() == ""){
            user.setUserPassword("123456");
        }
        //前台接收的地址id 查询name
        user = getUserLastAddress(user,speAdd);
        //user.setUserAddress(user.getUserAddress()+speAdd);
        if(opeType.equals("新增用户")){
            flag = userService.addUserInfo(user);
        }else {             //修改用户
            flag = userService.editUserInfo(user);
        }
        if (flag == true){
            return userService.getUserInfoByUserId(user);
            //return "S";
        }else {
            return "F";
        }
    }

    public User getUserLastAddress(User user,String speAdd){
        String add[] = user.getUserAddress().split("-"); //将前台的数据按-切割
        Position position = (Position) AddressUtil.returnAddress(add);
        String provinceName = addressService.getProvinceNameById(position.getProvinceId());
        String cityName = addressService.getCityNameById(position.getCityId());
        String countyName = addressService.getCountyNameById(position.getCountyId());
        String townName = addressService.getTownNameById(position.getTownId());
        String villageName = addressService.getVillageNameById(position.getVillageId());
        if(provinceName == null){
            position.setProvinceName("");
        }else {
            position.setProvinceName(provinceName);
        }

        if(cityName == null){
            position.setCityName("");
        }else {
            position.setCityName(cityName);
        }

        if(countyName == null){
            position.setCountyName("");
        }else {
            position.setCountyName(countyName);
        }

        if(townName == null){
            position.setTownName("");
        }else {
            position.setTownName(townName);
        }

        if(villageName == null){
            position.setVillageName("");
        }else {
            position.setVillageName(villageName);
        }
        user.setUserAddress(position.getProvinceName()+position.getCityName()
                +position.getCountyName()+position.getTownName()+position.getVillageName()+speAdd);
        /*String[] add = new String[5];
        boolean flag = true;
        if(!user.getUserAddress().equals("----")&&!user.getUserAddress().contains("undefined")){
            add = user.getUserAddress().split("-");
            for(int i=0; i<add.length; i++){
                if(add[i] == null || add[i] == ""){
                    flag = false;
                    break;
                }
            }
        }else {
            flag = false;
        }

        if(flag){
            Position position = new Position();
            position.setProvinceId(Long.parseLong(add[0]));
            position.setCityId(Long.parseLong(add[1]));
            position.setCountyId(Long.parseLong(add[2]));
            position.setTownId(Long.parseLong(add[3]));
            position.setVillageId(Long.parseLong(add[4]));
            position = addressService.getPositionInfo(position);
            user.setUserAddress(position.getProvinceName()+position.getCityName()
                    +position.getCountyName()+position.getTownName()+position.getVillageName()+speAdd);
        }else {
            user.setUserAddress(" ");
        }*/

        return user;
    }

    //查询用户数据通过userId
    @RequestMapping("/getUserInfoByUserId")
    @ResponseBody
    public Object getUserInfoByUserId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        return userService.getUserInfoByUserId(user);
    }

    //活动查询用户数据通过userId
    @RequestMapping("/getUserInfoByUserIdToActivity")
    @ResponseBody
    public Object getUserInfoByUserIdToActivity(User user){
        return userService.getUserInfoByUserId(user);
    }


}
