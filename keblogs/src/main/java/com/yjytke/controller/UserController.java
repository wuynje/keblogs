package com.yjytke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yjytke.entity.KeUser;
import com.yjytke.service.user.UserService;

/**
 * @author wuynje
 * @time 2018年8月14日 下午8:05:08
 * @version 1.0
 * @description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(KeUser user){
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}
