package org.exapmle.app.service;

import org.exapmle.app.controller.UserCreateController;
import org.exapmle.app.controller.UserDeleteController;
import org.exapmle.app.controller.UserReadController;
import org.exapmle.app.controller.UserUpdateController;
import org.exapmle.app.exceptions.OptionException;
import org.exapmle.app.repository.UserCreateRepository;
import org.exapmle.app.repository.UserDeleteRepository;
import org.exapmle.app.repository.UserReadRepository;
import org.exapmle.app.repository.UserUpdateRepository;
import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.utils.Constants;
import org.exapmle.app.view.UserCreateView;
import org.exapmle.app.view.UserDeleteView;
import org.exapmle.app.view.UserReadView;
import org.exapmle.app.view.UserUpdateView;

public class AppService {
    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createUser();
    }

    public void readUsers() {
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readUsers();
    }

    public void updateUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service, view);
        controller.updateUser();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Перевірка наявності опції
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
