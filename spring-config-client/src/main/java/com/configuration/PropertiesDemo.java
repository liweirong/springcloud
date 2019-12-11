package com.configuration;

import java.io.IOException;
import java.util.Properties;

// Spring Boot application.properties
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("name", "iris");
        properties.setProperty("age", "18");

        properties.storeToXML(System.out, "This is a comment", "UTF-8");

    }
}
