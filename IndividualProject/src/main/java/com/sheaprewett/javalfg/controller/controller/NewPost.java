package com.sheaprewett.javalfg.controller.controller;

import com.sheaprewett.javalfg.controller.persistence.LFGPostDAO;
import org.apache.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * Created by student on 3/7/17.
 */

@WebServlet(
        urlPatterns = {"/newPost"}
)
public class NewPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/results.jsp"));
    }

}
