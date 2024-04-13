package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.EventResponse;
import models.User;
import database.DatabaseConnection;

@WebServlet("/EventUpdate")
public class EventsController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Get the session from the request
	    HttpSession session = request.getSession(false); // Don't create a new session if it doesn't exist

	    if (session != null) {
	        int userIdFromSession = User.getUserIdFromSession(session);

	        // Get the event data from the request parameters
	        String eventName = request.getParameter("evTitle");
	        String eventDate = request.getParameter("evDate");
	        String eventTime = request.getParameter("evTime");
	        /*
	        String eventLocation = request.getParameter("address");
	        String eventDescription = request.getParameter("description");
	        */

	        // Insert the event data into the database
	        boolean success = insertEvent(eventName, eventDate, eventTime, userIdFromSession);

	        // Create response string
	        String responseString;
	        if (success) {
	            responseString = "Event submitted successfully!";
	        } else {
	            responseString = "Failed to submit event.";
	        }

	        // Set response content type and write response string
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseString);
	    } else {
	        // Handle session not found
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("Session not found.");
	    }
	}

    private boolean insertEvent(String eventName, String eventDate, String eventTime,
            int userIdFromSession) {
        String sql = "INSERT INTO Event (EventName, Date, Time, UserID) " + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, eventName);
            statement.setString(2, eventDate);
            statement.setString(3, eventTime);
            statement.setInt(4, userIdFromSession); // Set UserID as the fourth parameter

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}