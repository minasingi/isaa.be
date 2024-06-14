package com.example.demo.services;

import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public RefreshTokenService(@Qualifier("userDetailsService") UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public String refreshToken(String refreshToken) {
        String username = jwtUtil.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(jwtUtil.validateToken(refreshToken, userDetails)){
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }
}
