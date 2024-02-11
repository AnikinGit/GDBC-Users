package org.exapmle.app.repository;

import org.exapmle.app.database.DBConn;
import org.exapmle.app.entity.User;
import org.exapmle.app.utils.Constants;
import org.exapmle.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteRepository {
    public String deleteContact(User user) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(user.getId())) {
            return deleteUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String deleteUserById(User user) {

        String sql = "DELETE FROM " + Constants.TABLE_CONTACTS + " WHERE id = ?";

        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            return Constants.DATA_DELETE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
