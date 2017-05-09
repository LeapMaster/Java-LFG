package com.sheaprewett.javalfg.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 5/9/17.
 */
@WebServlet(
        name = "successServlet",
        urlPatterns = {"/registrationSuccess"}
)
public class RegistrationSuccess extends HttpServlet {
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/registerSuccessful.jsp");
        dispatcher.forward(request, response);
    }
}
