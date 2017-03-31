package com.sheaprewett.javalfg.controller;

import com.sheaprewett.javalfg.persistence.LFGPostDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/testQuery"}
)

public class TestQuery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = Logger.getLogger(this.getClass());
        logger.log(Priority.INFO, "TESTQUERYGET");
        LFGPostDAO lfgDAO = new LFGPostDAO();
        request.setAttribute("allPosts", lfgDAO.getAllLFGPosts());


        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }



}