package com.convenient.store.gl.springbootsecurityvaadin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;
import com.convenient.store.gl.springbootsecurityvaadin.repository.IRoleRepository;
import com.convenient.store.gl.springbootsecurityvaadin.services.IRoleService;

/**
 * Created by p.ly on 7/13/2017.
 */
@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.getAllRole();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.updateRole(role);
    }
}
