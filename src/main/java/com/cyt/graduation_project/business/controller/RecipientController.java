package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.RecipientInfo;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.RecipientService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@CrossOrigin
public class RecipientController {
    @Autowired
    private RecipientService recipientService;
    //新增受助人信息
    @RequestMapping(value = "/inserRecipientInfo",method = RequestMethod.PUT)
    public Object inserRecipientInfo(RecipientInfo recipientInfo,HttpServletRequest request){
        String flag = "F";
        recipientInfo = getNewRecipientInfo(recipientInfo,request);
        if(recipientInfo.getUserImgUrl()=="F"){     //材料不齐全
            return "F2";
        }else {
            if(recipientService.judgeIsExistence(recipientInfo.getUserId())<1){    //用户没申请
                recipientService.inserRecipientInfo(recipientInfo);
                flag = "S";
            }
        }


        return flag;
    }

    //获取用户上传的图片保存到数据库
    public RecipientInfo getNewRecipientInfo(RecipientInfo recipientInfo, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        String userFileName ="用户" + user.getUserAccount();
        String path = "E://BD/UserInfo/" + userFileName ;
        boolean flag = true;
        recipientInfo.setUserId(user.getUserId());
        if(judgeImgIsExtence(path+"/个人照片.jpg")){
            recipientInfo.setUserImgUrl(getImgToString(path+"/个人照片.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/个人申请书.jpg")){
            recipientInfo.setProveImgUrl(getImgToString(path+"/个人申请书.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/个人户口页.jpg")){
            recipientInfo.setSelfAccBookImgUrl(getImgToString(path+"/个人户口页.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/村级证明.jpg")){
            recipientInfo.setVillageLetterImgUrl(getImgToString(path+"/村级证明.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/乡级证明.jpg")){
            recipientInfo.setTownProveImgUrl(getImgToString(path+"/乡级证明.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/学籍表.jpg")){
            recipientInfo.setStudentListImgUrl(getImgToString(path+"/学籍表.jpg"));
        }else {
            flag =false;
        }
        if(judgeImgIsExtence(path+"/二维码.jpg")){
            recipientInfo.setQrcodeUrl(getImgToString(path+"/二维码.jpg"));
        }else {
            flag =false;
        }
        if(flag == false) {
            recipientInfo.setUserImgUrl("F");
        }
        return recipientInfo;

    }

    //读取本地照片转码 将图片转换为字符
    public  String getImgToString(String filePath){
        BASE64Encoder encoder = new BASE64Encoder();         //通过base64 转化图片
        String imgStr = "";
        //获得输入流,将文件读到内存
        FileInputStream in = null;
        try {
            in = new  FileInputStream(filePath);
            int n=0;
            //1024字节 ,相当于每次读取1kb
            byte[] arr = new byte[in.available()];
            //循环读取,读到末尾会返回-1
            while((n=in.read(arr)) !=-1) {

            }
            imgStr = Base64.encodeBase64String(arr);  //将图片转换为字符格式
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgStr = "data:image/jpeg;base64," + imgStr;

        return imgStr;

    }

    //判断上传的照片是否存在
    public boolean judgeImgIsExtence(String path){
        File file=new File(path);
        if(file.exists()){
            return true;
        }else{
            return false;
        }
    }



    //查询用户是否已经申请
    public Object judgeIsExistence(int userId){
        return recipientService.judgeIsExistence(userId);
    }


    //查询申请用户数据
    @RequestMapping(value = "/queryAllRecipientInfo",method = RequestMethod.PUT)
    public Object queryAllRecipientInfo(int page, int pageSize, String condition,HttpServletRequest request){
        //System.out.println(page + pageSize + condition);
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null && user.getRoleId() == 2){
            return recipientService.queryAllRecipientInfo(page,pageSize,condition);//管理员查询所有申请资助的用户

        }else {
            return recipientService.queryPublishRecipientInfo(page,pageSize,condition);
        }


    }

    //查询数量

    @RequestMapping(value = "/queryAllRecipientInfoNum",method = RequestMethod.PUT)
    public Object queryAllRecipientInfoNum(String condition,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null && user.getRoleId() == 2) {   //管理员查询所有的申请用户数量
            return recipientService.queryAllRecipientInfoNum(condition);
        }else {                         //用户查询审核通过的申请用户数量
            return recipientService.queryPublishRecipientInfoNum(condition);
        }
    }


    //管理员删除申请用户
    @RequestMapping(value = "/deleteRecipientInfoByRecipientId",method = RequestMethod.PUT)
    public Object deleteRecipientInfoByUserId(int recipientId){
        return recipientService.deleteRecipientInfoByRecipientId(recipientId);
    }

    //管理员更新申请用户状态
    @RequestMapping(value = "/updateRecipientInfoByRecipientId",method = RequestMethod.PUT)
    public Object updateRecipientInfoByRecipientId(int recipientId,int reviewStatus){
        return recipientService.updateRecipientInfoByRecipientId(recipientId,reviewStatus);
    }


    //通过申请资助id查找信息
    @RequestMapping(value = "/queryRecipientInfoByRecipientId",method = RequestMethod.PUT)
    public Object queryRecipientInfoByRecipientId(int recipientId){
        //System.out.println(recipientId);
        return recipientService.queryRecipientInfoByRecipientId(recipientId);
    }
}
