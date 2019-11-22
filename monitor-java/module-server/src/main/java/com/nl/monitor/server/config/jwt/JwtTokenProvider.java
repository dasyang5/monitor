package com.nl.monitor.server.config.jwt;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.util.Date;
/**
 * @author Alex
 * @date 2019/10/31 11:11
 */
@Component
public class JwtTokenProvider {

    public String createJwtToken(Authentication authentication) {

        return Jwts.builder()
                //用户名
                .setSubject(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis()+AuthConfig.TOKEN_EXPIRED_TIME))
                //发放时间
                .setIssuedAt(new Date())
                //密钥
                .signWith(SignatureAlgorithm.HS512, AuthConfig.JWT_TOKEN_SECRET)

                .compact();

    }

    public boolean validateToken(String token) {

        try {

            Jwts.parser()

                    .setSigningKey(AuthConfig.JWT_TOKEN_SECRET)

                    .parseClaimsJws(token);

            return true;

        }catch (Exception ex) {

            return false;

        }

    }
}
