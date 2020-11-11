package com.example.apiGarbageSimulation.services.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.example.apiGarbageSimulation.constants.ResponseApiTest;
import com.example.apiGarbageSimulation.constants.SimulationConstants;
import com.example.apiGarbageSimulation.controllers.RestClientOpenRoute;
import com.example.apiGarbageSimulation.entities.Routes;
import com.example.apiGarbageSimulation.entities.RoutingResponse;
import com.example.apiGarbageSimulation.entities.Step;
import com.example.apiGarbageSimulation.repositories.RoutesRepository;
import com.example.apiGarbageSimulation.repositories.StepRepository;
import com.example.apiGarbageSimulation.services.IDailyOperationService;
import com.example.apiGarbageSimulation.services.IRoutingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Configurable
public class RoutingService implements IRoutingService {

	@Autowired
	IDailyOperationService operationService;
	@Autowired
	RoutesRepository routesRepo;
	@Autowired
	StepRepository stepRepo;

	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void RouteVehicles(Date date) {
		List<RoutingReq> lsrRoutingRequest = generateContainersVehicles(date);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		String fecha = DATE_TIME_FORMAT.format(new Date());
		try {
			for (RoutingReq routeReq : lsrRoutingRequest) {
				// hacer la peticion
				json = mapper.writeValueAsString(routeReq);
				RoutingResponse resultReq = RestClientOpenRoute.callGetRouting(json);
				
				// completar campos Rutas
				for (Routes route : resultReq.getRoutes()) {
					route.setCreated_on(new Timestamp(DATE_TIME_FORMAT.parse(fecha).getTime()));
					route.validateID();
				}
				
				// persistir las rutas generadas
				List<Routes> lstRoute = (List<Routes>) routesRepo.saveAll(resultReq.getRoutes());
				
				for(Step parada: resultReq.getRoutes().get(0).getSteps()) {
					parada.setIdRoute(lstRoute.get(0));
					stepRepo.save(parada);
				}
				
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String callApiRoute(RoutingReq routeReq) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RoutingReq> generateContainersVehicles(Date date) {
		List<RoutingReq> lstRouteReq = new ArrayList<RoutingReq>(); // este es el objeto que se va a retornar
		KMeansResultado KMresult = operationService.clusterize(date);
		int contVehiculos = 0;

		/*******************
		 * seccion de prueba con 3 clusters unicamente
		 ***************/
		List<Cluster> lstAuxCluster = new ArrayList<Cluster>();
		lstAuxCluster.add(KMresult.getClusters().get(0));
		lstAuxCluster.add(KMresult.getClusters().get(1));
		lstAuxCluster.add(KMresult.getClusters().get(2));
		/*******************
		 * seccion de prueba con 3 clusters unicamente
		 ***************/
		for (Cluster cluster : lstAuxCluster) {
			int contTareas = 0;
			List<Job> jobs = new ArrayList<Job>();
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			for (Punto punto : cluster.getPuntos()) {
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
				if (contTareas < 50) {
					jobs.add(tarea);
				}
			}
			contVehiculos++;
			Vehicle camion = new Vehicle();
			camion.setId(contVehiculos);
			camion.setProfile("driving-car");
			Integer[] capacity = new Integer[1];
			capacity[0] = SimulationConstants.TRUCK_CAPACITY;
			camion.setCapacity(capacity);

			Float[] start = new Float[2];
			start[0] = cluster.getCentroide().getY();
			start[1] = cluster.getCentroide().getX();
			camion.setStart(start);

			vehicles.add(camion);
			RoutingReq routing = new RoutingReq();
			routing.setJobs(jobs);
			routing.setVehicles(vehicles);

			lstRouteReq.add(routing);

		}

		return lstRouteReq;
	}

}
