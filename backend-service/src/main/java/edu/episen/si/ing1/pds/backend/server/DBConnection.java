package edu.episen.si.ing1.pds.backend.server;

//import ch.qos.logback.core.encoder.EchoEncoder;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class DBConnection {

	public static void main(String[] args) throws Exception {
		Connection conn = null;

		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("C:\\Users\\elhad\\Documents\\git\\teck-work\\backend-service\\conf.properties")) {
			props.load(fis);
		}


		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String pwd = props.getProperty("jdbc.password");
		try (Connection con = DriverManager.getConnection(url, login, pwd)) {
			if (conn != null) {
				System.out.println("CONNECTION OK");
			}
		}
        int choix = 0;
    while(choix!= 5) {
        	System.out.println("\n choose a number between 1 TO 6\n 1 - insert\n 2 - delete\n 3 - select\n 4 - create\n 5 - exit\n ");
        	Scanner sc = new Scanner(System.in);
        	choix = sc.nextInt();
        	switch (choix) {
				case 1:
					try (Connection con = DriverManager.getConnection(url, login, pwd)) {
						String request = "insert into users1 (name, login) values ('TATA', 'TATA')";
						try (Statement stm = con.createStatement()) {
							System.out.println();
							stm.executeUpdate(request);
							try {
								System.out.println("INSERT INTO SUCCESS ! ");
								System.out.println();
							} catch (Exception exc) {

							}
						} catch (Exception exc) {
							System.out.println("INSERT INTO FAILED ! ");
							System.out.println();
						}

					}
					break;
				case 2:
					try (Connection con = DriverManager.getConnection(url, login, pwd)) {
						try (Statement stmt = con.createStatement()) {
							System.out.println("you want to delete an row\n ENTER AN ID ");
							int id = sc.nextInt();
							String request = "delete from users where USR_ID = " + id;
							stmt.executeUpdate(request);
							try {
								System.out.println("DELETE SUCCESS ! ");
								System.out.println();
							} catch (Exception exc) {

							}
						} catch (Exception exc) {
							System.out.println("DELETE FAILED ! ");
							System.out.println();
						}

					}
					break;
				case 3:
					try (Connection con = DriverManager.getConnection(url, login, pwd)) {
						String request = "select * from users";
						try (Statement stmt = con.createStatement(); ResultSet result = stmt.executeQuery(request)) {
							while (result.next()) {
								try {
									int id = result.getInt(1);
									String name = result.getString(2);
									String log = result.getString(3);
									System.out.println(id + "-" + name + "-" + log);
									System.out.println();
									System.out.println("SELECT SUCCESS !");
									System.out.println();
								} catch (Exception e) {
									System.out.println("SELECT FAILED !");
									System.out.println();
								}
							}

						}

					}
					break;
				case 4:
					try (Connection con = DriverManager.getConnection(url, login, pwd)) {
						String request = "create table ADMIN ("
								+ "id INT PRIMARY KEY NOT NULL,\r\n"
								+ "    nom VARCHAR(100),\r\n"
								+ "    prenom VARCHAR(100))";
						try (Statement stmt = con.createStatement()) {
							stmt.executeUpdate(request);
							try {
								System.out.println("CREATE SUCCESS ! ");
								System.out.println();
							} catch (Exception exc) {

							}
						} catch (Exception exc) {
							System.out.println("CREATE FAILED ! ");
							System.out.println();
						}
					}
					break;
				case 5:
					System.out.println("you exit the menu");
					break;
			}
        
       
    
        }   
    }
    
}


		/*try {
			conn = DriverManager.getConnection(url, login, pwd);
			if (conn != null) {
				System.out.println("CONNECTION OK");
			} else {
				System.out.println("CONNECTION FAILED");
			}

			Statement statement = conn != null ? conn.createStatement() : null;
			//Statement statement = conn.createStatement();


			ResultSet rs = statement.executeQuery("SELECT * FROM public.\"USERS\"");

			while (rs.next()) {
				int idUsers = rs.getInt("USR_ID");
				String mdp = rs.getString("USR_PASSWORD");
				String name = rs.getString("USR_NAME");
				System.out.println(idUsers + " / " + name + " / " + mdp);
			}
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}*/



