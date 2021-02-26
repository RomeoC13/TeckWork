package edu.episen.si.ing1.pds.backend.server;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PoolConnect {

    public static void main(String[] args) {
        InputStream intStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        String url = null;
        String user = null;
        String password = null;
        String driver = null;
        try {
            prop.load(intStream);

            System.out.println(prop.getProperty("url"));
            System.out.println(prop.getProperty("user"));
            System.out.println(prop.getProperty("password"));
            System.out.println(prop.getProperty("driver"));

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

        }
        catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (intStream != null) {
                try{intStream.close();}
                catch(IOException e){e.printStackTrace();}
            }
        }
        try {Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection");
            }

    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




        }

