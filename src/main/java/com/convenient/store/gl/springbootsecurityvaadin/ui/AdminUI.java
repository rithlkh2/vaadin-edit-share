/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.ui;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author p.ly
 *
 */
@SpringUI(path = "/admin")
@Title("LoginPage")
public class AdminUI  extends UI{
    private Button createUser ;
    private Button createRole ;
    
    protected void init(VaadinRequest request) {
    	createUser = new Button("Creat User");
    	createUser.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				 getPage().setLocation("http://localhost:8081/userpanel");
		           getSession().close();
		           setPollInterval(9000);
			}
		});
    	createRole = new Button("Creat Role");
    	createRole.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				 getPage().setLocation("http://localhost:8081/rolepanel");
		           getSession().close();
		           setPollInterval(9000);
			}
		});
    	GridLayout gridLayout = new GridLayout(2, 7);
    	gridLayout.setSpacing(true);
    	gridLayout.addComponent(createUser);
    	gridLayout.addComponent(createRole);
    	VerticalLayout uiLayout = new VerticalLayout(gridLayout);
    	uiLayout.setSizeFull();
        uiLayout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);
    	
        setContent(uiLayout);
    }
    
}
