/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import com.example.apiGarbageSimulation.helper.GeometryDeserializer;
import com.example.apiGarbageSimulation.helper.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b")})
public class Barrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbarrio")
    private Integer idbarrio;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo")
    private String codigo;
   
    @Column(name = "geom")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geom;
    
    @JoinTable(name = "barrio_via", joinColumns = {
        @JoinColumn(name = "barrioidbarrio", referencedColumnName = "idbarrio")}, inverseJoinColumns = {
        @JoinColumn(name = "viaidvia", referencedColumnName = "idvia")})
    @ManyToMany
    private List<Via> viaList;
    @JoinColumn(name = "idlocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad idlocalidad;

    public Barrio() {
    }

    public Barrio(Integer idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Barrio(Integer idbarrio, String codigo) {
        this.idbarrio = idbarrio;
        this.codigo = codigo;
    }

    public Integer getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Integer idbarrio) {
        this.idbarrio = idbarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    @XmlTransient
    public List<Via> getViaList() {
        return viaList;
    }

    public void setViaList(List<Via> viaList) {
        this.viaList = viaList;
    }

    public Localidad getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Localidad idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarrio != null ? idbarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idbarrio == null && other.idbarrio != null) || (this.idbarrio != null && !this.idbarrio.equals(other.idbarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Barrio[ idbarrio=" + idbarrio + " ]";
    }
    
}
