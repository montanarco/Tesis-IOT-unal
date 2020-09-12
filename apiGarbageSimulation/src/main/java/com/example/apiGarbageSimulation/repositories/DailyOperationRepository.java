package com.example.apiGarbageSimulation.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.apiGarbageSimulation.entities.DailyOperation;
import java.util.Date;

public interface DailyOperationRepository extends CrudRepository<DailyOperation, Integer> {

    List<DailyOperation> findByDateAndIdPriority(Date date, Integer id);

    Long countByDate(Date date);

}
