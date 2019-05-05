package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.diary.Diary;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.DiaryService;
import com.cyt.graduation_project.sys.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;



    //通过日记id查找日记信息
    @RequestMapping("/queryDiaryByDiaryId")
    public Diary queryDiaryByDiaryId(int diaryId){
        return diaryService.queryDiaryByDiaryId(diaryId);
    }


    //管理员根据日记id删除日记
    @RequestMapping("/deleteDiaryInfo")
    public Object deleteDiaryByDiaryId(int diaryId){
        return diaryService.deleteDiaryByDiaryId(diaryId);
    }

    //一般用户删除自己的日记信息根据user_id 和 diary_id

    public Object deleteDiaryByDiaryIdAndUserId(int diaryId,int userId){
        return diaryService.deleteDiaryByDiaryIdAndUserId(diaryId,userId);
    }

    //查询日记信息
    @RequestMapping(value = "/queryDiaryInfo", method = RequestMethod.PUT)
    public Object queryDiaryInfo(HttpServletRequest request,int page, int pageSize){
        User user = (User) request.getSession().getAttribute("userInfo");
        if (user != null && user.getRoleId() == 2){
            return diaryService.queryAllDiary(page,pageSize);  //管理员查询所有的日记信息
        }else {
            return diaryService.queryAllDiaryByUserId(user.getUserId(),page,pageSize);//用户查询自己的日记日记信息
        }

    }


    /*public Object queryAllDiaryByUserId(int userId){

    }*/

    @RequestMapping("/queryDiaryNum")
    public Object queryDiaryNum(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null && user.getRoleId() == 2){
            return  diaryService.queryDiaryNum(); //管理员查询日记数量
        }else {
            return diaryService.queryDiaryNumByUserId(user.getUserId());  //用户查询日记数量
        }


    }



    //修改日记信息
    @RequestMapping(value = "/updateDiaryByDiaryId", method = RequestMethod.PUT)
    public Object updateDiaryByDiaryId(@RequestBody Diary diary){
        if(diary.getDiaryTime()!=null){
            diary.setDiaryTime(DateFormatUtil.dateFormat3(diary.getDiaryTime()));
        }else {
            diary.setDiaryTime(null);
        }
        return diaryService.updateDiaryByDiaryId(diary);
    }

    //新增日记
    @RequestMapping("/insertDiary")
    public Object insertDiary(@RequestBody Diary diary,HttpServletRequest request){
        diary = setUserInfo(diary,request);
        return diaryService.insertDiary(diary);
    }

    //将登陆用户的数据赋值到Dairy中
    public Diary setUserInfo(Diary diary,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        diary.setUserId(user.getUserId());
        diary.setUserAccount(user.getUserAccount());
        diary.setUserName(user.getUserName());
        if(diary.getDiaryTime()!=null){
            diary.setDiaryTime(DateFormatUtil.dateFormat3(diary.getDiaryTime()));
        }else {
            diary.setDiaryTime(null);
        }
        return diary;

    }

    @RequestMapping(value = "/queryAllDiaryByCondition",method = RequestMethod.PUT)
    public Object queryAllDiaryByCondition(int page, int pageSize,String inputCondition,HttpServletRequest request){
        System.out.println(page +  "  "+ pageSize+ inputCondition);
        User user = (User) request.getSession().getAttribute("userInfo");
        if(user != null &&user.getRoleId() == 2){   //管理员模糊查询
            return diaryService.queryAllDiaryByCondition(page,pageSize,inputCondition);
        }else{         //用户模糊查询
            return diaryService.queryDiaryByCondition(page,pageSize,inputCondition,user.getUserId());
        }


    }


    //查看他人可见的日记信息
    @RequestMapping(value = "/queryPublishDiary",method = RequestMethod.PUT)
    public Object queryPublishDiary(int page, int pageSize ){
        return diaryService.queryPublishDiary(page,pageSize);
    }

    //查询日他人可见记数量
    @RequestMapping("/queryPublishDiaryNum")
    public Object queryPublishDiaryNum(){
        return diaryService.queryPublishDiaryNum();
    }




}

