package com.kostasvr.geoNamesProject;

import java.io.Serializable;
import java.util.List;



public class WeatherObservations implements Serializable {

	private static final long serialVersionUID = 2385178881211740112L;
	private List<WeatherInfo> weatherObservations;
	public List<WeatherInfo> getWeatherObservations() {
		return weatherObservations;
	}
	public void setWeatherObservations(List<WeatherInfo> weatherObservations) {
		this.weatherObservations = weatherObservations;
	}


}