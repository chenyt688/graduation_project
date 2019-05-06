package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.userinfo.RecipientInfo;
import com.cyt.graduation_project.business.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RecipientController {
    @Autowired
    private RecipientService recipientService;
    //新增受助人信息
    public Object inserRecipientInfo(RecipientInfo recipientInfo){
        return recipientService.inserRecipientInfo(recipientInfo);
    }


    //查询用户是否已经申请
    public Object judgeIsExistence(int userId){
        return recipientService.judgeIsExistence(userId);
    }

    //管理员查询所有申请资助的用户
    public Object queryAllRecipientInfo(int page, int pageSize, String condition){
        return recipientService.queryAllRecipientInfo(page,pageSize,condition);
    }

    //用户只能查看通过的审核的受助用户
    public Object queryPublishRecipientInfo(int page,int pageSize,String condition){
        return recipientService.queryPublishRecipientInfo(page,pageSize,condition);

    }

    //管理员查询所有的申请用户数量
    public Object queryAllRecipientInfoNum(String condition){
        return recipientService.queryAllRecipientInfoNum(condition);
    }


    //用户查询审核通过的申请用户数量
    public Object queryPublishRecipientInfoNum(String condition){
        return recipientService.queryPublishRecipientInfoNum(condition);
    }


    //管理员删除申请用户
    public Object deleteRecipientInfoByUserId(int userId){
        return recipientService.deleteRecipientInfoByUserId(userId);
    }

    //管理员更新申请用户状态
    public Object updateRecipientInfoByUserId(int userId,int reviewStatus){
        return recipientService.updateRecipientInfoByUserId(userId,reviewStatus);
    }
}
