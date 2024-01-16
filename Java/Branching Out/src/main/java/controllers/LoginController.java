package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

@SuppressWarnings("serial")
@WebServlet("/MyLogin")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");
    	
    	int userId = User.getUserIdByUsernameAndPassword(inputUsername, inputPassword);

        if (userId != -1) {
            // User found, userId contains the user's ID
            response.getWriter().println("User found. UserID: " + userId);
        } else {
            response.getWriter().println("User not found.");
        }
    }
}