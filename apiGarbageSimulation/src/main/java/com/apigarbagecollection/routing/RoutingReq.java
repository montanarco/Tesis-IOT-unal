package com.apigarbagecollection.routing;

import java.util.List;

public class RoutingReq {
	
	List<Job> jobs;
	List<Vehicle> vehicles;
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
