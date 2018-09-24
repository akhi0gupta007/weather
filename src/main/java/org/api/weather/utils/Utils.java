package org.api.weather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class for storing utility methods
 * @author akhilesh
 *
 */
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


	/**
	 * Retrives the date object of 1 day later than date passed as argument
	 * @param date is the date
	 * @return date object after adding 1 day
	 */
	public static Date getTomorrowDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/** Gets the today's date object
	 * @param date
	 * @return
	 */
	public static Date getTodayDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * Gets the current hour in AM/PM format for date object passed as argument
	 * @param date is date object
	 * @return the AM/PM time 
	 */
	public static String getHour(Date date) {
		return new SimpleDateFormat("hh:mm a").format(date);		
	}

}
