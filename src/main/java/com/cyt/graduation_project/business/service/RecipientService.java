package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.RecipientDao;
import com.cyt.graduation_project.business.entry.userinfo.RecipientInfo;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipientService {
    @Autowired
    private RecipientDao recipientDao;
    //新增受助人信息
    public boolean inserRecipientInfo(RecipientInfo recipientInfo){
        return recipientDao.inserRecipientInfo(recipientInfo);
    }


    //查询用户是否已经申请
    public int judgeIsExistence(int userId){
        return recipientDao.judgeIsExistence(userId);
    }

    //管理员查询所有申请资助的用户
    public ArrayList<RecipientInfo> queryAllRecipientInfo(int page, int pageSize, String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return recipientDao.queryAllRecipientInfo(startIndex,pageSize,condition);
    }

    //用户只能查看通过的审核的受助用户
    public ArrayList<RecipientInfo> queryPublishRecipientInfo(int page,int pageSize,String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return recipientDao.queryPublishRecipientInfo(startIndex,pageSize,condition);

    }

    //管理员查询所有的申请用户数量
    public int queryAllRecipientInfoNum(String condition){
        return recipientDao.queryAllRecipientInfoNum(condition);
    }


    //用户查询审核通过的申请用户数量
    public int queryPublishRecipientInfoNum(String condition){
        return recipientDao.queryPublishRecipientInfoNum(condition);
    }


    //管理员删除申请用户
    public boolean deleteRecipientInfoByRecipientId(int recipientId){
        return recipientDao.deleteRecipientInfoByRecipientId(recipientId);
    }

    //管理员更新申请用户状态
    public boolean updateRecipientInfoByRecipientId(int recipientId,int reviewStatus){
        return recipientDao.updateRecipientInfoByRecipientId(recipientId,reviewStatus);
    }

    //通过申请资助id查找信息
    public RecipientInfo queryRecipientInfoByRecipientId(int recipientId){
        return recipientDao.queryRecipientInfoByRecipientId(recipientId);
    }
}
