package org.exapmle.app.controller;

import org.exapmle.app.service.UserDeleteService;
import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.view.UserDeleteView;

public class UserDeleteController {
    UserDeleteService service;
    UserDeleteView view;

    public UserDeleteController(UserDeleteService service, UserDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteUser() {
        view.getOutput(service.deleteContact(view.getData()));
        AppStarter.startApp();
    }
}
