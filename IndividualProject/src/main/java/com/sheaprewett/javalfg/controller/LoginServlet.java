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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = Logger.getLogger(this.getClass());

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.getUserByName(username);
        boolean successfulLogin = false;
        boolean foundUsername = false;
        int userID = -1;
        if (!user.equals(null)) {
            foundUsername = true;
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                successfulLogin = true;
                userID = user.getUserID();
            }

        }
        String loginMessage = "";
        if (foundUsername) {
            if (successfulLogin) {
                loginMessage = "User of ID " + userID + " Logged in.";
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userID", userID);
            } else {
                loginMessage = "Login failed";

            }
        } else {
            loginMessage = "Username not found.";
        }
        logger.info(loginMessage);

        if (successfulLogin) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else {
            request.setAttribute("PageMessage", loginMessage);
            request.setAttribute("userID", userID);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }


    }


}