package ui.indicator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import client.ClientConfiguration;
import client.Request;
import client.Response;


public class DataIndicator {

	ObjectMapper mapper = new ObjectMapper();

	private void getData() {
		try {
			Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Request request = new Request();
			String event = "user_list";
			request.setEvent(event);
			writer.println(mapper.writeValueAsString(request));
			System.out.println("data Send");
			while (true) {
				String line = reader.readLine();
				if (line == null || line.equals("end"))
					break;

				if (!line.equals("end"))
					break;

				Response response = mapper.readValue(line, Response.class);
				if (response.getEvent().equals(event)) {
					List<Map<String, String>> data = (List) response.getMessage();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
