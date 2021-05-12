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
                equipmentSensor[i] = rs.getString("name");
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return equipmentSensor;
    }

    public static String[] read1(String request1, Connection co) {
        Statement st1;
        ResultSet rs1;
        String[] batiment = new String[10];
        try {
            String sql1 = request1;
            st1 = co.createStatement();
            System.out.println(sql1);
            rs1 = st1.executeQuery(sql1);
            int i = 0;
            while (rs1.next()) {
                batiment[i] = rs1.getString("stat");
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return batiment;
    }
}
