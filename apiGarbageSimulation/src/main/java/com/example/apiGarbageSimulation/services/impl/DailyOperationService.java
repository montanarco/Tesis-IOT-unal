package com.example.apiGarbageSimulation.services.impl;

import com.example.apiGarbageSimulation.Kmeans.KMeansResultado;
import com.example.apiGarbageSimulation.Kmeans.KmeansStart;
import com.example.apiGarbageSimulation.constants.SimulationConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.apiGarbageSimulation.entities.DailyOperation;
import com.example.apiGarbageSimulation.entities.MeasureDumpter;
import com.example.apiGarbageSimulation.repositories.DailyOperationRepository;
import com.example.apiGarbageSimulation.repositories.MeasureDumpterRepository;
import com.example.apiGarbageSimulation.services.IDailyOperationService;

@Service
@Configurable
public class DailyOperationService implements IDailyOperationService {

    @Autowired
    MeasureDumpterRepository mesureDumpRepo;

    @Autowired
    DailyOperationRepository dOperationRepo;

    public static final Integer STANDARTTRUCKCAPACITY = 37500;

    public boolean createDailyOperation(Date date) {

        List<DailyOperation> lstDailyOperation = dOperationRepo.findByDateAndIdPriority(date, 1);
        lstDailyOperation.addAll(dOperationRepo.findByDateAndIdPriority(date, 4));
        if (lstDailyOperation == null || lstDailyOperation.isEmpty()) {
            try {
                generateOperation(date);
                return true;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                return false;
            }
        }
        return true;
    }

    private void generateOperation(Date date) throws Exception {
        // recuperar los niveles de llenado por fecha
        List<MeasureDumpter> lstLevelsDate = mesureDumpRepo.findByMeasureDate(date);

        if (lstLevelsDate == null || lstLevelsDate.isEmpty()) {
            throw new Exception("no fullfil level data to generate operation");
        }

        //ordenar la lista por via
        lstLevelsDate = lstLevelsDate.stream().sorted((o1, o2) -> o1.getIdDumpster().getVia().getIdvia()
                .compareTo(o2.getIdDumpster().getVia().getIdvia())).collect(Collectors.toList());

        // calcular la prioridad de cada calle
        List<DailyOperation> lstDailyOperation = calculateStreetPriority(lstLevelsDate,date);
        // persistir DailyOperation
        dOperationRepo.saveAll(lstDailyOperation);

    }

    private List<DailyOperation> calculateStreetPriority(List<MeasureDumpter> lstLevelsDate,Date date) {
        List<DailyOperation> lstStreetPriority = new ArrayList<>();
        Integer idCurrentStreet, strVolume, dumpP1, dumpP2, dumpP3, dumpP4, capacity;
        strVolume = dumpP1 = dumpP2 = dumpP3 = dumpP4 = 0;
        float realVolume;
        Integer lastElementId = lstLevelsDate.get(lstLevelsDate.size() - 1).getId();

        MeasureDumpter previousStreet = lstLevelsDate.get(0);
        for (MeasureDumpter md : lstLevelsDate) {
            if (!previousStreet.getIdDumpster().getVia().getIdvia().equals(md.getIdDumpster().getVia().getIdvia())
                    || md.getId().equals(lastElementId)) {
                idCurrentStreet = md.getIdDumpster().getVia().getIdvia();
                if (md.getIdDumpster().getIdDumpsterType()==1) {
                	capacity = SimulationConstants.WASTE_DUMPSTER_CAPACITY;
                }else {
                	capacity = SimulationConstants.RECICLABLE_DUMPSTER_CAPACITY;
                }
                realVolume = (strVolume * capacity)/100; // total percentage in each dumpster times dumpster capacity
                strVolume = (int) Math.floor(new Double(realVolume));
                DailyOperation dOperation = new DailyOperation(strVolume, date,
                        previousStreet.getIdDumpster().getVia());
                previousStreet = md;
                dOperation.setIdPriority(calculatePriorityLevel(dumpP1, dumpP2, dumpP3, dumpP4));
                lstStreetPriority.add(dOperation);
                strVolume = dumpP1 = dumpP2 = dumpP3 = dumpP4 = 0;
            }
            strVolume = +md.getLevel();
            switch (md.getPriority().getPriorityName()) {
                case "Full":
                    dumpP1++;
                    break;
                case "High":
                    dumpP2++;
                    break;
                case "Medium":
                    dumpP3++;
                    break;
                case "Low":
                    dumpP4++;
                    break;

                default:
                    break;
            }
        }
        return lstStreetPriority;
    }

    private Integer calculatePriorityLevel(int dumpP1, int dumpP2, int dumpP3, int dumpP4) {
        if (dumpP1 > 0) {
            return 4; // Full
        } else if (dumpP2 > 0) {
            return 1; // High
        } else if (dumpP3 > 0) {
            return 2; // Medium
        } else if (dumpP4 > 0) {
            return 3;// Low
        } else {
            return 5; // Empty
        }
    }

    public KMeansResultado clusterize(Date date) {
        List<DailyOperation> lstDailyOperation = dOperationRepo.findByDateAndIdPriority(date, 1);
        lstDailyOperation.addAll(dOperationRepo.findByDateAndIdPriority(date, 4));

        int totalDayVolume = lstDailyOperation.stream().mapToInt(d -> d.getVolume()).sum();
        int numTrucks = (totalDayVolume / STANDARTTRUCKCAPACITY);
        KMeansResultado kresult = KmeansStart.getSimpleClouster(lstDailyOperation, numTrucks);
        return kresult;
    }

    @Override
    public List<DailyOperation> findByDateAndByIdPriority(Date date, Integer priority) {
        return dOperationRepo.findByDateAndIdPriority(date, priority);
    }

    @Override
    public Long countByDate(Date date) {
       return dOperationRepo.countByDate(date);
    }

}
