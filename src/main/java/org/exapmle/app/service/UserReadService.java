package org.exapmle.app.service;

import org.exapmle.app.entity.User;
import org.exapmle.app.repository.UserReadRepository;
import org.exapmle.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {
    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readContacts() {

        // Отримуємо дані у колекцію.
        List<User> list = repository.readContacts();

        // Якщо колекція не null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (list != null) {
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(contact.getId())
                                .append(", ")
                                .append(contact.getName())
                                .append(", ")
                                .append(contact.getEmail())
                                .append("\n")
                );
                return "\n______ CONTACTS ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
