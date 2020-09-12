
/*@JsonSerialize(using = GeometrySerializer.class)

    @JsonDeserialize(using = GeometryDeserializer.class)
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.apiGarbageSimulation.helper.GeometryDeserializer;
import com.example.apiGarbageSimulation.helper.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Geometry;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "dumpster")
public class Dumpster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    @Column(name = "location")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry location;

    @Column(name = "id_dumpster_type")
    private Integer idDumpsterType;

    @Column(name = "id_physical_state")
    private Integer idPhysicalState;

    @JoinColumn(name = "idvia", referencedColumnName = "idvia")
    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private Via via;
    
    @Column(name = "device_id")
    private String deviceID;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((via == null) ? 0 : via.hashCode());
        result = prime * result + ((idDumpsterType == null) ? 0 : idDumpsterType.hashCode());
        result = prime * result + ((idPhysicalState == null) ? 0 : idPhysicalState.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((deviceID == null) ? 0 : deviceID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Geometry location) {
        this.location = location;
    }

    public Integer getIdDumpsterType() {
        return idDumpsterType;
    }

    public void setIdDumpsterType(Integer idDumpsterType) {
        this.idDumpsterType = idDumpsterType;
    }

    public Integer getIdPhysicalState() {
        return idPhysicalState;
    }

    public void setIdPhysicalState(Integer idPhysicalState) {
        this.idPhysicalState = idPhysicalState;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	@Override
    public String toString() {
        return "Dumpster{" + "id=" + id + ", location=" + location + ", idDumpsterType=" + idDumpsterType + ", idPhysicalState=" + idPhysicalState + ", idvia=" + via + ", deviceID=" + deviceID + '}';
    }

}
