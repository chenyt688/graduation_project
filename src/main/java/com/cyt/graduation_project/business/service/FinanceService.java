package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.FinanceDao;
import com.cyt.graduation_project.business.entry.finance.Finance;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FinanceService {
    @Autowired
    private FinanceDao financeDao;
    //新增财务记录

    public boolean insertFinanceInfo(Finance finance){
        return financeDao.insertFinanceInfo(finance);
    }


    //查询数量

    public int queryFinanceNum(String condition){
        return financeDao.queryFinanceNum(condition);
    }

    //查询所有的财务信息
    public ArrayList<Finance> queryFinanceInfo( int page, int pageSize, String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return financeDao.queryFinanceInfo(startIndex,pageSize,condition);
    }

    //删除选中的财务消息

    public boolean deleteFinanceInfo(int financeId){
        return financeDao.deleteFinanceInfo(financeId);
    }


    //修改选中的财务信息

    public boolean updateFinanceInfo(Finance finance){
        return financeDao.updateFinanceInfo(finance);
    }
    //根据financeId 查询数据
    public Finance queryByFinanceId(int financeId){
        return financeDao.queryByFinanceId(financeId);
    }
}
