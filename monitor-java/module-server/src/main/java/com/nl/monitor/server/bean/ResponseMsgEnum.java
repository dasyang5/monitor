package com.nl.monitor.server.bean;

/**
 * @author Alex
 * @date 2019/10/30 10:42
 */
public enum ResponseMsgEnum {

    /**
     * 请求成功
     */
    SUCCESS("0000", "Request successfully!"),
    /**
     * 请求失败  类别1
     */
    ERROR_1_("1001",""),
    /**
     * 请求失败  类别2
     */
    ERROR_2_("2001","")
    ;

    private String code;

    private String msg;

    ResponseMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
