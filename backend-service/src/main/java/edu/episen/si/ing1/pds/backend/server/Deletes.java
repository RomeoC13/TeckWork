package edu.episen.si.ing1.pds.backend.server;

import java.sql.*;

public class Deletes {

    public static void main(String[] args) {

        PoolConnect pool1 = new PoolConnect();

        try{
            Class.forName(pool1.getDriver());
            System.out.println("Connecting to Database...");
            Connection coon = DriverManager.getConnection(pool1.getUrl(),pool1.getUser(),pool1.getPassword());

            System.out.println("Creating statement");
            Statement stat1 = coon.createStatement();

            String sql2 = "DELETE FROM Personne WHERE prenoms = 'Yohan'";

            int rows = stat1.executeUpdate(sql2);

            sql2 = "SELECT* FROM Personne";
            ResultSet rs = stat1.executeQuery(sql2);
            while(rs.next()){
                String result = rs.getString("Prenoms");
                System.out.println(result);
            }
            rs.close();
            coon.close();
            stat1.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

