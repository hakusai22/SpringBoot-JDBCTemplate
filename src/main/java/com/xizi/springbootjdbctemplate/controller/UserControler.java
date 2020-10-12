package com.xizi.springbootjdbctemplate.controller;

import com.xizi.springbootjdbctemplate.pojo.User;
import com.xizi.springbootjdbctemplate.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Resource
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(){
        return "一共插入数据有["+userService.insertUser()+"]条";
    }

    @RequestMapping("/selectByUsername")
    public User selectByUsername(String username){
        return userService.selectByUsername(username);
    }

    @RequestMapping("/selectById")
    public User selectById(Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "更新成功";
    }

    @RequestMapping("/delete")
    public String  delete(Integer id){
        userService.delete(id);

        return "删除成功";
    }
}
