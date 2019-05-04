package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.RoleUserDao;
import com.cyt.graduation_project.business.entry.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUserService {
    @Autowired
    private RoleUserDao roleUserDao;

    /**
     *根据用户id查询用户角色
     * @param user
     * @return
     */
    public int queryRoleIdByUserId(User user){
        return roleUserDao.queryRoleIdByUserId(user);
    }
}
