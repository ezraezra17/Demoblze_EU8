package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- create the object of properties class
    //I want my code to inaccessable outside the classroom
    private static Properties properties= new Properties();
    //I want this static block to be executed first and running one time
    static{

        //Load the properties object using FileInoutStream Object
        try {

            // we need to open the file in java memory:FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file); //I use this exception to call the superclass exception
            file.close();//after loading the file, it will close this inputstream.it will close rather than leaving it to garbage collecter
        } catch (IOException e) {
            System.out.println("something happened in the configuration class");
            e.printStackTrace();
        }
    }
// utility method help us read avode logic

    public static String getProperty(String keyword){    // this will return me the value of the key
        return properties.getProperty(keyword);

    }




}
