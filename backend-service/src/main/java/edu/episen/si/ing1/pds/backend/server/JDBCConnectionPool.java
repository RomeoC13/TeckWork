package edu.episen.si.ing1.pds.backend.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCConnectionPool {
	
	private ArrayList<Connection> myCon = new ArrayList<Connection>();
	private Properties props = new Properties();
	
	
	public JDBCConnectionPool() throws FileNotFoundException, IOException {
		try (FileInputStream fis = new FileInputStream("conf.properties")) {
					props.load(fis);
		}
	}	
	
	public ArrayList<Connection> getMyCon() {
		return myCon;
		

	}
	
	public void turnConnection(int size) {
		try {
			Class.forName(props.getProperty("jdbc.driver"));
			String url = props.getProperty("jdbc.url");
			String login = props.getProperty("jdbc.login");
			String pwd = props.getProperty("jdbc.password");
			for (int i = 0; i < size;i++) {
				Connection con = DriverManager.getConnection(url, login, pwd);
				myCon.add(con);
			}
			
		}catch (Exception e) {
			
		}
	}

	
	public Connection sendBackConnection() {
		Connection connex = myCon.get(0);
		myCon.remove(0);
		return connex;
		
	}
	
	public void putBackConnection(Connection con) {
		myCon.add(con);
	}
	
	public void closeConnexion() {
		for(Connection con: myCon)
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
