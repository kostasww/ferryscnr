package com.kostasvr.geoNamesProject;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class WeatherInfo extends PrimaryWeatherInfo implements Serializable{
	
	private static final long serialVersionUID = -4856165698347843570L;
	
	int lng;
	String observation	;
	String ICAO	;
	String clouds	;
	String dewPoint	;
	String datetime	;
	int humidity	;
	String weatherCondition	;
	String windDirection	;
	String windSpeed	;
	String lat	;
	
	
}
