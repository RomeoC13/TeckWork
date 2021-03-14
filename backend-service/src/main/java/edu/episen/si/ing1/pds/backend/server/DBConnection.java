package edu.episen.si.ing1.pds.backend.server;

//import ch.qos.logback.core.encoder.EchoEncoder;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBConnection {
	
	
	private static final Logger logger = LoggerFactory.getLogger(BackendService.class.getName());
	private static Connection con = null;
	
	
	public static void main(String[] args) throws Exception {

		
		Properties props = new Properties();
		logger.info(System.getProperty("user.dir"));
		try (FileInputStream fis = new FileInputStream("conf.properties")) {
			props.load(fis);
		}


		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String pwd = props.getProperty("jdbc.password");
		try {
			con = DriverManager.getConnection(url, login, pwd);
			if (!con.equals(null)) {
				System.out.println("CONNECTION OK");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		boolean isInTestMode = false;
		int maxCo = 10;

		Options options = new Options();
		options.addOption("testMode", false, "a simple cli option to run this service as test, default is false");


		//Should be working but don't I don't why
		//options.addOption("maxConnection",true,"specify max connections in this run, default set to 10");

		//Instead i will be using this method :
		final Option maxConnection = Option.builder().longOpt("maxConnections")
				.hasArg()
				.argName("maxConnections")
				.desc("specify max connections in this run, default set to 10")
				.build();

		options.addOption(maxConnection);

		final Option sqlReq = Option.builder().longOpt("sqlReq")
				.hasArg()
				.argName("sqlReq")
				.desc("specify witch request you want to set on the db")
				.build();

		options.addOption(sqlReq);

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			logger.error("Options parser error : " + e.getMessage());
		}

		String loggerInfo = "BackendService is running.";
		if (cmd.hasOption("testMode")) {
			isInTestMode = true;
			loggerInfo += "\n Test mode is on";
		}
		if (cmd.hasOption("maxConnections")) {
			maxCo = Integer.parseInt(cmd.getOptionValue("maxConnections"));
			loggerInfo += "\n Max connections has been set to " + maxCo;

		}
		if(cmd.hasOption("sqlReq")){
			String request =cmd.getOptionValue("sqlReq");
			logger.info(request);
			try(Statement stm= con.createStatement(); ResultSet result = stm.executeQuery(request)){
				stm.execute(request);
				while(result.next()){
					logger.info(result.toString());
				}
			} catch (Exception e){
				logger.error("Error with executing to db : " +e.getMessage());
			}
		}
		logger.info(loggerInfo);

	}
}

