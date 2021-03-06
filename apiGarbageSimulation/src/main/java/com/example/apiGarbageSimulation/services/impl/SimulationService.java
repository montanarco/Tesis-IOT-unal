package com.example.apiGarbageSimulation.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.apiGarbageSimulation.entities.Dumpster;
import com.example.apiGarbageSimulation.entities.DumpsterType;
import com.example.apiGarbageSimulation.entities.MeasureDumpter;
import com.example.apiGarbageSimulation.entities.PhysicalStateType;
import com.example.apiGarbageSimulation.helper.SimulationUtil;
import com.example.apiGarbageSimulation.repositories.DumpsterRepository;
import com.example.apiGarbageSimulation.repositories.MeasureDumpterRepository;
import com.example.apiGarbageSimulation.services.ISimulationService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import javassist.tools.Dump;

@Service
@Configurable
public class SimulationService implements ISimulationService {

    @Autowired
    DumpsterRepository dumpsterRepo;
    @Autowired
    MeasureDumpterRepository measureRepo;
    // SimulationUtil simulator;

    @Override
    public List<MeasureDumpter> generarNiveles(Integer idLocalidad, boolean filled, Date date) {
        // fetching the dumpster locations in dumpster repository
        // dumpstersList = (List<Dumpster>) dumpsterRepo.findByIdLocalidad(idLocalidad);
        List<Dumpster> dumpstersList = (List<Dumpster>) dumpsterRepo.findAll();
        if (dumpstersList == null || dumpstersList.isEmpty()) {
            dumpstersList = generateFakeDumpsters();
        }
        // generating levels acording 7 the reference distribution found in Austin
        // Texas
        SimulationUtil simulator = new SimulationUtil();
        int[] levels = simulator.generateFillement(dumpstersList.size(), filled);
        // the measurements are generate with the dumpster location and generated levels
        List<MeasureDumpter> mesureList = generateMeasures(dumpstersList, levels, date);
        // mesureList = persistMeasures(mesureList);
        return mesureList;

    }

    private List<Dumpster> generateFakeDumpsters() {
        int random = (int) ((Math.random() * ((0 - 30) + 1)) + 30);
        List<Dumpster> lstDumpster = new ArrayList<>();
        GeometryFactory gf = new GeometryFactory();
        Double y = -74.084464;
        Double x = 4.601037;
        Point point = gf.createPoint(new Coordinate(x, y));
        for (int i = 0; i < random; i++) {
            //Dumpster tempDumpster = new Dumpster(i, point, new DumpsterType(2), new PhysicalStateType(3), i + 10);
            //lstDumpster.add(tempDumpster);
        }
        return lstDumpster;
    }

    private List<MeasureDumpter> generateMeasures(List<Dumpster> dumpstersList, int[] levels, Date date) {
        int id = 0;
        List<MeasureDumpter> lstMeasureDump = new ArrayList<>();
        for (Dumpster dump : dumpstersList) {
            MeasureDumpter md = new MeasureDumpter( levels[id], date, dump);
            md.computePriority();
            lstMeasureDump.add(md);
            id++;
           
        }
        return lstMeasureDump;
    }

    @Override
    public List<Dumpster> fetchDumpsters() {
        List<Dumpster> r = (List<Dumpster>) dumpsterRepo.findAll();
        return r;
    }
    
    public List<MeasureDumpter> searchLastMeasures(){
    	return measureRepo.findLastMeasures();
    }

    public List<MeasureDumpter> generateLevelesDate(Integer idDistrict, Date date) {
        // buscar niveles del dia
        List<MeasureDumpter> lstLevelsByDate = measureRepo.findByMeasureDate(date);
        if (lstLevelsByDate != null && !lstLevelsByDate.isEmpty()) {
            return lstLevelsByDate;
        } else {
            lstLevelsByDate = generarNiveles(idDistrict, true, date);
            
            measureRepo.saveAll(lstLevelsByDate);
            return lstLevelsByDate;
        }
    }
    
    public Dumpster fetchDumpstersByDevID (String devID) {
		return dumpsterRepo.findByDeviceID(devID);
    }
    
    public MeasureDumpter persistDumpster (MeasureDumpter dumpsterMeasured) {
		return measureRepo.save(dumpsterMeasured);
    }

}
