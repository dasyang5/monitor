package com.nl.monitor.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        System.out.println(new Date());
        System.out.println(tokyoSdf.format(new Date()));
    }

}
