package com.nl.monitor.service.impl;

import com.nl.monitor.entity.User;
import com.nl.monitor.repository.UserRepository;
import com.nl.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @date 2019/10/31 10:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String userName, String password) {

        //用户密码使用BCrypt加密存储
        userRepository.save(
                new User(
                        userName,
                        new BCryptPasswordEncoder().encode(password)
                )
        );

    }

    public UserDetails getUserDetailByUserName(String userName) {

        /**
         * 用户信息
         */
        User user = userRepository.findByUserName(userName);

        /**
         * 权限
         */
        List<String> roles = new ArrayList<>();
        roles.add("user");

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                roles.stream().map(e -> new SimpleGrantedAuthority(e)).collect(Collectors.toList()));
    }

}
