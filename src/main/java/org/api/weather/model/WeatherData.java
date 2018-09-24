package org.api.weather.model;

import java.util.Date;


/**
 * Data model to store the weather data (Minimum and Maximum Temp.) of a particular city by timestamp
 * @author akhilesh
 *
 */
public class WeatherData {

	private Date timestamp;
	private Double temp_min;
	private Double temp_max;
	private String zip;
	
	public WeatherData() {
		super();
	}
	public WeatherData(String zip) {
		super();
		this.zip = zip;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
			

	@Override
	public String toString() {
		return "WeatherData [timestamp=" + timestamp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", zip="
				+ zip + "]";
	}
	
}
