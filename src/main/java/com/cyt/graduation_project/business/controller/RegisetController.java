package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class RegisetController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userRegister")
    @ResponseBody
    public Object userRegister(User user){
        String msg = "";
        User userInfo = userService.getUserInfoByPhone(user);
        if(userInfo != null){
            msg = "该号码已经注册！！！";
        }else {
            user.setDelFlag(1);
            user.setRoleId(1);
            userService.registerUser(user);
            msg = "注册成功！！！";
        }
        return msg;
    }



}
