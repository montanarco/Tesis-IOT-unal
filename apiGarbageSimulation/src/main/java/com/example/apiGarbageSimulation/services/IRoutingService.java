package com.example.apiGarbageSimulation.services;

import java.util.Date;
import java.util.List;

import com.example.apiGarbageSimulation.entities.Routes;
import com.example.apiGarbageSimulation.entities.RoutingResponse;

public interface IRoutingService {
	
	int RouteVehicles (Date date);

	List<Routes> getVehicleRouting(Date date);

}
