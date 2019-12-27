package com.sandeep.PublicApiProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sandeep.PublicApiProject.controller.CoutnryController;

@SpringBootTest(classes = CoutnryController.class)
class PublicApiProjectApplicationTests {
	
	RestTemplate restTemplate = new RestTemplate();

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllCountries() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://restcountries.eu/rest/v2/all", HttpMethod.GET, entity, String.class);

		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	@Test
	public void getCountriesByName() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://restcountries.eu/rest/v2/name/IND", HttpMethod.GET, entity, String.class);

		assertEquals(200, responseEntity.getStatusCodeValue());
	}

}
