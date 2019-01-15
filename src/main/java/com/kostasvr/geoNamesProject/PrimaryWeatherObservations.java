package com.kostasvr.geoNamesProject;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class PrimaryWeatherObservations implements Serializable {

	private static final long serialVersionUID = 2385178881211740112L;
	private List<PrimaryWeatherInfo> weatherObservations;

    public PrimaryWeatherObservations() {
    }

    public PrimaryWeatherObservations(List<PrimaryWeatherInfo> primaryWeatherObs) {
        this.weatherObservations= primaryWeatherObs;
    }

	public List<PrimaryWeatherInfo> getWeatherObservations() {
		return weatherObservations;
	}

	public void setWeatherObservations(List<PrimaryWeatherInfo> weatherObservations) {
		this.weatherObservations = weatherObservations;
	}



	
  
}
