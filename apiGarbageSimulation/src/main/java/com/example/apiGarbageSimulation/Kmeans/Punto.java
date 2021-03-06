package com.example.apiGarbageSimulation.Kmeans;

import com.example.apiGarbageSimulation.constants.SimulationConstants;
import com.example.apiGarbageSimulation.entities.DailyOperation;
import com.example.apiGarbageSimulation.entities.Via;
import com.example.apiGarbageSimulation.helper.PointHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.Point;

public class Punto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Float[] data;
    Via via;
    private Integer volume;

    public Punto(DailyOperation operation) {
        super();
        this.data = PointHelper.pointFloat((Point) operation.getVia().getLocation());
        this.via = operation.getVia();
        this.volume = operation.getVolume();
    }

    public Punto(Float[] data) {
        this.data = data;
    }

    public Punto(Float x, Float y) {
        this.data = new Float[2];
        this.data[0] = x;
        this.data[1] = y;
    }

    public float get(int dimension) {
        return data[dimension];
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public int getGrado() {
        return data.length;
    }

    public Float[] getData() {
        return data;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public float getX() {
        return this.data[0];
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public float getY() {
        return this.data[1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (via != null) {
            sb.append("\t\t idVia[").append(via.getIdvia()).append("]->");
        }
        sb.append(data[0]);
        for (int i = 1; i < data.length; i++) {
            sb.append(", ");
            sb.append(data[i]);
        }
        return sb.toString();
    }

    public Double distanciaEuclideana(Punto destino) {
        Double d = 0d;
        for (int i = 0; i < data.length; i++) {
            d += Math.pow(data[i] - destino.get(i), 2);
        }
        return Math.sqrt(d);
    }

    @Override
    public boolean equals(Object obj) {
        Punto other = (Punto) obj;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}
    
    

}
