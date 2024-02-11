package org.exapmle.app.controller;

import org.exapmle.app.service.UserCreateService;
import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.view.UserCreateView;

public class UserCreateController {
    UserCreateView view;
    UserCreateService service;

    public UserCreateController(UserCreateService service, UserCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createUser() {
        view.getOutput(service.createContact(view.getData()));
        AppStarter.startApp();
    }
}
