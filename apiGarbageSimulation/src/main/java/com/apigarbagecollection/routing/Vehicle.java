package com.apigarbagecollection.routing;

public class Vehicle {
	
	private Integer id;
	private String profile;
	private Float [] start;
	private Integer [] capacity;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Float[] getStart() {
		return start;
	}
	public void setStart(Float[] start) {
		this.start = start;
	}
	public Integer[] getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer[] capacity) {
		this.capacity = capacity;
	}
}
