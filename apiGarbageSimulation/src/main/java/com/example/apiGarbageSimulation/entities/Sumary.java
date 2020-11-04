package com.example.apiGarbageSimulation.entities;

public class Sumary {
	
	private Integer cost;
	private Integer unassigned;
	private Integer [] delivery;
	private Integer [] amount;
	private Integer [] pickup;
	private Integer service;
	private Integer duration;
	private Integer waiting_time;
	//private Computing_Times computing_times;
	public Sumary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getUnassigned() {
		return unassigned;
	}
	public void setUnassigned(Integer unassigned) {
		this.unassigned = unassigned;
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
}
