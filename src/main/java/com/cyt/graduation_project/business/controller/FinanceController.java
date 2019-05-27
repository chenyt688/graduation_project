package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.finance.Finance;
import com.cyt.graduation_project.business.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceController {
    @Autowired
    private FinanceService financeService;


    //新增财务记录
    @RequestMapping(value = "/insertFinanceInfo", method = RequestMethod.PUT)
    public Object insertFinanceInfo(@RequestBody Finance finance) {
        String flag = "F";
        if(financeService.insertFinanceInfo(finance)){
            flag = "S";
        }
        return flag;
    }


    //查询数量
    @RequestMapping(value = "/queryFinanceNum", method = RequestMethod.PUT)
    public Object queryFinanceNum(String condition){
        return financeService.queryFinanceNum(condition);
    }

    //查询所有的财务信息
    @RequestMapping(value = "/queryFinanceInfo", method = RequestMethod.PUT)
    public Object queryFinanceInfo(int page, int pageSize, String condition){
        if(condition == null){
            condition="";
        }
        return financeService.queryFinanceInfo(page,pageSize,condition);
    }

    //删除选中的财务消息
    @RequestMapping(value = "/deleteFinanceInfo", method = RequestMethod.PUT)
    public Object deleteFinanceInfo(int financeId){
        return financeService.deleteFinanceInfo(financeId);
    }


    //修改选中的财务信息
    @RequestMapping(value = "/updateFinanceInfo", method = RequestMethod.PUT)
    public Object updateFinanceInfo(@RequestBody Finance finance){
        return financeService.updateFinanceInfo(finance);
    }


    //根据financeId 查询数据
    @RequestMapping(value = "/queryByFinanceId", method = RequestMethod.PUT)
    public Object queryByFinanceId(int financeId){
        return financeService.queryByFinanceId(financeId);
    }
}
