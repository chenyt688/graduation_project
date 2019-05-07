package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.finance.Finance;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface FinanceDao {

    //新增财务记录
    @Insert("insert into financeinfo(finance_type,finance_about,finance_channel,finance_amount,user_name)" +
            "value(#{financeType},#{financeAbout},#{financeChannel},#{financeAmount},#{userName})")
    boolean insertFinanceInfo(Finance finance);


    //查询数量
    @Select("select count(*) from financeinfo where finance_type like CONCAT(CONCAT('%', #{condition}), '%')" +
            "or finance_about like CONCAT(CONCAT('%', #{condition}), '%') or " +
            "finance_channel like CONCAT(CONCAT('%', #{condition}), '%') or " +
            "user_name like CONCAT(CONCAT('%', #{condition}), '%')")
    int queryFinanceNum(String condition);

    //查询所有的财务信息
    @Select("select * from financeinfo where finance_type like CONCAT(CONCAT('%', #{condition}), '%') or " +
            "finance_about like CONCAT(CONCAT('%', #{condition}), '%') or " +
            "finance_channel like CONCAT(CONCAT('%', #{condition}), '%') or " +
            "user_name like CONCAT(CONCAT('%', #{condition}), '%') limit #{startIndex},#{pageSize}")
    ArrayList<Finance> queryFinanceInfo(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize,
                                        @Param("condition") String condition);

    //删除选中的财务消息
    @Delete("delete from financeinfo where finance_id =#{financeId}")
    boolean deleteFinanceInfo(int financeId);


    //修改选中的财务信息
    @Update("update financeinfo set finance_type=#{financeType},finance_about=#{financeAbout}," +
            "finance_channel=#{financeChannel},finance_amount=#{financeAmount},user_name=#{userName}" +
            " where finance_id =#{financeId}")
    boolean updateFinanceInfo(Finance finance);

    @Select("select * from financeinfo where finance_id =#{financeId}")
    Finance queryByFinanceId(int financeId);
}
