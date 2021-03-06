package tn.touir.AutoShutdown;

import java.time.LocalDateTime;
import java.util.Map;

import tn.touir.AutoShutdown.utils.ConfigurationKeys;
import tn.touir.AutoShutdown.utils.ConfigurationUtils;
import tn.touir.AutoShutdown.utils.DateTimeApi.DateTime;
import tn.touir.AutoShutdown.utils.DateTimeApi.DateTimeAPI;

public class AutoShutdown {

	private static final String CONFIGURATION_FILE_PATH = "./config.ini";

	public static void main(String[] args) {

		Thread t = new Thread() {
			public void run() {
				try {

					Map<String, String> config = ConfigurationUtils.readConfiguration(CONFIGURATION_FILE_PATH);

					int loopInterval = Integer.valueOf(config.get(ConfigurationKeys.LOOP_INTERVAL_MS));
					String shutdownCommand = config.get(ConfigurationKeys.SHUTDOWN_COMMAND);
					
					System.out.println(config);

					LocalDateTime time = LocalDateTime.now();
					int dayOfWeek = time.getDayOfWeek().getValue() % 7;
					int hour = time.getHour();

					while (true) {
						int startHour = ConfigurationUtils.getStartHour(dayOfWeek, config);
						int endHour = ConfigurationUtils.getEndHour(dayOfWeek, config);

						try {
							DateTime dateTime = DateTimeAPI.getDateTime();
							dayOfWeek = dateTime.getDayOfWeek();
							hour = dateTime.getHour();

						} catch (Exception e) {
							// nothing to do
						}

						// hibernate
						if (hour < startHour || hour >= endHour) {
							System.out.println("Setting windows on hibernate");
							Runtime.getRuntime().exec(shutdownCommand);
						} else {
							System.out.println("Windows is still on");
						}

						Thread.sleep(loopInterval);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();

	}

}
