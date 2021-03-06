package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "routes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Route r")})
@NamedNativeQuery(
		name = "Routes.findByCreatedOnBetween",
		query="select * from Routes r where r.created_on between ? and ? ",
		resultClass= Routes.class
		)
public class Routes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routesSequence")
	@SequenceGenerator(name="routesSequence", sequenceName="routes_sequence", allocationSize=1)
	private Integer id;
	
	@Column(name = "vehicle")
	private Integer vehicle;
	@Column(name = "cost")
	private Integer cost;
	@Column(name = "delivery")
	private Integer [] delivery;
	@Column(name = "amount")
	private Integer [] amount;
	@Column(name = "pickup")
	private Integer [] pickup;
	@Column(name = "service")
	private Integer service;
	@Column(name = "duration")
	private Integer duration;
	@Column(name = "waiting_time")
	private Integer waiting_time;

	@OneToMany(mappedBy = "idRoute", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Collection<Step> steps;
	
	@Column(name = "created_on")
    //@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdOn;
	
	
	
	
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Collection<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	public void validateID() {
		for (Step st: this.steps) {
			if (st.getId()==null)
				st.setId(0);
		}
		
	}

}
