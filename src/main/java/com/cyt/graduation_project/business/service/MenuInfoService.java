package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.MenuInfoDao;
import com.cyt.graduation_project.business.entry.menu.Basemenu;
import com.cyt.graduation_project.business.entry.role.Role;
import com.cyt.graduation_project.business.entry.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {
    @Autowired
    private MenuInfoDao menuInfoDao;

    /**
     * 获取菜单
     * @return
     */
    public List<Basemenu> getBaseMenu(){
        return menuInfoDao.getBaseMenu();
    }




}
