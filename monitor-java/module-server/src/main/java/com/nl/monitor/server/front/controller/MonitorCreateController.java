package com.nl.monitor.server.front.controller;

import com.nl.monitor.entity.Monitor;
import com.nl.monitor.server.bean.ResponseMsg;
import com.nl.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @date 2019/11/15 10:52
 */
@RestController
@RequestMapping("/monitor/create")
public class MonitorCreateController{

    @Autowired
    MonitorService monitorService;

    @RequestMapping("/save")
    public ResponseMsg save(@RequestParam String title, @RequestParam String result) {

        Monitor monitor = monitorService.saveMonitor(title, result);

        ResponseMsg responseMsg = ResponseMsg.success();

        responseMsg.put("id", monitor.getId());

        return responseMsg;
    }

    @RequestMapping("/update")
    public ResponseMsg update(@RequestParam String result, @RequestParam String id) {

        monitorService.updateMonitor(id, result);

        return ResponseMsg.success();
    }

}
