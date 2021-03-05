package edu.episen.si.ing1.pds.backend.server;

import java.sql.*;

public class Updates {
    public static void main(String[] args) {

        PoolConnect pc = new PoolConnect();

        try{
            Class.forName(pc.getDriver());
            System.out.println("Connecting to Database...");
            Connection coo = DriverManager.getConnection(pc.getUrl(),pc.getUser(),pc.getPassword());

            System.out.println("Creating statement");
            Statement sts = coo.createStatement();

            String sql1 = "UPDATE Personne Set prenoms = 'Yohan'";

            int rows = sts.executeUpdate(sql1);

            sql1 = "SELECT* FROM Personne";
            ResultSet rs = sts.executeQuery(sql1);
            while(rs.next()){
                String result = rs.getString("Prenoms");
                System.out.println(result);
            }
            rs.close();
            coo.close();
            sts.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

