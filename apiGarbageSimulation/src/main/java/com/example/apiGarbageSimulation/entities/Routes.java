package com.example.apiGarbageSimulation.entities;

import java.util.List;

public class Routes {
	
	private Integer vehicle;
	private Integer cost;
	private Integer [] delivery;
	private Integer [] amount;
	private Integer [] pickup;
	private Integer service;
	private Integer duration;
	private Integer waiting_time;
	private List<Step> steps;
	public Integer getVehicle() {
		return vehicle;
	}
	public void setVehicle(Integer vehicle) {
		this.vehicle = vehicle;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer[] getDelivery() {
		return delivery;
	}
	public void setDelivery(Integer[] delivery) {
		this.delivery = delivery;
	}
	public Integer[] getAmount() {
		return amount;
	}
	public void setAmount(Integer[] amount) {
		this.amount = amount;
	}
	public Integer[] getPickup() {
		return pickup;
	}
	public void setPickup(Integer[] pickup) {
		this.pickup = pickup;
	}
	public Integer getService() {
		return service;
	}
	public void setService(Integer service) {
		this.service = service;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(Integer waiting_time) {
		this.waiting_time = waiting_time;
	}
	public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
