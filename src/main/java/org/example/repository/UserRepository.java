package org.example.repository;

import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    // ska fixas full crud för user för VG
    public boolean saveUser(String username, String password, String role) {
        String sql = "Insert INTO users(username,password,role)VALUES (?,?,?)";


        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);


            int rows = statement.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}