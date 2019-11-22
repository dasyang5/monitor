package com.nl.monitor.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nl.monitor.entity.Monitor;
import com.nl.monitor.repository.MonitorRepository;
import com.nl.monitor.repository.UserRepository;
import com.nl.monitor.service.MonitorService;
import com.nl.monitor.service.utils.ClobUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Alex
 * @date 2019/11/15 10:50
 */
@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Monitor saveMonitor(String title, String result) {
        return monitorRepository.save(
                new Monitor(
                        userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).getId(),
                        title,
                        ClobUtils.stringToClob(result)
                )
        );
    }

    @Override
    public Monitor updateMonitor(String id, String result) {

        Optional<Monitor> monitorOptional = monitorRepository.findById(id);

        if (monitorOptional.isPresent()) {

            Monitor monitor = monitorOptional.get();

            monitor.setResult(ClobUtils.stringToClob(result));

            monitor.setUpdateTime(new Date());

            return monitorRepository.save(monitor);
        } else {
            return null;
        }

    }

    @Override
    public JSONArray monitorList() {

        JSONArray array = new JSONArray();

        for (Object[] o : monitorRepository.findMonitorTitleListByUserId(
                userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).getId()
        )) {
            array.add(new JSONObject()
                    .fluentPut("id", o[0])
                    .fluentPut("title", o[1]));
        }

        return array;
    }

    @Override
    public JSONObject showDetail(String id) {

        Optional<Monitor> monitorOptional = monitorRepository.findById(id);

        if (monitorOptional.isPresent()) {
            Monitor m = monitorOptional.get();
            return new JSONObject()
                    .fluentPut("id", m.getId())
                    .fluentPut("title", m.getTitle())
                    .fluentPut("result", ClobUtils.clobToString(m.getResult()));
        }

        return null;
    }
}
