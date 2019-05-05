package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
public class ImgController {
    //图片上传
    @RequestMapping("/uploadImg")
    public void uploadImg(MultipartFile imgFile, HttpServletRequest request){
        System.out.println(imgFile);
        User user = (User) request.getSession().getAttribute("userInfo");
        String userFileName ="用户" + user.getUserAccount();
        String path = "E://BD/UserInfo/" + userFileName;
        File fileUrl = new File(path);              //文件夹名称：用户 + 用户账号
        if(!fileUrl.exists()){//如果文件夹不存在
            fileUrl.mkdir();//创建文件夹
        }
        try {
            imgFile.transferTo(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
