package com.nl.monitor.server.front.controller;

import com.nl.monitor.server.bean.ResponseMsg;
import com.nl.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @date 2019/10/31 10:01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ResponseMsg add() {

        userService.addUser("alex", "alex");

        return ResponseMsg.success();

    }

    //指定角色访问
    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping("/delete")
    public ResponseMsg delete(){

        return ResponseMsg.success();
    }

}
