package com.sheaprewett.javalfg.controller;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by student on 5/9/17.
 */
public class PropertiesFileLoader {

    // Instantiate logger for use throughout the class
    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Class that returns a loaded properties file
     * @return the properties file, null if not loaded
     */
    public Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/properties.properties"));
            logger.debug("Properties file successfully loaded.");
        } catch(IOException ioException) {
            ioException.printStackTrace();
            // Make sure properties is null so code that calls it knows something went wrong
            properties = null;
        } catch(Exception exception) {
            exception.printStackTrace();
            // Make sure properties is null so code that calls it knows something went wrong
            properties = null;
        }
        return properties;
    }
}
