/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.ui;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * 
 * @author p.ly
 *
 */
@SpringUI(path = "/access-denied")
@Title("Access Denied")
public class AccessDeniedUI extends UI{

    @Override
    protected void init(VaadinRequest request) {
    
        setContent(new Label("Hello! I'm the Access Denied UI!"));
    }
}
