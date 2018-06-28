package com.john.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.john.manager.UserService;
import com.john.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 张彦斌
 * @Date: 2018-06-26 14:45
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/user/getById/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getById(id);
    }

}
