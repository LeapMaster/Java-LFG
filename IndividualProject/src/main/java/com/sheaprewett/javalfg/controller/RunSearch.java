package com.sheaprewett.javalfg.controller;

import com.sheaprewett.javalfg.entity.LFGPost;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Created by student on 3/20/17.
 */

@WebServlet(
        name = "runPostServlet",
        urlPatterns = {"/runSearch"}
)
public class RunSearch extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, String> parameters = new HashMap<String, String>();


        final Logger logger = Logger.getLogger(this.getClass());
        logger.info("RUN SEARCH");

        String platform = request.getParameter("platform");

        if (platform.equals("any")) {
            // No search parameters
        } else {
            parameters.put("platform", platform);
        }

        String region = request.getParameter("region");
        if (region.equals("any")) {
            // No search parameters
        } else {
            parameters.put("region", region);
        }


        String activity = request.getParameter("activity");
        if (activity.equals("any")) {
            // No search parameters
        } else {
            parameters.put("activity", activity);
        }


        String experience = request.getParameter("experience");
        if (experience.equals("any")) {
            // No search parameters
        } else {
            parameters.put("experience", experience);
        }

        String levelString = request.getParameter("level");
        if (!levelString.equals("")) {
            int level = Integer.valueOf(levelString);
            if (level > 0) {
                parameters.put("level", String.valueOf(level));
            }
        } else {
            // No search parameters
        }

        String gearRatingString = request.getParameter("gearRating");
        if (!gearRatingString.equals("")) {
            int gearRating = Integer.valueOf(gearRatingString);
            if (gearRating > 0) {
                parameters.put("gearRating", String.valueOf(gearRating));
            }
        } else {
            // No search parameters
        }


        String requireMic = request.getParameter("requireMic");
        if (requireMic == null) {
            // No search parameter

        } else {
            parameters.put("requireMic", "true");
        }



        String lookingFor = request.getParameter("lookingFor");
        if (lookingFor.equals("all")) {
            // No search parameter
        } else {
            parameters.put("lookingFor", lookingFor);
        }

//        String playerClass = request.getParameter("playerClass");
//        if (playerClass.equals("none")) {s
//            validForm = false;
//            errorFields.add("playerClass");
//        }

        logger.info(parameters);
        LFGPostDAO lfgDAO = new LFGPostDAO();
        List<LFGPost> lfgPosts = lfgDAO.filteredSearch(parameters);
        request.setAttribute("allPosts", lfgPosts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);

    }


}
