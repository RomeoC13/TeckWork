package edu.episen.si.ing1.pds.backend.server;

import java.sql.*;

public class DAO {



    public static void main(String[] args) {
        PoolConnect pool = new PoolConnect();

        try {
            Class.forName(pool.getDriver());
            System.out.println("Connecting to Database...");
            Connection co = DriverManager.getConnection(pool.getUrl(), pool.getUser(), pool.getPassword());

            System.out.println("Creating statement");
            Statement stmt = co.createStatement();

            String sql = "INSERT INTO Personne VALUES('Michael')";

            int rows = stmt.executeUpdate(sql);
            System.out.println("Rows impacted " + rows);

            sql = "SELECT* FROM Personne";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String result = rs.getString("Prenoms");
                System.out.println(result);
            }
            rs.close();
            stmt.close();
            co.close();
        }catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    }
}
