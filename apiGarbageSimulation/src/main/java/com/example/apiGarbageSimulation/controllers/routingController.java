package com.example.apiGarbageSimulation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apigarbagecollection.routing.RoutingReq;
import com.example.apiGarbageSimulation.services.IRoutingService;

@RestController
@RequestMapping("/api/routing")
public class routingController {

	@Autowired
	IRoutingService routingService;
	
	@RequestMapping(value = "/calculate/{strDate}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity mappingJsonResponse(@PathVariable String strDate) throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		routingService.RouteVehicles(date);
		return ResponseEntity.ok("{\"codigo\":\"200\",\"mensaje\":\"las rutas se generaron correctamente\"}");
	}

}