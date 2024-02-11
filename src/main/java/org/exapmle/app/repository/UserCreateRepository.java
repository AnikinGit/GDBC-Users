package org.exapmle.app.repository;

import org.exapmle.app.database.DBConn;
import org.exapmle.app.entity.User;
import org.exapmle.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCreateRepository {
    public String createContact(User user) {

        String sql = "INSERT INTO " + Constants.TABLE_CONTACTS +
                " (name, email) VALUES(?, ?)";
        // PreparedStatement - підготовлений вираз, щоб уникнути SQL-ін'єкцій
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
