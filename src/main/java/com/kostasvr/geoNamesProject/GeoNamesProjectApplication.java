package com.kostasvr.geoNamesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class GeoNamesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoNamesProjectApplication.class, args);
	}

}

