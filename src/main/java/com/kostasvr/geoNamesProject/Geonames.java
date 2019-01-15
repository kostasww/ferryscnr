package com.kostasvr.geoNamesProject;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter @NoArgsConstructor
public class Geonames {

	public List<CountryInfo> geonames;

	public Geonames(List<CountryInfo> inf) {
		super();
		this.geonames = inf;
	}

	
}
