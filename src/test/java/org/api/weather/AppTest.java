package org.api.weather;

import static org.junit.Assert.assertNotNull;

import org.api.weather.config.AppConfig;
import org.api.weather.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test the functionality of Service Method Weather Service.
 * @author akhilesh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class AppTest{
	
	@Autowired
	private WeatherService service;
	
	@Autowired
	Environment env;
	
	/**
	 * Test if the weather app service retrieves results from web service 
	 */
	@Test
	public void testWeatherWebService() {
		String findCoolestDayByZip = service.findCoolestDayByZip(env.getProperty("zip"));
		System.out.println(findCoolestDayByZip);
		assertNotNull(findCoolestDayByZip);
	}		

}
