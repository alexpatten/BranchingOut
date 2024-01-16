import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DatabaseConnection;
import models.User;

public class test {
	public static void main(String[] args) {
		String username = "apatten";
        String password = "password";
        String email = "hello@alexpatten.me";
        
        boolean userExists = User.verifyUsername(username);
        boolean emailExists = User.verifyUsername(email);
        boolean registrationSuccess = false;
        
		if(userExists == true && emailExists == true) {
			registrationSuccess = registerUser(username, password, email);
		}

        if (registrationSuccess) {
            System.out.println("Registration successful!");
        } else {
        	if (userExists == true) {
        		System.out.println("Registration failed: Username already exists.");
        	}
            if (emailExists == true) {
            	System.out.println("Registration failed: Email already exists.");
            }
        }
	}

    private static boolean registerUser(String username, String password, String email) {
        boolean success = false;
        String insertSql = "INSERT INTO User (Username, Password, Email) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSql)) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
