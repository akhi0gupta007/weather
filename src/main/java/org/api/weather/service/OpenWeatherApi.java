package org.api.weather.service;

import org.springframework.stereotype.Service;

@Service
public class OpenWeatherApi implements WeatherService {

	
	public String findCoolestDayByZip(String zip) {
		return "test";
	}

}
