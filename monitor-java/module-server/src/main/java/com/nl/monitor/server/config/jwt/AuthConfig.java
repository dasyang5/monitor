package com.nl.monitor.server.config.jwt;

/**
 * @author Alex
 * @date 2019/10/31 11:05
 */
public class AuthConfig {

    /**
     * JWT token加密密钥
     */
    public static String JWT_TOKEN_SECRET = "MONITOR";

    /**
     * Token过期时间
     *      单位 毫秒
     */
    public static long TOKEN_EXPIRED_TIME = 2 * 24 * 60 * 60 * 1000;

}
