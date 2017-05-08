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

/**
 * Created by student on 4/27/17.
 */
@WebServlet(
        name = "profileServlet",
        urlPatterns = {"/profile"}
)
public class ProfileServlet extends HttpServlet {

    final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        logger.info("GET GET GET GET GET ");
        if (session != null && session.getAttribute("userID") != null) {
                int userID = (Integer) session.getAttribute("userID");
                UserDAO dao = new UserDAO();
                user = dao.getUserByID(userID);
                request.setAttribute("loggedIn", "true");
                request.setAttribute("userID", user.getUserID());
                logger.info("Profile page!");
                logger.info(user.getUserID());
                logger.info(user.getUsername());
                logger.info(user.getPassword());
                request.setAttribute("username", user.getUsername());
                request.setAttribute("PageMessage", "");


        } else {
            logger.info("Not logged in for profile!");
            request.setAttribute("loggedIn", "false");
            request.setAttribute("PageMessage", "You must log in to use this page.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("POST POST POST POST POST ");
        String username = request.getParameter("username");
        String wowUsername = request.getParameter("wowUsername");
        String wowRealm = request.getParameter("wowRealm");
        logger.info("user: " + username + " wow user: " + wowUsername + " wowRealm: " + wowRealm);
        JsonObject json = getProfileInfo(wowUsername, wowRealm);
        if (json != null) {
            logger.info(json.get("name"));
            logger.info(json.get("level"));
            logger.info(json.getAsJsonObject("items").get("averageItemLevel"));

        } else {
            logger.info("User not found on region.");
        }

    }

    public JsonObject getProfileInfo(String username, String realm) {
        logger.info("test");
        String apiKey = "6951b9e994824aa0b7c7d828bd435bee";

        // Endpoint for Gjallarhorn
//        String realm = "Kil'Jaeden";
//        String username="Salsten";
        String url = "https://us.api.battle.net/wow/character/" + realm + "/" + username + "?fields=items&locale=en_US&apikey=fx4memxf63y6jvddy89aht9psncrderp";
        //String url = "https://www.bungie.net/Platform/Destiny/Manifest/InventoryItem/1274330687/";

        URL obj;
        HttpURLConnection con;
        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            // Set header
//            con.setRequestProperty("X-API-KEY", apiKey);
            int responseCode = con.getResponseCode();
            logger.info("\nSending 'GET' request to Blizzard API : " + url);
            logger.info("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            String response = "";
            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }

            in.close();

            // Uses Gson - https://github.com/google/gson
            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(response);

            System.out.println(json);
            System.out.println(json.get("name"));
            System.out.println(json.get("level"));
            System.out.println(json.getAsJsonObject("items").get("averageItemLevel"));
            return json;
            //Gjallarhorn
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
