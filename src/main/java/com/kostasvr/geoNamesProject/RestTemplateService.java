package com.kostasvr.geoNamesProject;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateService {

	RestTemplate restTemplate ;

	public  RestTemplateService(RestTemplateBuilder builder) {
	    this.restTemplate =  builder.build();
	}
	
}
