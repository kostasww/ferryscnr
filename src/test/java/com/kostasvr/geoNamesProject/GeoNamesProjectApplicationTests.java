package com.kostasvr.geoNamesProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;




@RunWith(SpringRunner.class)
@WebMvcTest(value = GeonamesRestController.class, secure = false)
public class GeoNamesProjectApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	@Qualifier("a")
	private GeoNamesInt srv;
	
	BoundingBox bb = new BoundingBox("55.0583836008072","15.0418156516163","5.8663152683722","47.2701236047002");
	PrimaryWeatherObservations cc = new PrimaryWeatherObservations();
	PrimaryWeatherInfo ww = new PrimaryWeatherInfo("Zurich-Kloten","2");

	List<PrimaryWeatherInfo> listStrings = new ArrayList<PrimaryWeatherInfo>();
	
	
	@Test
	public void retrieveBoundingBox()  throws Exception{
		
		Mockito.when(
				srv.getBoundingBox(Mockito.anyString())).thenReturn(bb);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getBoundingBox/DE").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(result.getResponse().getContentAsString(),"{\"north\":\"55.0583836008072\",\"east\":\"15.0418156516163\",\"west\":\"5.8663152683722\",\"south\":\"47.2701236047002\"}");
		
	}
	
	
	@Test
	public void retrieveWeather()  throws Exception{
		this.listStrings.add(ww);
		this.cc.setWeatherObservations(listStrings);
		Mockito.when(
				srv.getWeather(Mockito.anyString())).thenReturn(cc);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getWeather/DE").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(result.getResponse().getContentAsString(),"{\"weatherObservations\":[{\"stationName\":\"Zurich-Kloten\",\"temperature\":\"2\"}]}");
		
		
	}
	
	
	
	
   
}

