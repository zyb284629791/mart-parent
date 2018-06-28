package com.john.manager.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.john.manager.UserService;
import com.john.mapper.UserMapper;
import com.john.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 张彦斌
 * @Date: 2018-06-26 16:53
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
