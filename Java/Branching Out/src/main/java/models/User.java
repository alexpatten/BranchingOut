package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;

public class User {

    private int userID;
    private String username;
    private String password;
    private String email;

    // Constructors, getters, setters, and other methods...

    public static User getUserById(int userID) {
        User user = null;
        String sql = "SELECT * FROM User WHERE UserID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserID(resultSet.getInt("UserID"));
                    user.setUsername(resultSet.getString("Username"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setEmail(resultSet.getString("Email"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public static int getUserIdByUsernameAndPassword(String username, String password) {
        int userId = -1; // Default value if user is not found
        String sql = "SELECT UserID FROM User WHERE Username = ? AND Password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userId = resultSet.getInt("UserID");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
