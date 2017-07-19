/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.security.impl;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;
import com.convenient.store.gl.springbootsecurityvaadin.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.convenient.store.gl.springbootsecurityvaadin.security.ISecurity;

/**
 * 
 * @author p.ly
 *
 */
@Service
public class SecurityImpl implements ISecurity{
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    @Qualifier(value="CustomUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    public Role autoLogin(String username, String password) {
        boolean isLogin = false;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        User user = (User) userDetails;
        Role role= user.getRoles().get(0);
        usernamePasswordAuthenticationToken.isAuthenticated();
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        isLogin = true;

        return role;
    }
    
}
