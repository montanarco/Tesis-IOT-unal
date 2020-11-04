package com.example.apiGarbageSimulation.entities;

public class Step {
	private String type;
	private Float [] location;
	private Integer [] load;
	private Integer arrival;
	private Integer duration;
	private Integer id;
	private Integer job;
	
	public Step() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float[] getLocation() {
		return location;
	}

	public void setLocation(Float[] location) {
		this.location = location;
	}

	public Integer[] getLoad() {
		return load;
	}

	public void setLoad(Integer[] load) {
		this.load = load;
	}

	public Integer getArrival() {
		return arrival;
	}

	public void setArrival(Integer arrival) {
		this.arrival = arrival;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}
}
