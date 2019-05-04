package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.userinfo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //根据用户的账号密码和角色查询用户信息
    User getUserInfo(@Param("userAccount") String userAccount, @Param("userPassword") String userPassword, @Param("roleId") int roleId);

    //根据用户电话号码查询用户信息
    User getUserInfoByPhone(@Param("userPhone") String userPhone);

    //用户通过电话号码注册信息,注册时间自动生成
    @Insert("insert into userInfo(user_account,user_phone,role_id,del_flag) values(#{userAccount},#{userPhone},#{roleId},#{delFlag})")
    void registerUser(User user);

    // 判断用户账号是否已经存在或被使用
    boolean judgeUserByAccount(User user);

    @Update("update userInfo set user_password = #{userPassword}  where user_phone = #{userPhone}")
    void updateUserPassword(User user);

    //获取所有用户数据
    @Select("select * from userInfo where del_flag = 1 limit #{startIndex},#{pageSize}")
    List<User> getAllUserInfo(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    //通过用户id删除用户数据（逻辑删除）
    boolean deleteUserInfoByUserId(String userId);

    //批量通过用户id删除用户数据（逻辑删除）
    boolean deleteMulUserInfoByUserId(String[] userIdArr);

    //获取用户数量
    @Select("SELECT COUNT(*)  from userInfo where del_flag = 1")
    int getUserInfoAccount();

    //获取用户数量通过条件查询
    int getUserInfoNumByCondition(@Param("condition") String condition);

    //通过条件查询用户数据
    List<User> getUserInfoByCondition(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("condition") String condition);

    //用户数据修改
    boolean editUserInfo(User user);

    //增加用户
    boolean addUserInfo(User user);

    //查询用户账号是否存在
    @Select("select COUNT(*)  from userInfo where user_account = #{userAccount}")
    int queryAccount(User user);

    //获取用户信息通过userId
    @Select("select * from userInfo where user_id = #{userId}")
    User getUserInfoByUserId(User user);


    //根据用户电话号码查询用户数量
    @Select("select COUNT(*)  from userInfo where user_phone = #{userPhone}")
    int getUserInfoNumByPhone(User user);


    //获取用户信息通过账号
    @Select("SELECT * from userInfo where user_account = #{userAccount}")
    User getUserInfoByUserAccount(User user);


}