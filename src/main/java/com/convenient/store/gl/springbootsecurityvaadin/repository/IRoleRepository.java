package com.convenient.store.gl.springbootsecurityvaadin.repository;

import java.util.List;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;

/**
 * Created by p.ly on 7/13/2017.
 */
public interface IRoleRepository {
    Role getRoleById(Long id);

    void saveRole(Role role);

    void updateRole(Role role);

    List<Role> getAllRole();
}
