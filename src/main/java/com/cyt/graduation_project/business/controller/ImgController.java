package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.relation.Picture;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.PictureService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@CrossOrigin
public class ImgController {
    @Autowired
    private PictureService pictureService;
    //图片上传
    @RequestMapping("/uploadImg")
    public void uploadImg(@RequestParam("picture") MultipartFile imgFile, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        String userFileName ="用户" + user.getUserAccount();
        String path = "E://BD/UserInfo/" + userFileName ;
        File fileUrl = new File(path);              //文件夹名称：用户 + 用户账号
        if(!fileUrl.exists()){//如果文件夹不存在
            fileUrl.mkdir();//创建文件夹
        }
        String fileName=imgFile.getOriginalFilename();
        //String id = GenerateInfo.getAccount();
        //String img=id + fileName.substring(fileName.lastIndexOf("."));//zhao.jpg
        FileOutputStream imgOut= null;
        try {
            imgOut = new FileOutputStream(new File(fileUrl,fileName));
            imgOut.write(imgFile.getBytes());//返回一个字节数组文件的内容
            imgOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/uploadPicture")
    public void uploadPicture(@RequestParam("picture") MultipartFile imgFile,Integer userIdStr, HttpServletRequest request) throws IOException {
        User user = (User) request.getSession().getAttribute(userIdStr+"");
        String imgStr = "";
        Picture picture = new Picture();
        imgStr = Base64.encodeBase64String(imgFile.getBytes());  //将图片转换为字符格式
        imgStr = "data:image/jpeg;base64," + imgStr;
        if(user != null){
            picture.setImg(imgStr);
            picture.setUserId(user.getUserId());
            picture.setImgName(imgFile.getOriginalFilename());
            if(pictureService.queryPictureByImage(picture)==0){ //避免上传相同的图片
                pictureService.uploadPicture(picture);
            }

        }
    }

    @RequestMapping("/queryAllPicture")
    public Object queryAllPicture(){
        return pictureService.queryAllPicture();
    }

}
