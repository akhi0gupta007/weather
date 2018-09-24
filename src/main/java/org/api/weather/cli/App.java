package org.api.weather.cli;

import java.util.Scanner;

import org.api.weather.config.AppConfig;
import org.api.weather.service.WeatherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Utility to find coolest hour tommorow in US by Zip 
 * Test data (US Zip)  : 85001, 94040, 11368
 *
 */
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		WeatherService service = ctx.getBean(WeatherService.class);
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"This Utility is used to find coolest hour tommorow in US by Zip, Internet is required for successful operation");
		System.out.println("Enter the Zip (Supports only one at a time) :");
		
		System.out.println("Result : " + service.findCoolestDayByZip(sc.next()));
		sc.close();
		ctx.close();

	}
}
