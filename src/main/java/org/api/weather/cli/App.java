package org.api.weather.cli;

import org.api.weather.config.AppConfig;
import org.api.weather.service.WeatherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(AppConfig.class);
    	ctx.refresh();
    	
    	WeatherService service = ctx.getBean(WeatherService.class);
    	System.out.println(service.findCoolestDayByZip(null));
    	
    	
    }
}
