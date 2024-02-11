package org.exapmle.app.service;

import org.exapmle.app.entity.User;
import org.exapmle.app.exceptions.CreateException;
import org.exapmle.app.repository.UserCreateRepository;
import org.exapmle.app.utils.Constants;
import org.exapmle.app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateService {
    UserCreateRepository repository;

    public UserCreateService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createContact(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);



        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setName(data[0]);
        user.setEmail(data[1]);
        return user;
    }
}
