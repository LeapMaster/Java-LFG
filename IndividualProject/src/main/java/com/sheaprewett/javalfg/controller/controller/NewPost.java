package com.sheaprewett.javalfg.controller.controller;

import com.sheaprewett.javalfg.controller.entity.LFGPost;
import com.sheaprewett.javalfg.controller.persistence.LFGPostDAO;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> errorFields = new ArrayList<String>();
        boolean validForm = true;

        final Logger logger = Logger.getLogger(this.getClass());
        logger.log(Priority.INFO, "NEWPOST");

        String platform = request.getParameter("platform");
        if (platform.equals("none")) {
            validForm = false;
            errorFields.add("platform");
        }

        String username = request.getParameter("username");
        if (username.equals("")) {
            validForm = false;
            errorFields.add("username");
        }

        String region = request.getParameter("region");
        if (region.equals("none")) {
            validForm = false;
            errorFields.add("region");
        }

        String playerClass = request.getParameter("playerClass");
        if (playerClass.equals("none")) {
            validForm = false;
            errorFields.add("playerClass");
        }

        int level = Integer.valueOf(request.getParameter("level"));
        if (level <= 0) {
            validForm = false;
            errorFields.add("level");
        }

        int gearRating = Integer.valueOf(request.getParameter("gearRating"));
        if (gearRating <= 0) {
            validForm = false;
            errorFields.add("gearRating");
        }

        String activity = request.getParameter("activity");
        if (activity.equals("none")) {
            validForm = false;
            errorFields.add("activity");
        }

        String experience = request.getParameter("experience");
        // No validation needed, optional field

        String lookingFor = request.getParameter("lookingFor");

        String description = request.getParameter("description");
        if (description.equals("")) {
            validForm = false;
            errorFields.add("description");
        }

        String haveMic = request.getParameter("haveMic");
        // No validation required, always checked or unchecked

        logger.log(Priority.INFO, "Valid Form: " + validForm);
        logger.log(Priority.INFO, "Errors: " + errorFields);

        if (validForm) {
            LFGPost post = new LFGPost();
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

            logger.log(Priority.INFO, post);
            LFGPostDAO dao = new LFGPostDAO();
            dao.save(post);

        } else {

        }


        if (validForm) {
            //Set page parameter for success message


            RequestDispatcher dispatcher = request.getRequestDispatcher("/testQuery");
            dispatcher.forward(request, response);

        } else {
            //Set page parameters to highlight incomplete fields
            request.setAttribute("error", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }


    }

}
