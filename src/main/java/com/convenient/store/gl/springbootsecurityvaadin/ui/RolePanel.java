/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;
import com.convenient.store.gl.springbootsecurityvaadin.services.IRoleService;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author p.ly
 *
 */
@SpringUI(path = "/rolepanel")
@Title("insert role")
public class RolePanel  extends UI{
    private TextField txtrole;
    private CheckBox cbStatus;
    private Button create ;
    @Autowired
    private IRoleService iRoleService;
    @Override
    protected void init(VaadinRequest request) {
    	cbStatus = new  CheckBox("Active");
    	txtrole = new TextField();
    	create = new Button("Creat User");
    	create.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				assignValue();
				Notification.show("Saved");
			}
		});
    	
    	GridLayout gridLayout = new GridLayout(2, 3);
    	gridLayout.setSpacing(true);
    	
    	gridLayout.addComponent(new Label("User Role"));
    	gridLayout.addComponent(txtrole);
    	
    	gridLayout.addComponent(new Label("User Role"));
    	gridLayout.addComponent(cbStatus);
    	gridLayout.addComponent(create);
    	
    	VerticalLayout uiLayout = new VerticalLayout(gridLayout);
    	uiLayout.setSizeFull();
        uiLayout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);
    	
        setContent(uiLayout);
    }
    /**
     * assignValueSave
     */
    public void assignValue(){
    	Role role = new Role();
    	role.setName(txtrole.getValue());
    	role.setStatus(cbStatus.getValue());
    	iRoleService.saveRole(role);
    }
}
