package com.sheaprewett.javalfg.controller;

import com.sheaprewett.javalfg.entity.User;
import com.sheaprewett.javalfg.persistence.UserDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by student on 4/27/17.
 */
@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet{

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles GET requests
     * Check if user is already logged in
     * Redirect to home page if they are, forward to login page if they aren't
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session != null && session.getAttribute("userID") != null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles POST requests
     * Process username and password from login form, make sure they're valid, set session keys if they are
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = Logger.getLogger(this.getClass());

        // Get form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        // Search for username
        User user = dao.getUserByName(username);

        // Boolean flags to track degree of success in login
        boolean successfulLogin = false;
        boolean foundUsername = false;

        // Initialize with invalid userID
        int userID = -1;

        if (user != null) {
            // Valid user object was returned
            foundUsername = true;
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Username and password match from field values
                successfulLogin = true;
                userID = user.getUserID();
            }
        }
        String loginMessage = "";
        if (foundUsername) {
            if (successfulLogin) {
                loginMessage = "User of ID " + userID + " Logged in.";
                // Store ID and username in session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userID", userID);
            } else {
                loginMessage = "Login failed";
            }
        } else {
            loginMessage = "Username not found.";
        }
        // Log the result before continuing
        logger.info(loginMessage);

        if (successfulLogin) {
            // Login successful, redirect to home page
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else {
            // Login failed, forward back to page with error message detailing problem
            request.setAttribute("PageMessage", loginMessage);
            request.setAttribute("userID", userID);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }


}