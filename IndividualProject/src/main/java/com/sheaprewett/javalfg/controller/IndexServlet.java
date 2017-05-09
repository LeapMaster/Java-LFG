package com.sheaprewett.javalfg.controller;

import com.sheaprewett.javalfg.entity.LFGPost;
import com.sheaprewett.javalfg.entity.User;
import com.sheaprewett.javalfg.persistence.LFGPostDAO;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 3/30/17.
 */
@WebServlet(
        urlPatterns = {"/home"}
)
public class IndexServlet extends HttpServlet {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles GET requests
     * Run initial, parameter-less search and forward to home page with results and logged-in User data
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create list of all LFGPosts
        List<LFGPost> lfgPosts = runInitialSearch();
        request.setAttribute("allPosts", lfgPosts);

        // Check for logged-in user; send user data to page if one is set
        String currentUsername = getLoggedUsername(request);
        if (currentUsername.length() > 0) {
            request.setAttribute("UserMessage", "Welcome back " + currentUsername);
            request.setAttribute("currentUser", getUserData(currentUsername));
        }
        // Forward to home page with search results and User data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles POST requests
     * Process filtered search from home page
     * @param request the servlet request
     * @param response the servlet request
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LFGPost> lfgPosts = runFilteredSearch(request);
        request.setAttribute("allPosts", lfgPosts);
        request.setAttribute("UserMessage", "Welcome back " + getLoggedUsername(request));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request, response);
    }

    /**
     * Get all LFG Posts
     * @return a list of all LFG Posts
     */
    public List<LFGPost> runInitialSearch() {
        LFGPostDAO lfgDAO = new LFGPostDAO();
        // Use filtered search
        List<LFGPost> lfgPosts = lfgDAO.getAllLFGPosts();

        return lfgPosts;
    }

    /**
     * Get LFG Posts that fit search parameters
     * @param request
     * @return a list of matching LFG Posts
     */
    public List<LFGPost> runFilteredSearch(HttpServletRequest request) {

        // Instantiate map to hold search parameters matched with field name
        HashMap<String, String> parameters = new HashMap<String, String>();

        final Logger logger = Logger.getLogger(this.getClass());
        logger.info("Running filtered search");

        // Using the sent HttpServletRequest, get the value for each form input
        // If a non-default value is set, add the field name and value to the map to be searched on

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
            parameters.put("haveMic", "true");
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
        // Return the list of found posts
        return lfgPosts;
    }

    /**
     * Check session for logged-in user, and return their username if they exist
     * @param request servlet request with session tied to it
     * @return String containing username, or blank space if one isn't found
     */
    public String getLoggedUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String username = "";
        if (session != null) {
            if (session.getAttribute("username") != null) {
                username = (String) session.getAttribute("username");
                logger.info("WE GOT AN ATTRIBUTE! " + username);
            } else {
                logger.info("NULL ATTRIBUTE");
            }
        } else {
            logger.info("NULL SESSION");
        }
        return username;
    }

    /**
     * Take username and return their data
     * @param username the username to be queried for
     * @return User object matching username
     */
    public User getUserData(String username) {
        UserDAO dao = new UserDAO();
        User user = dao.getUserByName(username);
        return user;

    }


}