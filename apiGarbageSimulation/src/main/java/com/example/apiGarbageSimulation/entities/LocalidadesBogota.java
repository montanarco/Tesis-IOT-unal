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
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "LocalidadesBogota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalidadesBogota.findAll", query = "SELECT l FROM LocalidadesBogota l")})
public class LocalidadesBogota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Size(max = 50)
    @Column(name = "locnombre")
    private String locnombre;
    @Size(max = 50)
    @Column(name = "locaadmini")
    private String locaadmini;
    @Column(name = "locarea")
    private BigInteger locarea;
    @Size(max = 2)
    @Column(name = "loccodigo")
    private String loccodigo;
    @Column(name = "shape_leng")
    private BigInteger shapeLeng;
    @Column(name = "shape_area")
    private BigInteger shapeArea;

    @Column(name = "geom")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geom;

    public LocalidadesBogota() {
    }

    public LocalidadesBogota(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getLocnombre() {
        return locnombre;
    }

    public void setLocnombre(String locnombre) {
        this.locnombre = locnombre;
    }

    public String getLocaadmini() {
        return locaadmini;
    }

    public void setLocaadmini(String locaadmini) {
        this.locaadmini = locaadmini;
    }

    public BigInteger getLocarea() {
        return locarea;
    }

    public void setLocarea(BigInteger locarea) {
        this.locarea = locarea;
    }

    public String getLoccodigo() {
        return loccodigo;
    }

    public void setLoccodigo(String loccodigo) {
        this.loccodigo = loccodigo;
    }

    public BigInteger getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigInteger shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public BigInteger getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(BigInteger shapeArea) {
        this.shapeArea = shapeArea;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadesBogota)) {
            return false;
        }
        LocalidadesBogota other = (LocalidadesBogota) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.LocalidadesBogota[ gid=" + gid + " ]";
    }

}
