package com.kostasvr.geoNamesProject;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class BoundingBox implements Serializable  {

	private static final long serialVersionUID = -6815273859275969674L;
	
	String north	;
	String east	;
	String west	;
	String south	;
	

	public BoundingBox(String north, String east, String west, String south) {
		super();
		this.north = north;
		this.east = east;
		this.west = west;
		this.south = south;
	}

}
