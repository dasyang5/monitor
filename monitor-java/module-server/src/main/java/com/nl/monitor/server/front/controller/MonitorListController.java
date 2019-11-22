package com.nl.monitor.server.front.controller;

import com.nl.monitor.server.bean.ResponseMsg;
import com.nl.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @date 2019/11/18 10:55
 */
@RestController
@RequestMapping("/monitor/list")
public class MonitorListController {

    @Autowired
    MonitorService monitorService;

    @RequestMapping("/")
    public ResponseMsg list() {

        ResponseMsg responseMsg = ResponseMsg.success();

        responseMsg.put("items", monitorService.monitorList());

        return responseMsg;
    }

    @RequestMapping("/showDetail")
    public ResponseMsg showDetail(@RequestParam String id){

        ResponseMsg responseMsg = ResponseMsg.success();

        responseMsg.put("item", monitorService.showDetail(id));

        return responseMsg;
    }



}
