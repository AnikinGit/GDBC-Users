package org.exapmle.app.controller;

import org.exapmle.app.service.UserUpdateService;
import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.view.UserUpdateView;

public class UserUpdateController {
    UserUpdateService service;
    UserUpdateView view;

    public UserUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUser() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }
}
