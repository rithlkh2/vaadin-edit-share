/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.ui;

import com.convenient.store.gl.springbootsecurityvaadin.entities.Role;
import com.convenient.store.gl.springbootsecurityvaadin.entities.User;
import com.convenient.store.gl.springbootsecurityvaadin.services.IRoleService;
import com.convenient.store.gl.springbootsecurityvaadin.services.IUserService;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Alignment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author p.ly
 *
 */
@SpringUI(path = "/userpanel")
@Title("insert user")
public class UserPanel  extends UI{
	private TextField lastName;
	private TextField firtName;
	private TextField userName;
	private PasswordField password;
	private ComboBox<Role> cbxRole ;
	private Button create ;
	@Autowired
	private IRoleService iRoleService;
	@Autowired
	private IUserService iUserService;

	@Override
	protected void init(VaadinRequest request) {
		lastName = new TextField();
		firtName = new TextField();
		userName =new TextField();
		password = new PasswordField();
		create = new Button("Creat User");
		cbxRole = new ComboBox<Role>();

		List<Role> roleList = new ArrayList<>();
		roleList = iRoleService.getAllRole();
		cbxRole.setItems(roleList);
		for(Role role : roleList){
			cbxRole.setDescription(role.getName());
		}
		create.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				assignValue();
				Notification.show("Saved");
			}
		});

		GridLayout gridLayout = new GridLayout(2, 7);
		gridLayout.setSpacing(true);
		gridLayout.addComponent(new Label("Last Name"));
		gridLayout.addComponent(lastName);
		gridLayout.addComponent(new Label("First Name"));
		gridLayout.addComponent(firtName);
		gridLayout.addComponent(new Label("User Name"));
		gridLayout.addComponent(userName);
		gridLayout.addComponent(new Label("Password"));
		gridLayout.addComponent(password);
		gridLayout.addComponent(new Label("User Role"));
		gridLayout.addComponent(cbxRole);
		gridLayout.addComponent(create);

		VerticalLayout uiLayout = new VerticalLayout(gridLayout);
		uiLayout.setSizeFull();
		uiLayout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);

		setContent(uiLayout);
	}
	/**
	 * assignValue
	 */
	public void assignValue(){
		User user = new User();
		user.setFirstName(firtName.getValue());
		user.setLastName(lastName.getValue());
		user.setUsername(userName.getValue());
		user.setPassword(password.getValue());
		Role role = cbxRole.getSelectedItem().get();
		List<Role> roleList = new ArrayList<>();
		roleList.add(role);
		user.setRoles(roleList);
		iUserService.saveUser(user);
		reset();
	}
	/**
	 * reset
	 */
	public void reset(){
		lastName.setValue("");
		firtName.setValue("");
		userName.setValue("");
		password.setValue("");
		cbxRole.setSelectedItem(null);
	}
}
