package com.cyt.graduation_project.business.service;


import com.cyt.graduation_project.business.dao.DiaryDao;
import com.cyt.graduation_project.business.entry.diary.Diary;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiaryService {
    @Autowired
    private DiaryDao diaryDao;

    //管理员根据日记id删除日记

    public boolean deleteDiaryByDiaryId(int diaryId){
        return diaryDao.deleteDiaryByDiaryId(diaryId);
    }

    //一般用户删除自己的日记信息根据user_id 和 diary_id


    public boolean deleteDiaryByDiaryIdAndUserId(int diaryId,int userId){
        return diaryDao.deleteDiaryByDiaryIdAndUserId(diaryId,userId);
    }

    //管理员查询所有的日记信息
    public ArrayList<Diary> queryAllDiary(int page, int pageSize){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return diaryDao.queryAllDiary(startIndex,pageSize);
    }

    //用户查询自己的日记日记信息
    public ArrayList<Diary> queryAllDiaryByUserId(int userId,int page,int pageSize){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return diaryDao.queryAllDiaryByUserId(userId,startIndex,pageSize);
    }

    //管理员查询日记数量
    public int queryDiaryNum(){
        return  diaryDao.queryDiaryNum();
    }

    //用户查询日记数量
    public int queryDiaryNumByUserId(int userId){
        return diaryDao.queryDiaryNumByUserId(userId);
    }

    //修改日记信息
    public boolean updateDiaryByDiaryId(Diary diary){
        return diaryDao.updateDiaryByDiaryId(diary);
    }

    //新增日记
    public boolean insertDiary(Diary diary){
        return diaryDao.insertDiary(diary);
    }


    //通过日记id查找日记信息
    public Diary queryDiaryByDiaryId(int diaryId){
        return diaryDao.queryDiaryByDiaryId(diaryId);
    }


    //管理员模糊查询
    public ArrayList<Diary> queryAllDiaryByCondition(int page,int pageSize ,String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return diaryDao.queryAllDiaryByCondition(startIndex,pageSize,condition);
    }


    //用户模糊查询
    public ArrayList<Diary> queryDiaryByCondition(int page,int pageSize ,String condition,int userId){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return diaryDao.queryDiaryByCondition(startIndex,pageSize,condition,userId);
    }
}
