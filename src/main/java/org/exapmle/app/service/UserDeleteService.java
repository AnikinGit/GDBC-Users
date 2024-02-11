package org.exapmle.app.service;

import org.exapmle.app.entity.User;
import org.exapmle.app.exceptions.UpdateException;
import org.exapmle.app.repository.UserDeleteRepository;
import org.exapmle.app.utils.Constants;
import org.exapmle.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteService {
    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteContact(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
