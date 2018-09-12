package org.api.weather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	/**
	 * Parse the date in <code> yyyy-mm-dd hh:mm:ss </code> pattern
	 * 
	 * @param dateTxt
	 *            is the Date to be parsed
	 * @return the <code> java.util.Date </code> object
	 */
	public static Date formatDate(String dateTxt) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(dateTxt);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static Double parseDouble(String data) {
		try {
			return Double.parseDouble(data);
		} catch (NumberFormatException ex) {
			return 0.0;
		}

	}

	public static Date getTomorrowDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getTodayDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static int getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	public static void main(String[] args) {
		System.out.println(getTodayDate(new Date()));
	}
}
