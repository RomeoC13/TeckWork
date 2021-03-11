package edu.episen.si.ing1.pds.backend.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class RetrieveProperties {

    String url;
    String login;
    String password;
    String driver;

    public RetrieveProperties() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("backend-service/conf.properties")) {
            props.load(fis);

            url = props.getProperty("jdbc.url");
            login = props.getProperty("jdbc.login");
            password = props.getProperty("jdbc.password");
            driver = props.getProperty("jdbc.driver");
        } catch( IOException e ) {
            e.printStackTrace();
        }

    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}
