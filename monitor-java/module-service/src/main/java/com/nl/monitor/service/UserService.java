package com.nl.monitor.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alex
 * @date 2019/10/31 9:46
 */
public interface UserService {

    /**
     * 新增用户
     * @param userName
     * @param password
     */
    @Transactional
    void addUser(String userName, String password);

    /**
     * Spring Security验证用户登录信息
     * @param userName
     * @return
     */
    @Transactional
    UserDetails getUserDetailByUserName(String userName);
}
