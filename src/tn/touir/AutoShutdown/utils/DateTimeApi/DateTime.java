package tn.touir.AutoShutdown.utils.DateTimeApi;

import java.util.Map;

public class DateTime {
	private String abbreviation;
	private String clientIP;
	private String dateTime;
	private int dayOfWeek;
	private int dayOfYear;
	private int hour;
	private boolean daylightSavingTime;
	private String daylightSavingTimeFrom;
	private int daylightSavingTimeOffset;
	private String daylightSavingTimeUntil;
	private int rawOffset;
	private String timezone;
	private String unixtime;
	private String utcDateTime;
	private String utcOffset;
	private int weekNumber;

	public DateTime() {
		super();
	}

	public DateTime(Map<String, String> map) {
		super();

		abbreviation = map.get(DateTimeApiKeys.ABBREVIATION);
		clientIP = map.get(DateTimeApiKeys.CLIENT_IP);
		dateTime = map.get(DateTimeApiKeys.DATETIME);
		try {
			dayOfWeek = Integer.valueOf(map.get(DateTimeApiKeys.DAY_OF_WEEK));
		} catch (Exception e) {
		}
		dayOfYear = Integer.valueOf(map.get(DateTimeApiKeys.DAY_OF_YEAR));
		try {
			hour = DateTimeAPI.getHour(map);
		} catch (Exception e) {
		}
		daylightSavingTime = !"false".equals(map.get(DateTimeApiKeys.DAYLIGHT_SAVING_TIME));
		daylightSavingTimeFrom = map.get(DateTimeApiKeys.DAYLIGHT_SAVING_TIME_FROM);
		try {
			daylightSavingTimeOffset = Integer.valueOf(map.get(DateTimeApiKeys.DAYLIGHT_SAVING_TIME_OFFSET));
		} catch (Exception e) {
		}
		daylightSavingTimeUntil = map.get(DateTimeApiKeys.DAYLIGHT_SAVING_TIME_UNTIL);
		try {
			rawOffset = Integer.valueOf(map.get(DateTimeApiKeys.RAW_OFFSET));
		} catch (Exception e) {
		}
		timezone = map.get(DateTimeApiKeys.TIMEZONE);
		unixtime = map.get(DateTimeApiKeys.UNIX_TIME);
		utcDateTime = map.get(DateTimeApiKeys.UTC_DATETIME);
		utcOffset = map.get(DateTimeApiKeys.UTC_OFFSET);
		try {
			weekNumber = Integer.valueOf(map.get(DateTimeApiKeys.WEEK_NUMBER));
		} catch (Exception e) {
		}
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public boolean isDaylightSavingTime() {
		return daylightSavingTime;
	}

	public void setDaylightSavingTime(boolean daylightSavingTime) {
		this.daylightSavingTime = daylightSavingTime;
	}

	public String getDaylightSavingTimeFrom() {
		return daylightSavingTimeFrom;
	}

	public void setDaylightSavingTimeFrom(String daylightSavingTimeFrom) {
		this.daylightSavingTimeFrom = daylightSavingTimeFrom;
	}

	public int getDaylightSavingTimeOffset() {
		return daylightSavingTimeOffset;
	}

	public void setDaylightSavingTimeOffset(int daylightSavingTimeOffset) {
		this.daylightSavingTimeOffset = daylightSavingTimeOffset;
	}

	public String getDaylightSavingTimeUntil() {
		return daylightSavingTimeUntil;
	}

	public void setDaylightSavingTimeUntil(String daylightSavingTimeUntil) {
		this.daylightSavingTimeUntil = daylightSavingTimeUntil;
	}

	public int getRawOffset() {
		return rawOffset;
	}

	public void setRawOffset(int rawOffset) {
		this.rawOffset = rawOffset;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(String unixtime) {
		this.unixtime = unixtime;
	}

	public String getUtcDateTime() {
		return utcDateTime;
	}

	public void setUtcDateTime(String utcDateTime) {
		this.utcDateTime = utcDateTime;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	@Override
	public String toString() {
		return "DateTime [abbreviation=" + abbreviation + ", clientIP=" + clientIP + ", dateTime=" + dateTime
				+ ", dayOfWeek=" + dayOfWeek + ", dayOfYear=" + dayOfYear + ", hour=" + hour + ", daylightSavingTime="
				+ daylightSavingTime + ", daylightSavingTimeFrom=" + daylightSavingTimeFrom
				+ ", daylightSavingTimeOffset=" + daylightSavingTimeOffset + ", daylightSavingTimeUntil="
				+ daylightSavingTimeUntil + ", rawOffset=" + rawOffset + ", timezone=" + timezone + ", unixtime="
				+ unixtime + ", utcDateTime=" + utcDateTime + ", utcOffset=" + utcOffset + ", weekNumber=" + weekNumber
				+ "]";
	}

}
