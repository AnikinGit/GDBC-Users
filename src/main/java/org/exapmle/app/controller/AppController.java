package org.exapmle.app.controller;

import org.exapmle.app.service.AppService;
import org.exapmle.app.utils.Constants;
import org.exapmle.app.view.AppView;

public class AppController {
    AppView view;
    AppService service;

    public AppController(AppView view, AppService service) {
        this.view = view;
        this.service = service;
    }

    public void runApp() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.createUser();
            case 2 -> service.readUsers();
            case 3 -> service.updateUser();
            case 4 -> service.deleteUser();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }
}
