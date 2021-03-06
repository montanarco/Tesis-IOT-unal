package com.example.apiGarbageSimulation.services;

import java.util.Date;
import java.util.List;

import com.apigarbagecollection.routing.RoutingReq;
import com.example.apiGarbageSimulation.Kmeans.KMeansResultado;
import com.example.apiGarbageSimulation.entities.DailyOperation;

public interface IDailyOperationService {

    boolean createDailyOperation(Date date);

    List<DailyOperation> findByDateAndByIdPriority(Date date, Integer priority);

    Long countByDate(Date date);

    KMeansResultado clusterize(Date date);
}
