package com.sandeep.PublicApiProject.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CoutnryController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value = {"/countries"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCountries() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("https://restcountries.eu/rest/v2/all", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@GetMapping(value= {"/countries/{name}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCountryByName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String url = "https://restcountries.eu/rest/v2/name/" + name;
		return restTemplate.exchange(url,HttpMethod.GET, entity, String.class).getBody();
	}

}
