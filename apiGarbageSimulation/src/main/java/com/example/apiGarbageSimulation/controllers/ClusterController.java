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

import com.example.apiGarbageSimulation.services.IDailyOperationService;

@RestController
@RequestMapping("/api/cluster")
public class ClusterController {
	
	@Autowired
	IDailyOperationService dOperationService;
	
	@RequestMapping(value = "/streets/{strDate}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity clusterStreets(@PathVariable String strDate)
	throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		Object kmeansResult = dOperationService.clusterize(date);
		return ResponseEntity.ok(kmeansResult);
	}

}
