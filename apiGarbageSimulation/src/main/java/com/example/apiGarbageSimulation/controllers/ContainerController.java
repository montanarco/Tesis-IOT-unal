package com.example.apiGarbageSimulation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thethingsnetwork.data.common.messages.DataMessage;
import org.thethingsnetwork.data.common.messages.UplinkMessage;

import com.example.apiGarbageSimulation.constants.SimulationConstants;
import com.example.apiGarbageSimulation.entities.Dumpster;
import com.example.apiGarbageSimulation.entities.MeasureDumpter;
import com.example.apiGarbageSimulation.services.ISimulationService;

@RestController
@RequestMapping("/api/containers")
public class ContainerController {
	@Autowired
	ISimulationService simulationServices;

	@GetMapping("/hola")
	public String saludar(String nombre) {
		String hola = "hola";
		return nombre == null ? hola : hola + nombre;
	}

	@GetMapping("/simulateContainers")
	public ResponseEntity<List> simulateContainers(String nombre) {
		List<Dumpster> lstDumpster = simulationServices.fetchDumpsters();
		return ResponseEntity.ok(lstDumpster);
	}

	@RequestMapping(value = "/generateLevels/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List> simulateNiveles(Integer idDistrict) {
		if (idDistrict == null) {
			idDistrict = 19;
		}
		List<MeasureDumpter> lstMeasures = simulationServices.generarNiveles(idDistrict, false, new Date());
		return ResponseEntity.ok(lstMeasures);
	}

	@RequestMapping(value = "/generateLevels/{strDate}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List> simulateNiveles(Integer idDistrict, @PathVariable String strDate)
	throws ParseException {
		idDistrict = idDistrict != null ? idDistrict : 19;
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		List<MeasureDumpter> lstMeasures = simulationServices.generateLevelesDate(idDistrict, date);
		return ResponseEntity.ok(lstMeasures);
	}
	
	@RequestMapping(value = "/fetchLastMeasures/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List> fetchMeasuresLastXHours (){
		List<MeasureDumpter> lstMeasures = simulationServices.searchLastMeasures();
		return ResponseEntity.ok(lstMeasures);
	}
	
	public void saveMeasure (String devId, DataMessage data) {
		Dumpster dumpster = simulationServices.fetchDumpstersByDevID(devId);
		Integer distance = (Integer) ((UplinkMessage) data).getPayloadFields().get("distance");
		Integer dumpsterHeight = dumpster.getIdDumpsterType() == 1? SimulationConstants.RECICLABLE_DUMPSTER_HEIGHT :  SimulationConstants.WASTE_DUMPSTER_HEIGHT;
		Integer dumpsterFilling = dumpsterHeight - distance;
		Integer level = 0;
		if (dumpsterFilling > 0) {
			level = (int) Math.ceil(dumpsterHeight/dumpsterFilling);
		}
		MeasureDumpter measure = new MeasureDumpter(level, new Date(), dumpster);
		measure.computePriority();
		
		simulationServices.persistDumpster(measure);
	}
	
	

}
