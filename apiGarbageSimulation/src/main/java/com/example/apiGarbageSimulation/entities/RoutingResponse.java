package com.example.apiGarbageSimulation.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.apiGarbageSimulation.entities.Unassigned;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutingResponse {
	
	private Integer code;
	private Sumary sumary;
	private List<Unassigned> unassigned;
	private List<Routes> routes;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Sumary getSumary() {
		return sumary;
	}
	public void setSumary(Sumary sumary) {
		this.sumary = sumary;
	}
	public List<Unassigned> getUnassigned() {
		return unassigned;
	}
	public void setUnassigned(List<Unassigned> unassigned) {
		this.unassigned = unassigned;
	}
	public List<Routes> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Routes> routes) {
		this.routes = routes;
	} 
	
	
}
