/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "view_viaslocalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewViaslocalidad.findAll", query = "SELECT v FROM ViewViaslocalidad v")})
public class ViewViaslocalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlocalidad")
    private Integer idlocalidad;
    @Size(max = 50)
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "idbarrio")
    private Integer idbarrio;
    @Size(max = 50)
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "idvia")
    private Integer idvia;
    @Lob
    @Column(name = "geom")
    private Object geom;

    public ViewViaslocalidad() {
    }

    public Integer getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Integer idbarrio) {
        this.idbarrio = idbarrio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getIdvia() {
        return idvia;
    }

    public void setIdvia(Integer idvia) {
        this.idvia = idvia;
    }

    public Object getGeom() {
        return geom;
    }

    public void setGeom(Object geom) {
        this.geom = geom;
    }
    
}
