package com.example.apiGarbageSimulation.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.apiGarbageSimulation.entities.Routes;

public interface RoutesRepository extends CrudRepository<Routes, Integer> {
	
	List<Routes> findByCreatedOnBetween(Timestamp fInicial, Timestamp fFinal);
}

