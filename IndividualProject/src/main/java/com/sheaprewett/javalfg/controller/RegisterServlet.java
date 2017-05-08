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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = Logger.getLogger(this.getClass());


        String username = request.getParameter("username");
        String password = request.getParameter("first_password");
        if (username != null && password != null) {
            logger.info("Username" + username + "Password" + password);
            UserDAO dao = new UserDAO();
            //Make sure the username isn't taken
            logger.info(dao.getUserByName(username));
            if (!(dao.getUserByName(username) == null)) {
                String pageMessage = "Username already exists, please choose another.";
                logger.info(pageMessage);
                request.setAttribute("PageMessage", pageMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            } else {
                String result = dao.registerUser(username, password);
                if (StringUtils.isNumeric(result)) {
                    response.sendRedirect(request.getContextPath() + "/login");
                } else {
                    String pageMessage = "Failed to register user. Please contact an administrator.";
                    logger.info(pageMessage);
                    request.setAttribute("PageMessage", pageMessage);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request, response);
                }
            }


        } else {
            String pageMessage = "Username or password null. Please contact an administrator.";
            logger.info(pageMessage);
            request.setAttribute("PageMessage", pageMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/");


    }
}
