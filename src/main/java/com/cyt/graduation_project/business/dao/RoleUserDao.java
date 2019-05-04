package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.userinfo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleUserDao {

    //插入用户角色信息 默认为用户角色
    @Insert("insert into user_role(user_id,role_id) values(#{userId},1)")
    void insertUserRoleInfo(User user);

    //根据用户id查询用户角色
    @Select("select role_id from user_role where user_id=#{userId}")
    int queryRoleIdByUserId(User user);
}
