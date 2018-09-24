package org.api.weather.service;


/**
 * Web service Interface for Weather Service
 * @author akhilesh
 *
 */
public interface WeatherService {
	
	/**
	 * Find the coolest Day of city by its zip for tomorrow.
	 * @param zip is the zip of a US city 
	 * @return description of coolest day
	 */
	String findCoolestDayByZip(String zip);
}
