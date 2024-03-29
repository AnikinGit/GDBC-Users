package org.exapmle.app.repository;

import org.exapmle.app.database.DBConn;
import org.exapmle.app.entity.User;
import org.exapmle.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserReadRepository {
    List<User> list;

    public List<User> readContacts() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name, email FROM " + Constants.TABLE_CONTACTS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email")
                        )
                );
            }
            // Повертаємо колекцію даних
            return list;
        } catch (SQLException e) {
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}
