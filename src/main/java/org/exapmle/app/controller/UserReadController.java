package org.exapmle.app.controller;

import org.exapmle.app.service.UserReadService;
import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.view.UserReadView;

public class UserReadController {
    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUsers() {
        view.getOutput(service.readContacts());
        AppStarter.startApp();
    }
}
