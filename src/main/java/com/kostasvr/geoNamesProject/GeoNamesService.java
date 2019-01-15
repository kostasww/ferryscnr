package com.kostasvr.geoNamesProject;
import org.apache.commons.codec.binary.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;



@Component(value="a")
public class GeoNamesService implements GeoNamesInt {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
    private RestTemplateService rts;
    @Autowired 
    private GeoNamesUtils geo;
    @Value("${credentials.username}")
	private String username;
    @Value("${credentials.password}")
	private String pass;
	
	public BoundingBox getBoundingBox(String country) {
		
        LOG.info("srv: Getting boundingbox for country {}.", country);

        Geonames res = rts.restTemplate.getForObject("http://api.geonames.org/countryInfoJSON?country="+country+"&username=ferryscanner", Geonames.class);
        return (geo.countryInfo2BB(res.geonames.get(0)));
    }
	


	
	
	 public PrimaryWeatherObservations getWeather(String country) {
		
		 
		String plainCreds = username+":"+pass;
		LOG.info("srv: Getting weather for country {}.", country);	
		 
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
	    String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		 
		ResponseEntity<BoundingBox> res = rts.restTemplate.exchange("http://localhost:8090/getBoundingBox/"+country, HttpMethod.GET,request,BoundingBox.class);
        BoundingBox c = res.getBody();
		String a = "http://api.geonames.org/weatherJSON?north="+c.north+"&south="+c.south+"&east="+c.east+"&west="+c.west+"&username=ferryscanner";
        WeatherObservations quote = rts.restTemplate.getForObject(a, WeatherObservations.class);
        List<PrimaryWeatherInfo> lust = quote.getWeatherObservations().stream().map(geo:: weatherInfo2BB ).collect(Collectors.toList());
        return (new PrimaryWeatherObservations(lust)) ;
	       
			
	        
	 }
	
	
}
