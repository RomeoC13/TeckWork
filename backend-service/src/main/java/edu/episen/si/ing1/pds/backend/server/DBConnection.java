package edu.episen.si.ing1.pds.backend.server;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class DBConnection {
	
    public static void main(String[] args) throws Exception{
        Connection conn = null;

        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("conf.properties")) {
            props.load(fis);
        }
        

        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String pwd = props.getProperty("jdbc.password");
        try(Connection con = DriverManager.getConnection(url, login, pwd)){
	        if(conn != null) {
	          System.out.println("CONNECTION OK");
	       }
        }
        int choix = 0;
    while(choix!= 4) {
        	System.out.println("choose your number\n choose a number\n 1 - insert\n 2 - delete\n 3 - select\n ");
        	Scanner sc = new Scanner(System.in);
        	choix = sc.nextInt();
        	switch (choix) {
			case 1:
				try(Connection con = DriverManager.getConnection(url, login, pwd)){
					String request = "insert into users (name, login) values ('JE', 'first')";
					try(Statement stm = con.createStatement()){
						stm.executeUpdate(request);
					}
					
				}
				break;
			case 2 :
				try(Connection con = DriverManager.getConnection(url, login, pwd)) {
					try(Statement stmt = con.createStatement()){
						System.out.println("you want to delete an row\n ENTER AN ID ");
						int id = sc.nextInt();
						String request = "delete from users where id = "+id;
						stmt.executeUpdate(request);
					}
					
				} 
				break;
			case 3:
				try(Connection con = DriverManager.getConnection(url, login, pwd)) {
					String request  = "select * from users";
					try(Statement stmt = con.createStatement();ResultSet result = stmt.executeQuery(request)){
						while(result.next()) {
							int id = result.getInt(1);
							String name = result.getString(2);
							String log = result.getString(3);
							System.out.println(id+"-"+name+"-"+log);
						}
						
					}
					
				}
				break;
			case 4 :
				try(Connection con = DriverManager.getConnection(url, login, pwd)) {
					System.out.println("please enter name");
					String nameVar = sc.nextLine();
					System.out.println(nameVar);
					System.out.println("please enter your login");
					String loginVar = sc.nextLine();
					System.out.println(login);
				}
				break;
						
			default:
				System.out.println("you selected wrong number");
				break;
			}
        
       
    
        }   
    }
    
}    
  

        
//        try {
//            conn = DriverManager.getConnection(url, login, pwd);
//            if(conn != null) {
//               System.out.println("CONNECTION OK");
//            } else {
//                System.out.println("CONNECTION FAILED");
//            }
//
//            //Statement statement = conn != null ? conn.createStatement() : null;
//            Statement statement = conn.createStatement();
//            
//            
//
//
//            ResultSet rs = statement.executeQuery("SELECT * FROM users");
//
//            while(rs.next()) {
//                int idUsers = rs.getInt(2);
//                System.out.println(idUsers);
//            }
//        } catch (Exception e) {
//            if(conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//


