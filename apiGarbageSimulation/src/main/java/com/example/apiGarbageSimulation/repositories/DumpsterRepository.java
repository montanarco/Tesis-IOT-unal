package com.example.apiGarbageSimulation.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.apiGarbageSimulation.entities.Dumpster;
import com.example.apiGarbageSimulation.entities.MeasureDumpter;



public interface DumpsterRepository extends CrudRepository<Dumpster, Integer> {
	
	Dumpster findByDeviceID(String devID);

	
}
