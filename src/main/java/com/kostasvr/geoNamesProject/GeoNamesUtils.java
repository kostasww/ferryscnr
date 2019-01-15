package com.kostasvr.geoNamesProject;

import org.springframework.stereotype.Component;

@Component
public class GeoNamesUtils {

	
	
	BoundingBox countryInfo2BB(CountryInfo c) {
		BoundingBox bb = new BoundingBox();
		bb.north = c.north;
		bb.south= c.south;
		bb.east= c.east;
		bb.west = c.west;
		return bb;
		
	}
	
	PrimaryWeatherInfo weatherInfo2BB(WeatherInfo c) {
		PrimaryWeatherInfo bb = new PrimaryWeatherInfo();
		bb.stationName = c.stationName;
		bb.temperature= c.temperature;;
		return bb;
		
	}
	
	
}
