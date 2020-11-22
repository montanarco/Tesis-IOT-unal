package com.apigarbagecollection.routing;

public class Job {
	Integer id;
	Integer service;
	Integer [] amount;
	Float [] location;
	
	
	public Job() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getService() {
		return service;
	}

	public void setService(Integer service) {
		this.service = service;
	}

	public Integer[] getAmount() {
		return amount;
	}

	public void setAmount(Integer[] amount) {
		this.amount = amount;
	}

	public Float[] getLocation() {
		return location;
	}

	public void setLocation(Float[] location) {
		this.location = location;
	}

}