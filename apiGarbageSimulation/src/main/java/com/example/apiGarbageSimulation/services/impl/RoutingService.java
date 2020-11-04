package com.example.apiGarbageSimulation.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.apigarbagecollection.routing.Job;
import com.apigarbagecollection.routing.RoutingReq;
import com.apigarbagecollection.routing.Vehicle;
import com.example.apiGarbageSimulation.Kmeans.Cluster;
import com.example.apiGarbageSimulation.Kmeans.KMeansResultado;
import com.example.apiGarbageSimulation.Kmeans.Punto;
import com.example.apiGarbageSimulation.constants.SimulationConstants;
import com.example.apiGarbageSimulation.services.IDailyOperationService;
import com.example.apiGarbageSimulation.services.IRoutingService;

@Service
@Configurable
public class RoutingService implements IRoutingService {
	
	@Autowired
	IDailyOperationService operationService;

	public RoutingReq generateContainersVehicles(Date date) {
		KMeansResultado KMresult = operationService.clusterize(date); 
		List<Job> jobs = new ArrayList<Job>();
		int contTareas = 0;
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		int contVehiculos = 0;
		for(Cluster cluster : KMresult.getClusters()) {
			for (Punto punto: cluster.getPuntos()) {
				contTareas++;
				Job tarea = new Job();
				tarea.setId(contTareas);
				tarea.setService(300);
				Integer[] amount = new Integer[1];
				amount[0] = punto.getVolume();
				tarea.setAmount(amount);
				Float[] location = new Float[2];
				location[0] = punto.getY();
				location[1] = punto.getX();
				tarea.setLocation(location);

				jobs.add(tarea);
			}
			contVehiculos ++;
			Vehicle camion = new Vehicle();
			camion.setId(contVehiculos);
			camion.setProfile("driving-car");
			Integer [] capacity = new Integer [1];
			capacity[0] = SimulationConstants.TRUCK_CAPACITY;
			camion.setCapacity(capacity);
			
			Float [] start = new Float [2];
			start[0] = cluster.getCentroide().getY();
			start[1] = cluster.getCentroide().getX();
			camion.setStart(start);
			
			Float [] end = new Float [2];
			camion.setEnd(end);
			
			
			vehicles.add(camion);
		}
		
		RoutingReq routing = new RoutingReq();
		routing.setJobs(jobs);
		routing.setVehicles(vehicles);
		return routing;
	}

}
