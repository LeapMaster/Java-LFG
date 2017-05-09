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


/**
 * Created by student on 3/7/17.
 */

@WebServlet(
        name = "newPostServlet",
        urlPatterns = {"/newPost"}
)
public class NewPost extends HttpServlet {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles POST requests
     * Processes form data, inserts new post if it's valid, and redirects back to home page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Using servlet request, validate form and get LFGPost object if it's valid, bull if not
        LFGPost post = validate(request);


        if (post != null) {
            // Form validated, thus LFGPost object is not null (and vice versa)
            logger.info(post);
            LFGPostDAO dao = new LFGPostDAO();
            // Insert the new LFGPost
            dao.save(post);
        }
        // redirect back home
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }

    /**
     * Using servlet request, make sure form data is valid and return a built LFGPost object if it is
     * @param request the servlet request
     * @return Valid LFGPost with form data to insert, or null if invalid form
     */
    public LFGPost validate(HttpServletRequest request) {
        // Track field validity; to be flaged as false once a single field is invalid
        boolean validForm = true;

        // Check each field to make sure a value was selected

        String platform = request.getParameter("platform");
        if (platform.equals("")) {
            validForm = false;
        }

        String username = request.getParameter("username");
        if (username.equals("")) {
            validForm = false;
        }

        String region = request.getParameter("region");
        if (region.equals("none")) {
            validForm = false;
        }

        String playerClass = request.getParameter("playerClass");
        if (playerClass.equals("")) {
            validForm = false;
        }

        int level = Integer.valueOf(request.getParameter("level"));
        if (level <= 0) {
            validForm = false;
        }

        int gearRating = Integer.valueOf(request.getParameter("gearRating"));
        if (gearRating <= 0) {
            validForm = false;
        }

        String activity = request.getParameter("activity");
        if (activity.equals("")) {
            validForm = false;
        }

        // No validation needed, optional fields
        String experience = request.getParameter("experience");
        String lookingFor = request.getParameter("lookingFor");

        String description = request.getParameter("description");
        if (description.equals("")) {
            validForm = false;
        }

        // No validation required, always checked or unchecked
        String haveMic = request.getParameter("haveMic");


        logger.info("Valid Form: " + validForm);

        LFGPost post = null;
        if (validForm) {
            // If Form is valid, populate object fields from form fields
            post = new LFGPost();
            post.setPlatform(platform);
            post.setUsername(username);
            post.setRegion(region);
            post.setPlayerClass(playerClass);
            post.setLevel(level);
            post.setGearRating(gearRating);
            post.setActivity(activity);
            post.setDescription(description);
            post.setExperience(experience);
            post.setLookingFor(lookingFor);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            post.setTimePosted(sqlDate);
            if (haveMic == null) {
                post.setHaveMic(false);
            } else {
                post.setHaveMic(true);
            }
        }
        // Return post object if validated form, or null if not
        return post;


    }

}
