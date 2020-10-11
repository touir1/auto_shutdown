package tn.touir.AutoShutdown.utils;

import java.util.Comparator;

public class ConfigurationKeys {
	
	// sunday
	public static final String SUNDAY_ACTIVE = "DayOfWeek0_active";
	public static final String SUNDAY_START = "DayOfWeek0_start";
	public static final String SUNDAY_END = "DayOfWeek0_end";
	// monday
	public static final String MONDAY_ACTIVE = "DayOfWeek1_active";
	public static final String MONDAY_START = "DayOfWeek1_start";
	public static final String MONDAY_END = "DayOfWeek1_end";
	// tuesday
	public static final String TUESDAY_ACTIVE = "DayOfWeek2_active";
	public static final String TUESDAY_START = "DayOfWeek2_start";
	public static final String TUESDAY_END = "DayOfWeek2_end";
	// wednesday
	public static final String WEDNESDAY_ACTIVE = "DayOfWeek3_active";
	public static final String WEDNESDAY_START = "DayOfWeek3_start";
	public static final String WEDNESDAY_END = "DayOfWeek3_end";
	// thursday
	public static final String THURSDAY_ACTIVE = "DayOfWeek4_active";
	public static final String THURSDAY_START = "DayOfWeek4_start";
	public static final String THURSDAY_END = "DayOfWeek4_end";
	// friday
	public static final String FRIDAY_ACTIVE = "DayOfWeek5_active";
	public static final String FRIDAY_START = "DayOfWeek5_start";
	public static final String FRIDAY_END = "DayOfWeek5_end";
	// saturday
	public static final String SATURDAY_ACTIVE = "DayOfWeek6_active";
	public static final String SATURDAY_START = "DayOfWeek6_start";
	public static final String SATURDAY_END = "DayOfWeek6_end";
	
	public static int getOrder(String key) {
		int result = 999;
		switch(key) {
			case SUNDAY_ACTIVE : result = 1; break;
			case SUNDAY_START : result = 2; break;
			case SUNDAY_END : result = 3; break;
			case MONDAY_ACTIVE : result = 4; break;
			case MONDAY_START : result = 5; break;
			case MONDAY_END : result = 6; break;
			case TUESDAY_ACTIVE : result = 7; break;
			case TUESDAY_START : result = 8; break;
			case TUESDAY_END : result = 9; break;
			case WEDNESDAY_ACTIVE : result = 10; break;
			case WEDNESDAY_START : result = 11; break;
			case WEDNESDAY_END : result = 12; break;
			case THURSDAY_ACTIVE : result = 13; break;
			case THURSDAY_START : result = 14; break;
			case THURSDAY_END : result = 15; break;
			case FRIDAY_ACTIVE : result = 16; break;
			case FRIDAY_START : result = 17; break;
			case FRIDAY_END : result = 18; break;
			case SATURDAY_ACTIVE : result = 19; break;
			case SATURDAY_START : result = 20; break;
			case SATURDAY_END : result = 21; break;
		}
		
		return result;
	}
	
	public static final Comparator<String> orderComparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			int i1 = ConfigurationKeys.getOrder(o1.split("=")[0]);
			int i2 = ConfigurationKeys.getOrder(o2.split("=")[0]);
			
			return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
		}
	};
}
