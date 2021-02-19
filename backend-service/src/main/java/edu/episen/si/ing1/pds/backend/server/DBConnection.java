package edu.episen.si.ing1.pds.backend.server;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
    public static void main(String[] args) throws Exception{
        Connection conn = null;

        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("backend-service/properties")) {
            props.load(fis);
        }

        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String pwd = props.getProperty("jdbc.password");

        try {
            conn = DriverManager.getConnection(url, login, pwd);
            if(conn != null) {
               System.out.println("CONNECTION OK");
            } else {
                System.out.println("CONNECTION FAILED");
            }

            Statement statement = conn != null ? conn.createStatement() : null;


            ResultSet rs = statement.executeQuery("SELECT * FROM USERS");

            while(rs.next()) {
                System.out.println(rs.getInt("USR_ID") + " " + rs.getString(2)  + " " + rs.getString("USR_PASSWORD"));
            }
        } catch (Exception e) {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }




    }
}
