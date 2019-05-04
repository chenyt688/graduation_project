package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.RoleMenuDao;
import com.cyt.graduation_project.business.entry.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 根据角色id 查找对应的权限菜单
     * @param roleId
     * @return
     */
    public Role getMenuByRoleId(int roleId){
        return roleMenuDao.getMenuByRoleId(roleId);
    }
}
