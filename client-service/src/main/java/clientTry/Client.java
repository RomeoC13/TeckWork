package clientTry;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import client.ClientConfiguration;
import ui.Home;

public class Client {
 
	private final static Logger logger = LoggerFactory.getLogger(Client.class.getName());
	private static ClientProperties config = new ClientProperties();
	private ClientJsonConfig jsonFile;
	private static Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
	private static Socket clientSocket;
	private static String message;
	private static PrintWriter output;
	private static BufferedReader input;

	public Client() throws UnknownHostException, IOException {
		
	}

	public String sendBD(String request) throws IOException  {


			ObjectMapper mapper = new ObjectMapper();
			
			Request requestObj = new Request();
			requestObj.setEvent(request);
			String data = mapper.writeValueAsString(requestObj);
			logger.info("Data sent to server is {}", data);
			clientSocket = new Socket(new ClientYamlConfig().getConfig().getAdressIP(), new ClientYamlConfig()
					.getConfig().getPort());
			output = new PrintWriter(clientSocket.getOutputStream(),true);
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			output.println(data);
			message = input.readLine();
			
			
			return message;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			final Options options = new Options();
			final Option requesttype = Option.builder().longOpt("requesttype").hasArg().argName("requesttype").build();
			options.addOption(requesttype);

			final CommandLineParser clp = new DefaultParser();
			final CommandLine commandLine = clp.parse(options, args);

			 Client cl = new Client();
			 String affiche =  cl.sendBD("equipments");
			 logger.info(affiche);
			 
			 input.close();
			 output.close();
			 clientSocket.close();
			 

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
