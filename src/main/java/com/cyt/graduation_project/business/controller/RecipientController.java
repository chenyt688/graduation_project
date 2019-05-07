package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.RecipientInfo;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        if(recipientService.judgeIsExistence(recipientInfo.getUserId())<1){    //用户没申请
            recipientService.inserRecipientInfo(recipientInfo);
            flag = "S";
        }

        return flag;
    }
    public RecipientInfo getNewRecipientInfo(RecipientInfo recipientInfo, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        String userFileName ="用户" + user.getUserAccount();
        String path = "/UserInfo/" + userFileName ;

        recipientInfo.setUserId(user.getUserId());
        //recipientInfo.setUserName(user.getUserName());
        recipientInfo.setUserImgUrl(path+"/个人照片.jpg");
        recipientInfo.setProvImgUrl(path+"/个人申请书.jpg");
        recipientInfo.setSelfAccBookImgUrl(path+"/个人户口页.jpg");
        recipientInfo.setVillageLetterImgUrl(path+"/村级证明.jpg");
        recipientInfo.setTownProveImgUrl(path+"/乡级证明.jpg");
        recipientInfo.setStudentListImgUrl(path+"/学籍表.jpg");
        recipientInfo.setQrcodeUrl(path+"/二维码.jpg");
        return recipientInfo;
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
        return recipientService.queryRecipientInfoByRecipientId(recipientId);
    }
}
