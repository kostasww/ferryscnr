package com.kostasvr.geoNamesProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeonamesRestController {

	    private final Logger LOG = LoggerFactory.getLogger(getClass());
	    
	    @Autowired 
	    @Qualifier("a")
	    private GeoNamesInt  gs;
	    
 
	    @Cacheable(value = "boundingBox", key = "#country")
	    @RequestMapping(value = "getBoundingBox/{country}", method = RequestMethod.GET)
	    public BoundingBox getBoundingBox(@PathVariable String country) {
	    	LOG.info("REST: Getting boundingbox for country {}.", country);
	        return gs.getBoundingBox(country);
	    }
	    
	    @Cacheable(value = "weather", key = "#country")
	    @RequestMapping(value = "getWeather/{country}", method = RequestMethod.GET)
	    public PrimaryWeatherObservations getWeather(@PathVariable String country) {
	        LOG.info("REST: Getting weather for country {}.", country);
	        return gs.getWeather(country);
	    }
	    
	}
	

