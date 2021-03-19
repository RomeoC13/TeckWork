package edu.episen.si.ing1.pds.backend.server;

import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public class Test {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		DataSource ds = new DataSource(5);
		for(int i = 0; i < 10; i++) {
			Connection con = ds.addData();
			try {
				System.out.println(con.isValid(1000));
				Statement stmt = con.createStatement();
				String request = "select * from person";
				ResultSet rs = stmt.executeQuery(request);
				while(rs.next())
					logger.info(rs.getString(2));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				ds.removeData(con);
			}
		}
		ds.closeAllConnection();

	}

}
