package edu.episen.si.ing1.pds.backend.server.release2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientHandler implements Runnable {
	
	private final static Logger logger = LoggerFactory.getLogger(ClientHandler.class);
	private final PrintWriter output;
	private final BufferedReader input;
	private Connection c;
	private ObjectMapper mapper = new ObjectMapper();
	private Thread clientThread = new Thread(this);
	

	private Boolean done = false;
	
	@SuppressWarnings("deprecation")
	public ClientHandler(Socket serverSocket, Connection connect) throws Exception {
		c = connect;
		output = new PrintWriter(serverSocket.getOutputStream(),true);
		input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		
		clientThread.start();
		while(done) {
			serverSocket.close();
			clientThread.stop();
		}
		logger.debug("j'ai fait le run");
		
	}

	@Override
	public void run() {
		
		try {
			String clientMessage = input.readLine();
			Request map = mapper.readValue(clientMessage, Request.class);
			
			logger.info("Data received from client is {}", map);
			
			if(map.getEvent().equals("building"))
				allBuilding();
			else if(map.getEvent().equals("equipments"))
				logger.info("Getting equipment list");
//			switch (clientMessage) {
//			case "building":
//				allBuilding(map);
//				break;
//
//			default:
//				break;
//			}
			
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}

	public void allBuilding() {
		
		try {
			String request = "select * from building";
			ResultSet reSet = c.createStatement().executeQuery(request);
			List<Map<String, String>> result = new ArrayList<>();
			
			while (reSet.next()) {
				Map<String, String> resultmap = new HashMap<String, String>();
				resultmap.put("build_id", reSet.getString(1));
				resultmap.put("build_address", reSet.getString(2));
				resultmap.put("build_city", reSet.getString(3));
				resultmap.put("build_name", reSet.getString(4));
				
				result.add(resultmap);
			}
			output.println(mapper.writeValueAsString(result));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		} finally {
			done = true;
		}
		
		
		
	}
	
	public Thread getClientThread() {
		return clientThread;
	}
	
	
	
	
	
	
	
	
	
}
//    private final Socket clientSocket;
//    private final Connection connection;
//    private static String[] requestList = new String[1];
//
//    // Constructor
//    public ClientHandler(Socket socket, Connection connection) {
//        this.clientSocket = socket;
//        this.connection = connection;
//        this.requestList[0] = "SELECT DISTINCT name FROM equipment";
//    }
//
//    public void run() {
//
//        try {
//            OutputStream out = clientSocket.getOutputStream();
//            InputStream in = clientSocket.getInputStream();
//            byte[] data;
//            sleep(200);
//            if (in.available() != 0) {
//                data = new byte[in.available()];
//                in.read(data);
//                ObjectMapper om = new ObjectMapper(new JsonFactory());
//
//                ClientJsonProperties json = om.readValue(data, ClientJsonProperties.class);
//
//                System.out.println(json.getRequestId());
//
//                String[] requestAnswer = read(requestList[Integer.parseInt(json.getRequestId())], connection);
//                StringBuilder answer = new StringBuilder();
//                for (String s : requestAnswer) {
//                    answer.append(s).append(",");
//                }
//                System.out.println(answer.toString());
//                DataOutputStream outdata = new DataOutputStream(out);
//                outdata.writeUTF(answer.toString());
//
//
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


