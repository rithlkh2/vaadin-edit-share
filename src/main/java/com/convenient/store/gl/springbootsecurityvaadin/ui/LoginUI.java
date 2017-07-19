/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convenient.store.gl.springbootsecurityvaadin.ui;

import com.convenient.store.gl.springbootsecurityvaadin.security.ISecurity;
import com.convenient.store.gl.springbootsecurityvaadin.services.impl.RoleServiceImpl;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;

/**
 * 
 * @author p.ly
 *
 */
@SpringUI(path = "/login")
@Title("LoginPage")
@AutoConfigurationPackage
public class LoginUI extends UI {

    TextField user;
    PasswordField password;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    private SessionFactory sessionFactory;

    Button loginButton = new Button("Login", this::loginButtonClick);

    @Autowired
    ISecurity iSecurity;

    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();

        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequiredIndicatorVisible(true);

        password = new PasswordField("Password:");
        password.setWidth("300px");
        user.setRequiredIndicatorVisible(true);
        password.setValue("");

        VerticalLayout fields = new VerticalLayout(user, password, loginButton);
        fields.setCaption("Please login to access the application");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        VerticalLayout uiLayout = new VerticalLayout(fields);
        uiLayout.setSizeFull();
        uiLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);

        setFocusedComponent(user);

        setContent(uiLayout);
    }

    public void loginButtonClick(Button.ClickEvent e) {
        if (iSecurity.autoLogin(user.getValue(), password.getValue()).getName().equalsIgnoreCase("ROLE_USER")){
            getPage().setLocation("http://localhost:8081/userpanel");
            getSession().close();
            setPollInterval(10000);
        }
        if (iSecurity.autoLogin(user.getValue(), password.getValue()).getName().equalsIgnoreCase("ROLE_ADMIN")){
            getPage().setLocation("http://localhost:8081/admin");
            getSession().close();
            setPollInterval(10000);
        }

    }



}
