package com.convenient.store.gl.springbootsecurityvaadin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.convenient.store.gl.springbootsecurityvaadin.entities.User;
import com.convenient.store.gl.springbootsecurityvaadin.repository.IUserRepository;
import com.convenient.store.gl.springbootsecurityvaadin.services.IUserService;

/**
 * Created by p.ly on 7/13/2017.
 */
@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public User findUserByUsername(String username) {
        return iUserRepository.getByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return iUserRepository.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return iUserRepository.updateUser(user);
    }
}
