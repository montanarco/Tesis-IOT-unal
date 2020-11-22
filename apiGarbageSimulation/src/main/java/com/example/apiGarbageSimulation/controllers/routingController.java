package com.example.apiGarbageSimulation.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apigarbagecollection.routing.RoutingReq;
import com.example.apiGarbageSimulation.entities.Routes;
import com.example.apiGarbageSimulation.services.IRoutingService;

@RestController
@RequestMapping("/api/routing")
public class routingController {

	@Autowired
	IRoutingService routingService;
	
	@RequestMapping(value = "/calculate/{strDate}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity mappingJsonResponse(@PathVariable String strDate) throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		int  resultado = routingService.RouteVehicles(date);
		switch (resultado) {
		case 1:
			return ResponseEntity.ok("{\"codigo\":\"201\",\"mensaje\":\"las rutas ya habian sido generadas\"}");
		case 2:
			return ResponseEntity.ok("{\"codigo\":\"200\",\"mensaje\":\"las rutas se generaron correctamente\"}");
		case 3:
			return ResponseEntity.ok("{\"codigo\":\"500\",\"mensaje\":\"se genero error en el servidor durante la generacion de las rutas\"}");

		default:
			break;
		}
		return ResponseEntity.ok("{\"codigo\":\"200\",\"mensaje\":\"las rutas se generaron correctamente\"}");
		
	}
	@RequestMapping(value = {"/vehicles", "/vehicles/{optionalDate}"}, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity getVehicles (@PathVariable Optional<String>   optionalDate) throws ParseException {
		Date date = null;
		 if (optionalDate.isPresent()) {
		        String strDate = optionalDate.get();
		        date =  new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		    } else {
		        date =  new Date();
		    }
		List<Routes> lstRoutes = routingService.getVehicleRouting(date);
		if (lstRoutes == null) {
			return ResponseEntity.ok("{\"codigo\":\"500\",\"mensaje\":\"se produjo un error inseperado consultando las rutas\"}");
			
		}if (lstRoutes.isEmpty()){
			return ResponseEntity.ok("{\"codigo\":\"200\",\"mensaje\":\"primero se deben generar las rutas segun la consulta de operacion diaria\"}");
		}else {
			return ResponseEntity.ok(lstRoutes);
		}
		
	}

}