package com.unicom.springboot.service.impl;

import com.unicom.springboot.entity.Users;
import com.unicom.springboot.mapper.UsersMapper;
import com.unicom.springboot.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：UserServiceImpl
 * @Author：kuangzy
 * @Time：2019/5/5 19:21
 * @Discription:discription
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper userMapper;

    @Override
    public int addUserXml(Users user) {
        return userMapper.insert(user);
    }
}
