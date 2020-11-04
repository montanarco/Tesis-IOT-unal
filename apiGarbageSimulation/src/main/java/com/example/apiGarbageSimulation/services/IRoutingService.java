package com.example.apiGarbageSimulation.services;

import java.util.Date;

import com.apigarbagecollection.routing.RoutingReq;

public interface IRoutingService {
	
	RoutingReq generateContainersVehicles(Date date);

}
