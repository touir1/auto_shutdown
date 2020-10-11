package tn.touir.AutoShutdown.utils.DateTimeApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DateTimeAPI {

	private static final String API_URL = "http://worldtimeapi.org/api/ip.txt";

	public static int getHour() throws IOException {
		String dateTime = getFullApiResponse().get(DateTimeApiKeys.DATETIME);
		
		return Integer.valueOf(dateTime.split("T")[1].substring(0, 2));
	}
	
	public static int getHour(Map<String, String> map) {
		String dateTime = map.get(DateTimeApiKeys.DATETIME);
		
		return Integer.valueOf(dateTime.split("T")[1].substring(0, 2));
	}

	public static int getDayOfWeek() throws IOException {
		return Integer.valueOf(getFullApiResponse().get(DateTimeApiKeys.DAY_OF_WEEK));
	}
	
	public static int getDayOfWeek(Map<String, String> map) {
		return Integer.valueOf(map.get(DateTimeApiKeys.DAY_OF_WEEK));
	}

	public static Map<String, String> getFullApiResponse() throws IOException {
		Map<String, String> result = new HashMap<String, String>();
		URL url = new URL(API_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			String[] keyValue = inputLine.split(":");
			result.put(keyValue[0].trim(), keyValue[1].trim());
		}
		in.close();

		return result;
	}
	
	public static DateTime getDateTime() throws IOException {
		Map<String, String> map = getFullApiResponse();
		return new DateTime(map);
	}
}
