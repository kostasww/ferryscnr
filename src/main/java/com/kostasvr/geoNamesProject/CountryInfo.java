package com.kostasvr.geoNamesProject;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class CountryInfo extends BoundingBox implements Serializable {

	private static final long serialVersionUID = 1L;
	String continent;
	String capital	;
	String languages	;
	int geonameId	;
	String	isoAlpha3 ; 
	String fipsCode	;
	String population	;
	String isoNumeric	;
	String areaInSqKm	;
	String countryCode	;
	String countryName	;
	String continentName	;
	String currencyCode	;
	
	
}
