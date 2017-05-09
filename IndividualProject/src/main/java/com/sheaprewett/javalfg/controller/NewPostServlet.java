package com.sheaprewett.javalfg.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sheaprewett.javalfg.entity.LFGPost;
import com.sheaprewett.javalfg.persistence.LFGPostDAO;
import net.tanesha.recaptcha.ReCaptchaImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by student on 3/7/17.
 */

@WebServlet(
        name = "newPostServlet",
        urlPatterns = {"/newPost"}
)
public class NewPostServlet extends HttpServlet {

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
        LFGPost post = validateForm(request);

        if (post != null && validateCaptcha(request)) {
            // Form validated, thus LFGPost object is not null (and vice versa)
            logger.debug(post);
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
    public LFGPost validateForm(HttpServletRequest request) {
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

    public Boolean validateCaptcha(HttpServletRequest request) {
        String captchaResponse = request.getParameter("g-recaptcha-response");
        String secret = "6Ld8nSAUAAAAABb6yyvTTI8qfULDkIw2Z521dGhs";
        String IP = request.getRemoteAddr();
        // Endpoint for captcha API, with parameters in URL
        String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + secret + "&response=" + captchaResponse + "&remoteip=" + IP;

        URL obj;
        HttpURLConnection con;
        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //Send the request
            int responseCode = con.getResponseCode();
            logger.debug("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            String response = "";
            // Build a string from the response data
            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
            in.close();

            // Uses Gson - https://github.com/google/gson
            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(response);
            // Get whether the captcha validated or not
            Boolean success = json.get("success").getAsBoolean();
            System.out.println("Recaptcha: " + success);
            return success;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // If it reaches this point, something went wrong and it needs to return false
        return false;
    }

}
