/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.example.apiGarbageSimulation.helper.GeometryDeserializer;
import com.example.apiGarbageSimulation.helper.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import javax.persistence.FetchType;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "via")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Via.findAll", query = "SELECT v FROM Via v")})
public class Via implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvia")
    private Integer idvia;

    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "limitevelocidad")
    private Integer limitevelocidad;

    @Column(name = "geom")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geom;

   

    @JoinColumn(name = "idtipovia", referencedColumnName = "idtipovia")
    @ManyToOne(optional = false)
    private Tipovia idtipovia;

    @Column(name = "length")
    private Integer length;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "location")
    private Geometry location;

    public Via() {
    }

    public Via(Integer idvia) {
        this.idvia = idvia;
    }

    public Integer getIdvia() {
        return idvia;
    }

    public void setIdvia(Integer idvia) {
        this.idvia = idvia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLimitevelocidad() {
        return limitevelocidad;
    }

    public void setLimitevelocidad(Integer limitevelocidad) {
        this.limitevelocidad = limitevelocidad;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    


    public Tipovia getIdtipovia() {
        return idtipovia;
    }

    public void setIdtipovia(Tipovia idtipovia) {
        this.idtipovia = idtipovia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvia != null ? idvia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Via)) {
            return false;
        }
        Via other = (Via) object;
        if ((this.idvia == null && other.idvia != null) || (this.idvia != null && !this.idvia.equals(other.idvia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Via[ idvia=" + idvia + " ]";
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Geometry location) {
        this.location = location;
    }

}
