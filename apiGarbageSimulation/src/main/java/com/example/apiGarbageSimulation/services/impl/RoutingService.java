package com.example.apiGarbageSimulation.services.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	@Autowired
	private EntityManager em;

	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final SimpleDateFormat DATE_SIMPLE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public int RouteVehicles(Date date) {
		try {
			String fecha = DATE_TIME_FORMAT.format(date);
			Timestamp fechTSmp = new Timestamp(DATE_SIMPLE_FORMAT.parse(fecha).getTime());
			Timestamp fechFinalTSmp = getFinalDate(date);

			List<Routes> lstRoutes = searchByDate(fechTSmp, fechFinalTSmp);
			if (!lstRoutes.isEmpty()) {
				return 1; // las rutas ya se habian generado
			}

			List<RoutingReq> lsrRoutingRequest = generateContainersVehicles(date);
			ObjectMapper mapper = new ObjectMapper();
			String json = null;

			for (RoutingReq routeReq : lsrRoutingRequest) {
				RoutingResponse resultReq = null; // se limpia la variable para que no queden datos de laoperacion
													// anterior
				Routes routeDB = null;
				// hacer la peticion
				json = mapper.writeValueAsString(routeReq);
				resultReq = RestClientOpenRoute.callGetRouting(json);

				// completar campos Rutas
				for (Routes route : resultReq.getRoutes()) {
					route.setCreatedOn(new Timestamp(DATE_TIME_FORMAT.parse(fecha).getTime()));
					route.validateID();
				}

				// persistir las rutas generadas
				routeDB = routesRepo.save(resultReq.getRoutes().get(0));

				for (Step parada : resultReq.getRoutes().get(0).getSteps()) {
					parada.setIdRoute(routeDB);
				}
				stepRepo.saveAll(resultReq.getRoutes().get(0).getSteps());
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3; // ocurrio un error durante la generacion de rutas
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
		return 2; // las rutas fueron creadas correctamente
	}

	private List<Routes> searchByDate(Timestamp fechTSmp, Timestamp fechFinalTSmp) {
		Query query = em.createNamedQuery("Routes.findByCreatedOnBetween");
		query.setParameter(1, fechTSmp);
		query.setParameter(2, fechFinalTSmp);
		List<Routes> lstRoutes = query.getResultList();
		return lstRoutes;
	}

	private Timestamp getFinalDate(Date date) {
		try {
			Date fechaFinal = date;
			Calendar c = Calendar.getInstance();
			c.setTime(fechaFinal);
			c.add(Calendar.DATE, 1);
			fechaFinal = c.getTime();
			String strFechaFin = DATE_SIMPLE_FORMAT.format(fechaFinal);
			Timestamp fFinal = null;

			fFinal = new Timestamp(DATE_SIMPLE_FORMAT.parse(strFechaFin).getTime());
			return fFinal;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<RoutingReq> generateContainersVehicles(Date date) {
		List<RoutingReq> lstRouteReq = new ArrayList<RoutingReq>(); // este es el objeto que se va a retornar
		KMeansResultado KMresult = operationService.clusterize(date);
		int contVehiculos = 0;
		List<Job> jobs;
		List<Vehicle> vehicles;
		for (Cluster cluster : KMresult.getClusters()) {
			int contTareas = 0;
			jobs = new ArrayList<Job>();
			if (!cluster.getPuntos().isEmpty()) { // se generan peticiones solo para los clusters que tienen calles
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

					if (contTareas <= 50) { // se restringe a que cada ruta tenga maximo 50 paradas
						jobs.add(tarea);

					} else {
						contVehiculos++;
						Vehicle camion = CrearCamion(contVehiculos);

						Float[] start = new Float[2];
						start[0] = cluster.getCentroide().getY();
						start[1] = cluster.getCentroide().getX();
						camion.setStart(start);
						
						vehicles = new ArrayList<Vehicle>();
						vehicles.add(camion);
						
						RoutingReq routing = new RoutingReq();
						routing.setJobs(jobs);
						routing.setVehicles(vehicles);

						lstRouteReq.add(routing);
						jobs = new ArrayList<Job>();
						contTareas = 0;
					}
				}
				if (!jobs.isEmpty()) {
					contVehiculos++;
					Vehicle camion = CrearCamion(contVehiculos);

					Float[] start = new Float[2];
					start[0] = cluster.getCentroide().getY();
					start[1] = cluster.getCentroide().getX();
					camion.setStart(start);
					
					vehicles = new ArrayList<Vehicle>();
					vehicles.add(camion);
					RoutingReq routing = new RoutingReq();
					routing.setJobs(jobs);
					routing.setVehicles(vehicles);

					lstRouteReq.add(routing);
				}
			}
		}

		return lstRouteReq;
	}

	private Vehicle CrearCamion(int contVehiculos) {
		Vehicle camion = new Vehicle();
		camion.setId(contVehiculos);
		camion.setProfile("driving-car");
		Integer[] capacity = new Integer[1];
		capacity[0] = SimulationConstants.TRUCK_CAPACITY;
		camion.setCapacity(capacity);
		return camion;
	}
	
	public List<Routes> getVehicleRouting(Date date){
		try {
			String fecha = DATE_TIME_FORMAT.format(date);
			Timestamp fechTSmp;
			fechTSmp = new Timestamp(DATE_SIMPLE_FORMAT.parse(fecha).getTime());
			Timestamp fechFinalTSmp = getFinalDate(date);
			return routesRepo.findByCreatedOnBetween(fechTSmp, fechFinalTSmp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
