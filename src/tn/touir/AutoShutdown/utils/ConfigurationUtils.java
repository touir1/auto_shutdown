package tn.touir.AutoShutdown.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ConfigurationUtils {
	
	public static Map<String, String> readConfiguration(String configurationFilePath) throws IOException{
		Map<String, String> result = new HashMap<String, String>();
		
		File configurationFile = new File(configurationFilePath);
		if(configurationFile.exists()) {
			List<String> fileContent = readLineByLine(configurationFilePath);
			for(String line : fileContent) {
				String[] keyValuePair = line.split("=");
				result.put(keyValuePair[0].trim(), keyValuePair[1].trim());
			}
		}
		else {
			configurationFile.createNewFile();
			FileWriter writer = new FileWriter(configurationFilePath);
			result.putAll(getInitialConfiguration());
			List<String> configs = new ArrayList<String>();
			
			for(Map.Entry<String, String> element : result.entrySet()) {
				configs.add(element.getKey() + "=" + element.getValue() + "\n");
			}
			configs.sort(ConfigurationKeys.orderComparator);
			for(String line : configs) {
				writer.append(line);
			}
			
			writer.close();
		}
		
		return result;
	}
	
	private static List<String> readLineByLine(String filePath) 
    {
        List<String> result = new ArrayList<String>();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> result.add(s));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return result;
    }
	
	private static Map<String, String> getInitialConfiguration(){
		Map<String, String> result = new HashMap<String, String>();
		// sunday
		result.put(ConfigurationKeys.SUNDAY_ACTIVE, "0");
		result.put(ConfigurationKeys.SUNDAY_START, "00");
		result.put(ConfigurationKeys.SUNDAY_END, "00");
		// monday
		result.put(ConfigurationKeys.MONDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.MONDAY_START, "06");
		result.put(ConfigurationKeys.MONDAY_END, "18");
		// tuesday
		result.put(ConfigurationKeys.TUESDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.TUESDAY_START, "06");
		result.put(ConfigurationKeys.TUESDAY_END, "18");
		// wednesday
		result.put(ConfigurationKeys.WEDNESDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.WEDNESDAY_START, "06");
		result.put(ConfigurationKeys.WEDNESDAY_END, "18");
		// thursday
		result.put(ConfigurationKeys.THURSDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.THURSDAY_START, "06");
		result.put(ConfigurationKeys.THURSDAY_END, "18");
		// friday
		result.put(ConfigurationKeys.FRIDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.FRIDAY_START, "06");
		result.put(ConfigurationKeys.FRIDAY_END, "18");
		// saturday
		result.put(ConfigurationKeys.SATURDAY_ACTIVE, "1");
		result.put(ConfigurationKeys.SATURDAY_START, "06");
		result.put(ConfigurationKeys.SATURDAY_END, "13");
		
		return result;
	}
	
	public static int getStartHour(int dayOfWeek, Map<String, String> config) {
		if(!isActive(dayOfWeek,config)) return 24;
		switch(dayOfWeek) {
			case 0: return Integer.valueOf(config.get(ConfigurationKeys.SUNDAY_START));
			case 1: return Integer.valueOf(config.get(ConfigurationKeys.MONDAY_START));
			case 2: return Integer.valueOf(config.get(ConfigurationKeys.TUESDAY_START));
			case 3: return Integer.valueOf(config.get(ConfigurationKeys.WEDNESDAY_START));
			case 4: return Integer.valueOf(config.get(ConfigurationKeys.THURSDAY_START));
			case 5: return Integer.valueOf(config.get(ConfigurationKeys.FRIDAY_START));
			case 6: return Integer.valueOf(config.get(ConfigurationKeys.SATURDAY_START));
			default: return 24;
		}
	}
	
	public static boolean isActive(int dayOfWeek, Map<String, String> config) {
		
		switch(dayOfWeek) {
			case 0: return "1".equals(config.get(ConfigurationKeys.SUNDAY_ACTIVE));
			case 1: return "1".equals(config.get(ConfigurationKeys.MONDAY_ACTIVE));
			case 2: return "1".equals(config.get(ConfigurationKeys.TUESDAY_ACTIVE));
			case 3: return "1".equals(config.get(ConfigurationKeys.WEDNESDAY_ACTIVE));
			case 4: return "1".equals(config.get(ConfigurationKeys.THURSDAY_ACTIVE));
			case 5: return "1".equals(config.get(ConfigurationKeys.FRIDAY_ACTIVE));
			case 6: return "1".equals(config.get(ConfigurationKeys.SATURDAY_ACTIVE));
			default: return false;
		}
	}
	
	public static int getEndHour(int dayOfWeek, Map<String, String> config) {
		if(!isActive(dayOfWeek,config)) return 0;
		switch(dayOfWeek) {
			case 0: return Integer.valueOf(config.get(ConfigurationKeys.SUNDAY_END));
			case 1: return Integer.valueOf(config.get(ConfigurationKeys.MONDAY_END));
			case 2: return Integer.valueOf(config.get(ConfigurationKeys.TUESDAY_END));
			case 3: return Integer.valueOf(config.get(ConfigurationKeys.WEDNESDAY_END));
			case 4: return Integer.valueOf(config.get(ConfigurationKeys.THURSDAY_END));
			case 5: return Integer.valueOf(config.get(ConfigurationKeys.FRIDAY_END));
			case 6: return Integer.valueOf(config.get(ConfigurationKeys.SATURDAY_END));
			default: return 0;
		}
	}
}
