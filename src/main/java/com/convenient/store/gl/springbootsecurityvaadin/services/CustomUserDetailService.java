/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.convenient.store.gl.springbootsecurityvaadin.entities.User;

/**
 * 
 * @author p.ly
 *
 */
@Service("CustomUserDetailService")
@Transactional
public class CustomUserDetailService implements UserDetailsService{


	@Autowired
	private IUserService iUserService;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = iUserService.findUserByUsername(s);

		if(user == null)
		{
			System.out.println("User not found!");
		}
		return user;
	}
    
}
