package com.kostasvr.geoNamesProject;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor 
public class PrimaryWeatherInfo implements Serializable{
	
	private static final long serialVersionUID = 4582819655229835185L;
	String stationName	;
	String temperature	;
	
	
	
	public PrimaryWeatherInfo(String stationName, String temperature) {
		super();
		this.stationName = stationName;
		this.temperature = temperature;
	}

	  
}
