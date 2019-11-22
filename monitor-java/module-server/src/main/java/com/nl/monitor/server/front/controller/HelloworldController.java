package com.nl.monitor.server.front.controller;

import com.nl.monitor.server.bean.ResponseMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @date 2019/10/30 10:10
 */
@RestController
@RequestMapping("/")
public class HelloworldController {

    @RequestMapping("/")
    public ResponseMsg hello() {

        return ResponseMsg.success();

    }
}
