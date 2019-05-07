package com.unicom.springboot.service.service;


import com.unicom.springboot.entity.Users;

import java.util.List;

/**
 * @ClassName：UserService
 * @Author：kuangzy
 * @Time：2019/5/5 19:23
 * @Discription:discription
 */
public interface UserService {
    //添加用户
    int addUserXml(Users user);

    //分页查询
    List<Users> findUsers(int page,int rows);

    //查询全部
    List<Users> findAllUser();

    //删除指定
    int deleteUserByPrimaryKey(int userId);
}
