package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.example.apiGarbageSimulation.entities.Routes;

@Entity
@Table(name = "step")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "step.findAll", query = "SELECT s FROM Route s")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @NotNull
	@Column(name = "id_step") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //, generator = "stepIdStepSeq"
    //@SequenceGenerator(name = "stepIdStepSeq")
	private Integer idStep;
	
    @Column(name = "type")
	private String type;
    @JoinColumn(name = "id_route", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Routes idRoute;
    @Column(name = "location")
	private Float [] location;
    @Column(name = "load")
	private Integer [] load;
    @Column(name = "arrival")
	private Integer arrival;
    @Column(name = "duration")
	private Integer duration;
    @Column(name = "id")
	private Integer id;
    @Column(name = "job")
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

	public Integer getIdStep() {
		return idStep;
	}

	public void setIdStep(Integer idStep) {
		this.idStep = idStep;
	}

	public Routes getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(Routes idRoute) {
		this.idRoute = idRoute;
	}
}
