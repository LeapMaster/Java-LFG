package com.sheaprewett.javalfg.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by student on 4/27/17.
 */
@WebServlet(
        name = "profileServlet",
        urlPatterns = {"/profile"}
)
public class ProfileServlet extends HttpServlet {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Handles GET requests
     * Checks if user is logged in, and sends page user data if they are
     * Also sets page message on failed character linking
     * @param request the servlet request
     * @param response the servlet response
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if user is logged in
        if (session != null && session.getAttribute("userID") != null) {

            // Using DAO, set page attributes from user ID set in session
            int userID = (Integer) session.getAttribute("userID");
            UserDAO dao = new UserDAO();
            User user = dao.getUserByID(userID);
            request.setAttribute("loggedIn", "true");
            request.setAttribute("currentUser", user);
            request.setAttribute("PageMessage", "");

            // Set attribute for error message if user tried to link an invalid WoW profile
            Object messageObject = session.getAttribute("profilePageMessage");
            if (messageObject != null) {
                request.setAttribute("PageErrorMessage", messageObject);
                session.setAttribute("profilePageMessage", null);
            }

        } else {
            // User tried to view this page before logged in; shouldn't be accessible through normal page flow
            logger.info("Not logged in for profile!");
            request.setAttribute("loggedIn", "false");
            request.setAttribute("PageMessage", "You must log in to use this page.");
        }
        // Forward to profile page with set attributes
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Processes request to link character, then redirects to GET request
     * @param request the servlet request
     * @param response the servlet response
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     * Handles POST requests
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //User submitted a request to link a user; pull in the form data
        String username = request.getParameter("username");
        String wowUsername = request.getParameter("wowUsername");
        String wowRealm = request.getParameter("wowRealm");

        logger.info("Site User " + username + " is trying to link WoW User " + wowUsername + " from WoW Realm " + wowRealm);

        JsonObject json = getProfileInfo(wowUsername, wowRealm);
        if (json != null) {
            logger.info(json.get("name"));
            logger.info(json.get("level"));
            logger.info(json.getAsJsonObject("items").get("averageItemLevel"));
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            User user = dao.getUserByName((String) session.getAttribute("username"));
            user.setWowUser(wowUsername);
            user.setWowRealm(wowRealm);
            user.setPlayerClass(getClassString(json.get("class").getAsInt()));
            user.setCharacterLevel(json.get("level").getAsInt());
            user.setItemLevel(json.getAsJsonObject("items").get("averageItemLevel").getAsInt());
            dao.editUser(user);
            response.sendRedirect(request.getContextPath() + "/profile");

        } else {
            String errorMessage = "User not found on region.";
            logger.info(errorMessage);
            HttpSession session = request.getSession(false);
            session.setAttribute("profilePageMessage", errorMessage);
            response.sendRedirect(request.getContextPath() + "/profile");
        }

    }

    /**
     * Use form parameters to query Blizzard API for valid character data
     * @param username the form character username parameter
     * @param realm the form character realm parameter
     * @return a Gson Json Object of character data, or null if one isn't found
     */
    public JsonObject getProfileInfo(String username, String realm) {
        logger.info("test");
        String apiKey = "6951b9e994824aa0b7c7d828bd435bee";

        // Endpoint for character data API; add realm and username fields to URL as parameters
        String url = "https://us.api.battle.net/wow/character/" + realm + "/" + username + "?fields=items&locale=en_US&apikey=fx4memxf63y6jvddy89aht9psncrderp";

        URL obj;
        HttpURLConnection con;
        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //Send the request
            int responseCode = con.getResponseCode();
            logger.info("\nSending 'GET' request to Blizzard API : " + url);
            logger.info("Response Code : " + responseCode);
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


            logger.info("Character " + json.get("name") + " was retrieved.");
            return json;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // If an exception occurred, return null
        return null;

    }

    /**
     * Convert integer returned by API into a String of the player class's name
     * @param classNumber the integer from the API representing player class
     * @return String of the character class's name
     */
    public String getClassString (int classNumber) {
        // Create map matching integers with the name of the class they represent
        HashMap<Integer, String> characterClassMap = new HashMap<Integer, String>();
        characterClassMap.put(1, "Warrior");
        characterClassMap.put(2, "Paladin");
        characterClassMap.put(3, "Hunter");
        characterClassMap.put(4, "Rogue");
        characterClassMap.put(5, "Priest");
        characterClassMap.put(6, "Death Knight");
        characterClassMap.put(7, "Shaman");
        characterClassMap.put(8, "Mage");
        characterClassMap.put(9, "Warlock");
        characterClassMap.put(10, "Monk");
        characterClassMap.put(11, "Druid");
        characterClassMap.put(12, "Demon Hunter");
        // Return the name of the class matching the integer
        return characterClassMap.get(classNumber);
    }
}
