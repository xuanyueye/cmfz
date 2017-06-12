package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GXL on 2017/5/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 添加用户
     */
    @RequestMapping("/add")
    @ResponseBody
    public void add(User user){
        //1.获取client请求的数据(并为id赋值)
        try {//调用dao层方法完成功
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 删除用户
     */
    @RequestMapping("/remove")
    @ResponseBody
    public void remove(User user){
        try {
            userService.removeUser(user.getUid());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * 查找一个用户
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public User queryOne(User user, HttpServletRequest request){
        try {
            user=userService.QueryOneUser(user.getUid());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
    }
    /**
     * 修改用户
     */
    @RequestMapping("/change")
    @ResponseBody
    public void change(User user){
        try {
            userService.changeUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String,Object> queryAll(Integer page, Integer rows){
        Page<User> pageuser= userService.queryByPage(page,rows);
        List<User> list = pageuser.getResult();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",pageuser.getTotal());
        map.put("rows",list);

        return map;
    }

}

