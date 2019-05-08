package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.entry.menu.Basemenu;
import com.cyt.graduation_project.business.entry.role.Role;
import com.cyt.graduation_project.business.entry.userinfo.User;
import com.cyt.graduation_project.business.service.MenuInfoService;
import com.cyt.graduation_project.business.service.RoleMenuService;
import com.cyt.graduation_project.business.service.RoleUserService;
import com.cyt.graduation_project.business.service.UserService;
import com.cyt.graduation_project.sys.util.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
public class LoginController {

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleUserService roleUserService;
    /**
     * 账号密码方法登录
     * @param user
     */
    @RequestMapping("/acountLogin")
    @ResponseBody
    public Object acountLogin(User user,HttpServletRequest request){
        user = userService.getUserInfo(user);
        if(user != null){    //登录
            //用户存在，数据保存到session中
            HttpSession session = request.getSession(true);
            session.setAttribute("userInfo",user);
            return user;
        }
        return "F";
    }
    /**
     * 通过短信验证登录
     * @param user
     */
    @RequestMapping("/phoneLogin")
    @ResponseBody
    public Object phoneLogin(User user,HttpServletRequest request){
        //通过用户注册的电话号码查询用户信息
        user = userService.getUserInfoByPhone(user);
        //int role = roleUserService.queryRoleIdByUserId(user);
        //user.setRoleId(role);
        //System.out.println(user.toString());
        if(user != null){    //登录
            //用户存在，数据保存到session中
            HttpSession session = request.getSession(true);
            session.setAttribute("userInfo",user);
            return user;
        }
        return "F";
    }


    //若无用户角色，默认游客模式，获取子菜单
    @RequestMapping("/getSupmenu")
    @ResponseBody
    public Role getSupmenu(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userInfo");
        Role menuByRoleId = null;
        if(user != null){
            menuByRoleId = roleMenuService.getMenuByRoleId(user.getRoleId());
        }else {          //游客模式
            menuByRoleId = roleMenuService.getMenuByRoleId(3);
        }
        return menuByRoleId;
    }


    /**
     * 获取基础菜单
     * @return
     */
    @RequestMapping("/getBaseMenu")
    @ResponseBody
    public Object getMenuList(){
        List<Basemenu> baseMenu = menuInfoService.getBaseMenu();
        return baseMenu;

    }

    /**
     * 向用户手机发送验证码
     * @param userPhone
     * @return
     */

    @RequestMapping("/yzmData")
    @ResponseBody
    public Object yzmData(String userPhone){
        System.out.println(userPhone);
        SendMessage sendMessage = new SendMessage();                //调用方法向用户手机发送验证码
        //String news = sendMessage.sendNews(userPhone);
        return "6666";
    }

    /**
     *用户退出登陆
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    public Object loginOut(User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:http://localhost:8080/";
    }



}
