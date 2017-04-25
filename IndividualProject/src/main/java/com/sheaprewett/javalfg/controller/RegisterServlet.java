package com.sheaprewett.javalfg.controller;

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = Logger.getLogger(this.getClass());


        String username = request.getParameter("username");
        String password = request.getParameter("first_password");
        if (username != null && password != null) {
            logger.log(Priority.INFO, "Username" + username + "Password" + password);
        } else {
            logger.log(Priority.INFO, "Username or password null");
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        response.sendRedirect(request.getContextPath() + "/home");

    }
}
