package com.convenient.store.gl.springbootsecurityvaadin.ui;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

/**
 * Created by Rith on 7/14/2017.
 */
@SpringUI(path = "/user")
@Title("UserPage")
public class UserLogPanel extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridLayout gridLayout = new GridLayout(2, 7);
        gridLayout.setSpacing(true);
        gridLayout.addComponent(new Label("Hello I am User"));
        VerticalLayout uiLayout = new VerticalLayout(gridLayout);
        uiLayout.setSizeFull();
        uiLayout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);

        setContent(uiLayout);
    }
}
