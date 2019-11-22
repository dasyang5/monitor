package com.nl.monitor.server.config.web;

import com.nl.monitor.server.config.jwt.JwtAuthenticationFilter;
import com.nl.monitor.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Alex
 * @date 2019/10/31 10:05
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//启用Spring security的前注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private WebSecurityEntryPoint webSecurityEntryPoint;

    @Autowired
    private WebSecuritySuccessHandle webSecuritySuccessHandle;

    @Autowired
    private WebSecurityFailureHandle webSecurityFailureHandle;

    @Bean
    public JwtAuthenticationFilter getJwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder())//指定密码在数据库存储时的加密格式
        ;
    }

    @Override
    public void configure(WebSecurity web) {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(getJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//使用token，禁用session
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/demo/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/login")
                .successHandler(webSecuritySuccessHandle)//登录成功
                .failureHandler(webSecurityFailureHandle)//登录失败
                .and().exceptionHandling().authenticationEntryPoint(webSecurityEntryPoint);//未登录请求资源
    }
}
