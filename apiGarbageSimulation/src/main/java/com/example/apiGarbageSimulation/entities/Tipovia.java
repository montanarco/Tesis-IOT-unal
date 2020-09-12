/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "tipovia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipovia.findAll", query = "SELECT t FROM Tipovia t")})
public class Tipovia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipovia")
    private Integer idtipovia;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    

    public Tipovia() {
    }

    public Tipovia(Integer idtipovia) {
        this.idtipovia = idtipovia;
    }

    public Integer getIdtipovia() {
        return idtipovia;
    }

    public void setIdtipovia(Integer idtipovia) {
        this.idtipovia = idtipovia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipovia != null ? idtipovia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipovia)) {
            return false;
        }
        Tipovia other = (Tipovia) object;
        if ((this.idtipovia == null && other.idtipovia != null) || (this.idtipovia != null && !this.idtipovia.equals(other.idtipovia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Tipovia[ idtipovia=" + idtipovia + " ]";
    }
    
}
