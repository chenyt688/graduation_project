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
public class UpdatePasswordController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userForgetPassword")
    @ResponseBody
    public Object userRegister(User user){
        System.out.println(user);
        String msg = "";
        User userInfo = userService.getUserInfoByPhone(user);
        userInfo.setUserPassword(user.getUserPassword());
        if(userInfo != null){
            userService.updateUserPassword(userInfo);
            msg = "密码修改成功！！！";
        }else {
            msg = "该用户不存在！！！";
        }
        return msg;
    }
}
