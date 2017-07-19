package com.convenient.store.gl.springbootsecurityvaadin.repository;

import com.convenient.store.gl.springbootsecurityvaadin.entities.User;

/**
 * Created by p.ly on 7/13/2017.
 */
public interface IUserRepository {
    User getByUsername(String username);
    User saveUser(User user);
    User updateUser(User user);
}
