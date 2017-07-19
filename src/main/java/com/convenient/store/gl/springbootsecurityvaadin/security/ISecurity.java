/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.security;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;

/**
 * 
 * @author p.ly
 *
 */
public interface ISecurity {
    Role autoLogin(String username, String password);
}
