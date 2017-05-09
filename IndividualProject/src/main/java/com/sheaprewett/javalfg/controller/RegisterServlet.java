package com.sheaprewett.javalfg.controller;

import com.sheaprewett.javalfg.persistence.UserDAO;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 4/25/17.
 */
@WebServlet(
        name = "registerServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles GET requests
     * Simply redirect to the jsp page
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles POST requests
     * Process submitted username and password, and attempt to register
     * Send page message if username is already taken
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("first_password");
        // Make sure the parameters aren't null (JS form auth should prevent this)
        if (username != null && password != null) {
            logger.info("Registering Username: " + username + " Password: " + password);
            // Query for username, send error message if user already has it
            UserDAO dao = new UserDAO();
            if (!(dao.getUserByName(username) == null)) {
                // Username is taken
                String pageMessage = "Username already exists, please choose another.";
                logger.info(pageMessage);
                request.setAttribute("PageMessage", pageMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            } else {
                // Query is empty, username not taken. Insert new user.
                String result = dao.registerUser(username, password);
                if (StringUtils.isNumeric(result)) {
                    // If a valid new ID is returned, insert was successful so redirect them to success page
                    response.sendRedirect(request.getContextPath() + "/registrationSuccess");
                } else {
                    // Valid ID number not returned, user insert failed.
                    String pageMessage = "Failed to register user. Please contact an administrator.";
                    logger.info(pageMessage);
                    request.setAttribute("PageMessage", pageMessage);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else {
            // Null username or password; shouldn't happen
            String pageMessage = "Username or password null. Please contact an administrator.";
            logger.info(pageMessage);
            request.setAttribute("PageMessage", pageMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }



    }
}
