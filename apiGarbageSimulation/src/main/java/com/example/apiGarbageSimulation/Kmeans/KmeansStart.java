package com.example.apiGarbageSimulation.Kmeans;

import com.example.apiGarbageSimulation.entities.DailyOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KmeansStart {

    public static KMeansResultado getClouster(List<DailyOperation> operations, int truckNumber) {

        List<Punto> puntosPendiente = new ArrayList<>();
        List<Punto> puntos = operations.stream().map(i -> new Punto(i)).collect(Collectors.toList());
        KMeans kmeans = new KMeans();
        Map<Integer, KMeansResultado> resultados = new HashMap<>();
        int k;
        for (k = 1; k <= truckNumber; k++) {
            KMeansResultado resultado = kmeans.calcular(puntos, k);
            puntosPendiente.add(new Punto((float) k, resultado.getOfv().floatValue()));
            resultados.put(k + 1, resultado);

            /* System.out.println("------- Con k=" + k + " ofv=" + resultado.getOfv() + "-------");
            int i = 0;
            for (Cluster cluster : resultado.getClusters()) {
                i++;
                System.out.println("\t-- Cluster " + i + " --");
                cluster.getPuntos().forEach((punto) -> {
                    System.out.println(punto.toString() );
                });
                System.out.println("");
                System.out.println(cluster.getCentroide().toString());
                
            }*/
        }
        Punto p1 = null, p2 = null;
        Pendiente pendienteOptima = new Pendiente();
        Pendiente pendienteAux = new Pendiente();
        pendienteAux.setPendiente(Float.MAX_VALUE);
        for (int i = 0; i < puntosPendiente.size(); i++) {
            System.out.println("(" + puntosPendiente.get(i).getData()[0] + " , " + puntosPendiente.get(i).getData()[1] + ")");
            if (i == 0) {
                p1 = puntosPendiente.get(i);
            } else {
                p2 = puntosPendiente.get(i);
                float pendiente = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
                System.out.println("pendiente->\t" + pendiente);
                if (Math.pow(pendienteAux.getPendiente(), 2) > Math.pow(pendiente, 2)) {
                    pendienteAux.setPendiente(pendiente);
                    pendienteAux.setK(i + 1);
                }
                if ((pendiente > -1 && pendiente < 1)) {
                    //System.out.println("************candidato a optimo");
                    if (pendienteOptima.getPendiente() == 0) {
                        pendienteOptima.setPendiente(pendiente);
                        pendienteOptima.setK(i + 1);
                    } else {
                        if ((pendiente < pendienteOptima.getPendiente())) {
                            break;
                        } else {
                            pendienteOptima.setPendiente(pendiente);
                            pendienteOptima.setK(i + 1);
                        }
                    }

                }
                p1 = p2;
            }

        }
        if (pendienteOptima.getPendiente() == 0) {
            pendienteOptima = pendienteAux;
        }
        System.out.println("pendiente optimia->" + pendienteOptima.getK() + "->\t" + pendienteOptima.getPendiente());
        return resultados.get(pendienteOptima.getK());
    }

}
