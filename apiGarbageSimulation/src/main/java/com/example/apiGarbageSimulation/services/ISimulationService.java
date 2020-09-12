package com.example.apiGarbageSimulation.services;

import java.util.Date;
import java.util.List;

import com.example.apiGarbageSimulation.entities.Dumpster;
import com.example.apiGarbageSimulation.entities.MeasureDumpter;

public interface ISimulationService {
	
	List<Dumpster> fetchDumpsters();
	
	Dumpster fetchDumpstersByDevID(String devId);

	List<MeasureDumpter> generateLevelesDate(Integer idDistrict, Date date);

	List<MeasureDumpter> generarNiveles(Integer idLocalidad, boolean filled, Date date);
	
	MeasureDumpter persistDumpster (MeasureDumpter dumpsterMeasured);

	List<MeasureDumpter> searchLastMeasures();

}
