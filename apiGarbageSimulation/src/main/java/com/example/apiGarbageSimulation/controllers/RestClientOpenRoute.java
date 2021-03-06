package com.example.apiGarbageSimulation.controllers;


import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apigarbagecollection.routing.RoutingReq;
import com.example.apiGarbageSimulation.constants.ResponseApiTest;
import com.example.apiGarbageSimulation.entities.RoutingResponse;

public class RestClientOpenRoute {
	
	public static final String ROUTING_API = "https://api.openrouteservice.org/optimization";
	
	static RestTemplate restTemp = new RestTemplate();
	
	public static RoutingResponse callGetRouting (String jsonReq) {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> lstMT= new ArrayList<MediaType>();
		lstMT.add(MediaType.APPLICATION_JSON);
		headers.setAccept(lstMT);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", ResponseApiTest.BEARER_KEY);
		HttpEntity<String> request = new HttpEntity<String>(jsonReq,headers);
		
		System.out.println(request.getBody());
		ResponseEntity<RoutingResponse> response =  restTemp.postForEntity(ROUTING_API, request, RoutingResponse.class);
		
		System.out.println(response.getBody());
		return response.getBody();
		
	}

}
