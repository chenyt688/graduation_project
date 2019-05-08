package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.RoleUserDao;
import com.cyt.graduation_project.business.dao.UserDao;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.sys.util.GenerateInfo;
import com.cyt.graduation_project.sys.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleUserDao roleUserDao;

    /**
     * 根据用户的账号密码和角色查询用户信息
     * @param user
     * @return
     */
    public User getUserInfo(User user){
        int roleId = user.getRoleId();
        user = userDao.getUserInfo(user.getUserAccount(),user.getUserPassword(),roleId);
        return user;
    }

    /**
     * 根据用户电话号码查询用户信息
     * @param user
     * @return
     */
    public User getUserInfoByPhone(User user){
        return userDao.getUserInfoByPhone(user.getUserPhone());
    }

    /**
     * 用户通过电话号码注册信息
     * @param user
     */
    @Transactional
    public void registerUser(User user){
        //自动生成用户账号
        if(user.getUserAccount() == null || user.getUserAccount() == ""){
            user.setUserAccount(GenerateInfo.getAccount());
        }
        //插入用户数据
        userDao.registerUser(user);
        user = userDao.getUserInfoByPhone(user.getUserPhone());
        //用户与角色关联
        roleUserDao.insertUserRoleInfo(user);
    }

    /**
     * 更新用户数据
     * @param user
     */
    @Transactional
    public boolean editUserInfo(User user){
        User userInfoByPhone = userDao.getUserInfoByPhone(user.getUserPhone());

        User uesrInfoByAccount= userDao.getUserInfoByUserAccount(user);

        //修改后的账号、电话都不存在
        if(userInfoByPhone==null && uesrInfoByAccount == null){
            return userDao.editUserInfo(user);
        }

        //修改后的号码不存在 账号存在
        if(userInfoByPhone==null&& uesrInfoByAccount.getUserId()==user.getUserId()){
            return userDao.editUserInfo(user);
        }
        //修改后的账号不存在 电话号码存在
        if(uesrInfoByAccount==null && userInfoByPhone.getUserId() == user.getUserId()){         //用户存在且为一个
            return userDao.editUserInfo(user);
        }
        //判断账号和电话是否被注册

        if(userInfoByPhone.getUserId() == uesrInfoByAccount.getUserId() && uesrInfoByAccount.getUserId()==user.getUserId()){
            return userDao.editUserInfo(user);
        }
        return false;
    }

    /**
     * 新增用户数据
     * @param user
     */
    @Transactional
    public boolean addUserInfo(User user){

        int account = userDao.queryAccount(user);
        if(account==0){    //用户不存在
            if(user.getUserAccount() == null || user.getUserAccount() == ""){
                user.setUserAccount(GenerateInfo.getAccount());
            }
            return userDao.addUserInfo(user);
        }
        return false;
    }

    /**
     * 判断用户账号是否已经存在或被使用
     * @param user
     * @return
     */
    public boolean judgeUserByAccount(User user){
        return userDao.judgeUserByAccount(user);

    }

    /**
     * 用户修改密码
     * @param user
     */
    public void updateUserPassword(User user){
        userDao.updateUserPassword(user);
    }
    //查询所有用户数据并分页
    public List<User> getAllUserInfo(int page,int pageSize){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return userDao.getAllUserInfo(startIndex,pageSize);
    }

    //通过用户id删除用户数据
    public boolean deleteUserInfoByUserId(String userId){
        return userDao.deleteUserInfoByUserId(userId);
    }
    //通过用户id批量删除用户数据
    public boolean deleteMulUserInfoByUserId(String userId){
        String[] userIdArr = userId.split(",");
        return userDao.deleteMulUserInfoByUserId(userIdArr);
    }

    //获取用户数量
    public int getUserInfoNum( ){
        return userDao.getUserInfoAccount();
    }

    //获取用户数量通过条件查询
    public int getUserInfoNumByCondition(String condition){
        return userDao.getUserInfoNumByCondition(condition);
    }

    //通过条件查询所有用户数据并分页
    public List<User> getUserInfoByCondition(int page,int pageSize,String condition){
        int startIndex = PageUtil.getPageArea(page,pageSize);
        return userDao.getUserInfoByCondition(startIndex,pageSize,condition);
    }

    //获取用户信息根据用户id
    public User getUserInfoByUserId(User user){
        return userDao.getUserInfoByUserId(user);
    }

}
