package com.yjytke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.yjytke.entity.KeUser;
import com.yjytke.service.user.UserService;

/**
 * @author wuynje
 * @time 2018年8月14日 下午8:05:08
 * @version 1.0
 * @description:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(KeUser user){
        return 1;
    }

}
