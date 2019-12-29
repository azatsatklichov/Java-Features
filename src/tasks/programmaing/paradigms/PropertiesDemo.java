package com.jenkov.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("property1", "value1");
        properties.setProperty("property2", "value2");
        properties.setProperty("property3", "value3");

        try (FileWriter output = new FileWriter("props.properties")) {
            properties.store(output, "These are properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try (FileWriter output = new FileWriter("props.properties",
        // Charset.forName("UTF-8"))) {
        // properties.store(output, "These are properties");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        properties = new Properties();

        try (FileReader fileReader = new FileReader("props.properties")) {
            properties.load(fileReader);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream output = new FileOutputStream("props.xml")) {
            properties.storeToXML(output, "These are properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try(FileOutputStream output = new FileOutputStream("data/props.xml")){
        // properties.storeToXML(output, "These are properties",
        // Charset.forName("ISO-8859-1"));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("props.xml")) {
            properties.loadFromXML(fileInputStream);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("key1", "value1");
        String value1 = System.getProperty("key1");

        System.out.println(value1);

        // The above is equal to:

        Properties systemProperties = System.getProperties();
        systemProperties.forEach((x, y) -> System.out.println("" + x + "=" + y));
        systemProperties.forEach((key, val) -> System.out.println("[" + key + "] " + val));

        systemProperties.setProperty("key1", "value1");
        value1 = systemProperties.getProperty("key1");
        System.out.println(value1);
    }
}
