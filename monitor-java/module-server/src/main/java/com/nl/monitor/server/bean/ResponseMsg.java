package com.nl.monitor.server.bean;

import java.util.HashMap;

/**
 * @author Alex
 * @date 2019/10/30 10:13
 */
public class ResponseMsg extends HashMap<String,Object> {

    public static ResponseMsg error(ResponseMsgEnum responseMsgEnum) {

        ResponseMsg rm = new ResponseMsg();
        rm.put("code", responseMsgEnum.getCode());
        rm.put("msg", responseMsgEnum.getMsg());
        return rm;

    }

    public static ResponseMsg error(String code, String msg) {

        ResponseMsg rm = new ResponseMsg();
        rm.put("code", code);
        rm.put("msg", msg);
        return rm;

    }

    public static ResponseMsg success() {

        ResponseMsg rm = new ResponseMsg();
        rm.put("code", ResponseMsgEnum.SUCCESS.getCode());
        rm.put("msg", ResponseMsgEnum.SUCCESS.getMsg());
        return rm;

    }


}
