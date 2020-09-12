/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "route_date")
    @Temporal(TemporalType.DATE)
    private Date routeDate;
    @Lob
    @Column(name = "start_point")
    private Object startPoint;
    @Column(name = "employed_time")
    private BigInteger employedTime;
    @Column(name = "collected_volume")
    private Integer collectedVolume;
    @JoinColumn(name = "route_priority", referencedColumnName = "id")
    @ManyToOne
    private PriorityType routePriority;
    @JoinColumn(name = "id_camion", referencedColumnName = "id")
    @ManyToOne
    private Truck idCamion;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(Date routeDate) {
        this.routeDate = routeDate;
    }

    public Object getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Object startPoint) {
        this.startPoint = startPoint;
    }

    public BigInteger getEmployedTime() {
        return employedTime;
    }

    public void setEmployedTime(BigInteger employedTime) {
        this.employedTime = employedTime;
    }

    public Integer getCollectedVolume() {
        return collectedVolume;
    }

    public void setCollectedVolume(Integer collectedVolume) {
        this.collectedVolume = collectedVolume;
    }

    public PriorityType getRoutePriority() {
        return routePriority;
    }

    public void setRoutePriority(PriorityType routePriority) {
        this.routePriority = routePriority;
    }

    public Truck getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Truck idCamion) {
        this.idCamion = idCamion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Route[ id=" + id + " ]";
    }
    
}
