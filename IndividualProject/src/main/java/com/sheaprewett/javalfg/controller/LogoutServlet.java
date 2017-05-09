package com.sheaprewett.javalfg.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 4/27/17.
 */

@WebServlet(
        name = "logoutServlet",
        urlPatterns = {"/logout"}
)
public class LogoutServlet extends HttpServlet {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles GET requests
     * Clear session data of logged-in user and redirect back home
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session != null) {
            Object username = session.getAttribute("username");
            if (username != null) {
                session.invalidate();
                logger.info("Logged out user " + username);
            }
        }
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }
}
