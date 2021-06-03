package edu.episen.si.ing1.pds.backend.server.release2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {


    public static String[] read(String request, Connection co) {
        Statement st;
        ResultSet rs;
        String[] equipmentSensor = new String[10];
        try {
            String sql = request;
            st = co.createStatement();
            System.out.println(sql);
            rs = st.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                equipmentSensor[i] = rs.getString("building_name");
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return equipmentSensor;
    }

}