package edu.episen.si.ing1.pds.backend.server.release2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Crud {


    public static String[] read(String request, Connection co) {
        Statement st;
        ResultSet rs;
        String[] buildingName = new String[10];
        try {
            String sql = request;
            st = co.createStatement();
            System.out.println(sql);
            rs = st.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                buildingName [i] = rs.getString("building_name");
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buildingName;
    }

    public static StringBuilder requestbuilding(Connection connection, Map <String, String> map) {

        StringBuilder sb = null;
        try {
            String sql = "SELECT building_name FROM building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while(rs.next()) {
                sb.append(rs.getString(1)+"@");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return sb;
    }

}

