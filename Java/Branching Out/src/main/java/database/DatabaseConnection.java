package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "branchingout.cd4448egu1au.us-east-1.rds.amazonaws.com";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "ksJgwqMVHLiFT1RjwMpK";
    
    // Static block to load the MySQL JDBC driver during class initialization
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading MySQL JDBC driver");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {    	
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }
}