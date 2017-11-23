package com.jk.controller;

import com.jk.model.UserBO;
import com.jk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangzhichao on 2017-11-14.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userList")
    public List<UserBO> userList() {
        List<UserBO> userBOs = userService.userList();
        return userBOs;
    }

    @RequestMapping("/findUserByName")
    public UserBO findUserByName(String name) {
        return userService.findUserByName(name);
    }
}
