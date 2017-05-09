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

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles POST requests
     *
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Instantiate map to hold search parameters matched with field name
        HashMap<String, String> parameters = new HashMap<String, String>();

        final Logger logger = Logger.getLogger(this.getClass());
        logger.info("Running filtered search");

        String platform = request.getParameter("platform");
        if (platform.equals("any")) {
            // No search parameters
        } else {
            // Add parameter and value to map
            parameters.put("platform", platform);
        }

        String region = request.getParameter("region");
        if (region.equals("any")) {
            // No search parameters
        } else {
            // Add parameter and value to map
            parameters.put("region", region);
        }


        String activity = request.getParameter("activity");
        if (activity.equals("any")) {
            // No search parameters
        } else {
            // Add parameter and value to map
            parameters.put("activity", activity);
        }


        String experience = request.getParameter("experience");
        if (experience.equals("any")) {
            // No search parameters
        } else {
            // Add parameter and value to map
            parameters.put("experience", experience);
        }

        String levelString = request.getParameter("level");
        if (!levelString.equals("")) {
            // Add parameter and value to map, making sure it's a valid integer
            int level = Integer.valueOf(levelString);
            if (level > 0) {
                parameters.put("level", String.valueOf(level));
            }
        } else {
            // No search parameters
        }

        String gearRatingString = request.getParameter("gearRating");
        if (!gearRatingString.equals("")) {
            // Add parameter and value to map, making sure it's a valid integer
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
            // Add parameter and value to map
            parameters.put("requireMic", "true");
        }



        String lookingFor = request.getParameter("lookingFor");
        if (lookingFor.equals("all")) {
            // No search parameter
        } else {
            // Add parameter and value to map
            parameters.put("lookingFor", lookingFor);
        }

        logger.info(parameters);
        LFGPostDAO lfgDAO = new LFGPostDAO();
        // Run the filtered search
        List<LFGPost> lfgPosts = lfgDAO.filteredSearch(parameters);
        // Set list of found posts as page attribute
        request.setAttribute("allPosts", lfgPosts);
        // Forward to page with search results
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);

    }


}
