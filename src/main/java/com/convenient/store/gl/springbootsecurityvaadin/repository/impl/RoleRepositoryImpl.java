package com.convenient.store.gl.springbootsecurityvaadin.repository.impl;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;
import com.convenient.store.gl.springbootsecurityvaadin.repository.IRoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 
 * @author p.ly
 *
 */
@Repository
@Transactional
public class RoleRepositoryImpl implements IRoleRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Role> getAllRole() {
        return getSession().createCriteria(Role.class).list();
        //return getSession().createCriteria(Role.class).list();
    }

    @Override
    public void saveRole(Role role) {
        getSession().save(role);
    }

    @Override
    public void updateRole(Role role) {
        getSession().update(role);
    }

    @Override
    public Role getRoleById(Long id)  {
        return (Role) getSession().get(Role.class, id);
    }
}
