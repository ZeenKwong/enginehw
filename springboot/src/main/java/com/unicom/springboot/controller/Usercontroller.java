package com.unicom.springboot.controller;

import com.unicom.springboot.entity.Users;
import com.unicom.springboot.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName：Usercontroller
 * @Author：kuangzy
 * @Time：2019/5/5 19:19
 * @Discription:discription
 */
@RestController
public class Usercontroller {
    @Autowired
    public UserService userService;

    @RequestMapping("/addUser")
    public int addUser(){
        Users user = new Users();
        user.setUserName("zeentest");
        user.setUserBirthday(new Date());
        return userService.addUserXml(user);
    }

}