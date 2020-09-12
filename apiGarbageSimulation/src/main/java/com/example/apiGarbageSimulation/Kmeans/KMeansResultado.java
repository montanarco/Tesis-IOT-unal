package com.example.apiGarbageSimulation.Kmeans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class KMeansResultado {
    private List<Cluster> clusters = new ArrayList<Cluster>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double ofv;

    public KMeansResultado(List<Cluster> clusters, Double ofv) {
	super();
	this.ofv = ofv;
	this.clusters = clusters;
    }

    public List<Cluster> getClusters() {
	return clusters;
    }

    public Double getOfv() {
	return ofv;
    }
}
