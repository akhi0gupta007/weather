package org.api.weather.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Context Config class 
 * @author akhilesh
 *
 */
@Configuration
@ComponentScan(basePackages="org.api.weather.service")
@PropertySource("classpath:app.properties")
public class AppConfig {

}
