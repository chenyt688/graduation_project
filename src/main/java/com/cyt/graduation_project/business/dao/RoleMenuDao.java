package com.cyt.graduation_project.business.dao;

import com.cyt.graduation_project.business.entry.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMenuDao {

    //根据角色id 查找对应的权限菜单
    Role getMenuByRoleId(@Param("roleId")int roleId);
}
