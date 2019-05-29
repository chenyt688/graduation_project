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
import org.springframework.web.bind.annotation.RequestMethod;
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
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            if(session.getAttribute(user.getUserId()+"") != null){
                return "F1";
            }else {
                session.setAttribute(user.getUserId()+"",user);
                return user;
            }

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
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            if(session.getAttribute(user.getUserId()+"") != null){
                return "F1";
            }else {
                session.setAttribute(user.getUserId()+"",user);
                return user;
            }
        }
        return "F";
    }


    //若无用户角色，默认游客模式，获取子菜单
    @RequestMapping(value = "/getSupmenu",method = RequestMethod.PUT )
    @ResponseBody
    public Object getSupmenu(HttpServletRequest request,String userIdStr){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(userIdStr);
        Role menuByRoleId = null;
        if(user != null){
            menuByRoleId = roleMenuService.getMenuByRoleId(user.getRoleId());
        }else {          //游客模式
            menuByRoleId = roleMenuService.getMenuByRoleId(3);
        }
        System.out.println(menuByRoleId);
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
        System.out.println(baseMenu);
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
        SendMessage sendMessage = new SendMessage();                //调用方法向用户手机发送验证码
        String news = sendMessage.sendNews(userPhone);
        return news;
        //return "6666";
    }

    /**
     *用户退出登陆
     * @param userIdStr
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    public Object loginOut(Integer userIdStr,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(userIdStr+"");
        return "redirect:http://localhost:8080/";
    }



}
