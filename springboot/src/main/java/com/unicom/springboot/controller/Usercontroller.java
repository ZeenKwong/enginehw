package com.unicom.springboot.controller;

import com.unicom.springboot.entity.Users;
import com.unicom.springboot.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody Users users){
        Users user = new Users();
        user.setUserName(users.getUserName());
        user.setUserSex(users.getUserSex());
        user.setUserAddress(users.getUserAddress());
        user.setUserBirthday(user.getUserBirthday());
        return userService.addUserXml(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody Users users){
        Users user = new Users();
        user.setUserId(users.getUserId());
        user.setUserName(users.getUserName());
        user.setUserSex(users.getUserSex());
        user.setUserAddress(users.getUserAddress());
        user.setUserBirthday(user.getUserBirthday());
        return userService.updateUserInfo(user);
    }

    @RequestMapping("/findUsersxml/{page}/{rows}")
    public List<Users> findUsersxml(@PathVariable int page,@PathVariable int rows){
        return userService.findUsers(page,rows);
    }

    @RequestMapping("/findAllUser")
    public List<Users> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/deleteUserByPrimaryKey/{userId}")
    public int deleteUserByPrimaryKey(@PathVariable int userId){
        return userService.deleteUserByPrimaryKey(userId);
    }

}
