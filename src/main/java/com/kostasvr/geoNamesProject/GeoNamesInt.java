package com.kostasvr.geoNamesProject;

public interface GeoNamesInt {
	public BoundingBox getBoundingBox(String country);
	public PrimaryWeatherObservations getWeather(String country);
}
