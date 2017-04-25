package com.sheaprewett.javalfg.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by student on 4/25/17.
 */
public class APITests {

    public static void main (String[] args) {
        System.out.println("test");
        String apiKey = "6951b9e994824aa0b7c7d828bd435bee";

        // Endpoint for Gjallarhorn
        String url = " http://www.bungie.net/Platform/Destiny/254/Account/58396/Summary/";
        //String url = "https://www.bungie.net/Platform/Destiny/Manifest/InventoryItem/1274330687/";

        URL obj;
        HttpURLConnection con;
        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            // Set header
            con.setRequestProperty("X-API-KEY", apiKey);
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to Bungie.Net : " + url);
            System.out.println("Response Code : " + responseCode);
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

            System.out.println();
            System.out.println(json.getAsJsonObject("Response").getAsJsonObject("data").getAsJsonObject("inventoryItem").get("itemName"));
            //Gjallarhorn
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }










    }
}
