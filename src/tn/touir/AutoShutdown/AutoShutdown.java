package tn.touir.AutoShutdown;

import java.time.LocalDateTime;
import java.util.Map;

import tn.touir.AutoShutdown.utils.ConfigurationUtils;

public class AutoShutdown {

	private static final String CONFIGURATION_FILE_PATH = "./config.ini";
	private static final int LOOP_INTERVAL_MS = 60000;
	
	public static void main(String[] args) {
		try {
			
			Map<String, String> config = ConfigurationUtils.readConfiguration(CONFIGURATION_FILE_PATH);
			
			for(Map.Entry<String, String> entry : config.entrySet()) {
				System.out.println(entry.getKey() + " = " + entry.getValue());
			}
			
			LocalDateTime time = LocalDateTime.now();
			int dayOfWeek = time.getDayOfWeek().getValue() % 7;
			int hour = time.getHour();
			
			while(true) {
				int startHour = ConfigurationUtils.getStartHour(dayOfWeek, config);
				int endHour = ConfigurationUtils.getEndHour(dayOfWeek, config);
				
				// hibernate
				if(hour <= startHour || hour >= endHour) {
					Runtime.getRuntime().exec("shutdown /h");
				}
				
				Thread.sleep(LOOP_INTERVAL_MS);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
