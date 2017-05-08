package com.sheaprewett.javalfg.controller;

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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session != null) {
            if (session.getAttribute("username") != null) {
                session.invalidate();
            }
        }
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }
}
