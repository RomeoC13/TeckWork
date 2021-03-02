package edu.episen.si.ing1.pds.backend.server;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PoolConnect {

    private String url;
    private String user;
    private String password;
    private String driver;

    public PoolConnect() {
        InputStream intStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();

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

    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}

