package com.unicom.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.unicom.springboot.entity.Users;
import com.unicom.springboot.entity.UsersExample;
import com.unicom.springboot.mapper.UsersMapper;
import com.unicom.springboot.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        userMapper.insert(user);
        return user.getUserId();
    }

    @Override
    public List<Users> findUsers(int page, int rows) {
        UsersExample example = new UsersExample();
        PageHelper.startPage(page,rows);
        List<Users> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public List<Users> findAllUser(int userId) {
        UsersExample example = new UsersExample();
        if(userId != 0){
            UsersExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
        }
        List<Users> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public int deleteUserByPrimaryKey(int userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(Users users) {
        return userMapper.updateByPrimaryKeySelective(users);
    }
}
