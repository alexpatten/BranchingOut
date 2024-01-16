package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@SuppressWarnings("serial")
@WebServlet("/main")
public class MainController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        // Check if the user is logged in (session exists)
        if (session != null && session.getAttribute("username") != null) {
            // User is logged in, allow access to main.html
            // Your main.html processing logic goes here
            response.getWriter().println("Welcome to main.html");
        } else {
            // User is not logged in, redirect to the login page
            response.sendRedirect("index.html");
        }
    }
}
