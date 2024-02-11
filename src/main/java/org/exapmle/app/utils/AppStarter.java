package org.exapmle.app.utils;

import org.exapmle.app.controller.AppController;
import org.exapmle.app.service.AppService;
import org.exapmle.app.view.AppView;

public class AppStarter {
    public static void startApp() {
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
