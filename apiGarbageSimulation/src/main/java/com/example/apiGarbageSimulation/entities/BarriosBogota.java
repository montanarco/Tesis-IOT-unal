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
@Table(name = "BarriosBogota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BarriosBogota.findAll", query = "SELECT b FROM BarriosBogota b")})
public class BarriosBogota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Column(name = "objectid")
    private Integer objectid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area")
    private Double area;
    @Column(name = "perimeter")
    private Double perimeter;
    @Column(name = "bar_")
    private Integer bar;
    @Column(name = "bar_id")
    private Integer barId;
    @Size(max = 30)
    @Column(name = "nomb_barr")
    private String nombBarr;
    @Size(max = 6)
    @Column(name = "bar_cod")
    private String barCod;
    @Column(name = "forma")
    private Short forma;
    @Size(max = 2)
    @Column(name = "cod_zona")
    private String codZona;
    @Size(max = 2)
    @Column(name = "cod_loc")
    private String codLoc;
    @Column(name = "actualiz")
    private Short actualiz;
    @Column(name = "shape_leng")
    private BigInteger shapeLeng;
    @Column(name = "shape_area")
    private BigInteger shapeArea;
    
    @Column(name = "geom")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geom;

    public BarriosBogota() {
    }

    public BarriosBogota(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Integer getBar() {
        return bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public String getNombBarr() {
        return nombBarr;
    }

    public void setNombBarr(String nombBarr) {
        this.nombBarr = nombBarr;
    }

    public String getBarCod() {
        return barCod;
    }

    public void setBarCod(String barCod) {
        this.barCod = barCod;
    }

    public Short getForma() {
        return forma;
    }

    public void setForma(Short forma) {
        this.forma = forma;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getCodLoc() {
        return codLoc;
    }

    public void setCodLoc(String codLoc) {
        this.codLoc = codLoc;
    }

    public Short getActualiz() {
        return actualiz;
    }

    public void setActualiz(Short actualiz) {
        this.actualiz = actualiz;
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
        if (!(object instanceof BarriosBogota)) {
            return false;
        }
        BarriosBogota other = (BarriosBogota) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.BarriosBogota[ gid=" + gid + " ]";
    }
    
}
