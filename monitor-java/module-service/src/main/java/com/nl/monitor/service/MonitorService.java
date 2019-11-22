package com.nl.monitor.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nl.monitor.entity.Monitor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alex
 * @date 2019/11/15 10:43
 */
public interface MonitorService {

    @Transactional
    Monitor saveMonitor(String title, String result);

    @Transactional
    Monitor updateMonitor(String id, String result);

    @Transactional
    JSONArray monitorList();

    @Transactional
    JSONObject showDetail(String id);

}
