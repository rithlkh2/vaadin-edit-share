package com.convenient.store.gl.springbootsecurityvaadin.repository.impl;

import com.convenient.store.gl.springbootsecurityvaadin.entities.User;
import com.convenient.store.gl.springbootsecurityvaadin.repository.IUserRepository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by p.ly on 7/13/2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getByUsername(String username) {
        Criteria cr = sessionFactory.openSession().createCriteria(User.class);
        cr.add(Restrictions.eq("username", username));
        return (User) cr.uniqueResult();
    }

    @Override
    public User saveUser(User user) {

        User usr = getByUsername(user.getUsername());
        if(usr == null)
        {
            getSession().save(user);
        }

        return usr;
    }

    @Override
    public User updateUser(User user) {
        User usr = getByUsername(user.getUsername());
        if(usr == null)
        {
            getSession().update(user);
        }

        return usr;
    }
}
