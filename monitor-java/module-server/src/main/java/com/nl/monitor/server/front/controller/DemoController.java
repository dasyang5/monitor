package com.nl.monitor.server.front.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nl.monitor.server.bean.ResponseMsg;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Alex
 * @date 2019/11/22 16:05
 */
@RestController
@RequestMapping("/demo")
@CrossOrigin
public class DemoController {

    private final String[] keys = {"A","B","C","D","E","F","G"};

    private Random random = new Random();

    @RequestMapping("/bar")
    public ResponseMsg bar() {
        ResponseMsg responseMsg = ResponseMsg.success();

        JSONArray array = new JSONArray();

        JSONArray defines = new JSONArray();
        defines.add("key");
        defines.add("value");
        array.add(defines);
        for (int i = 0; i < keys.length; i++) {
            JSONArray temp = new JSONArray();
            temp.add(keys[i]);
            temp.add(random.nextInt(100));
            array.add(temp);
        }
        responseMsg.put("result", new JSONObject().fluentPut("source", array));
        return responseMsg;
    }


}
