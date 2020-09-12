/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "street_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StreetSection.findAll", query = "SELECT s FROM StreetSection s")})
public class StreetSection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_main_street", referencedColumnName = "id")
    @ManyToOne
    private Street idMainStreet;
    @JoinColumn(name = "id_street_1", referencedColumnName = "id")
    @ManyToOne
    private Street idStreet1;
    @JoinColumn(name = "id_street_2", referencedColumnName = "id")
    @ManyToOne
    private Street idStreet2;

    public StreetSection() {
    }

    public StreetSection(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Street getIdMainStreet() {
        return idMainStreet;
    }

    public void setIdMainStreet(Street idMainStreet) {
        this.idMainStreet = idMainStreet;
    }

    public Street getIdStreet1() {
        return idStreet1;
    }

    public void setIdStreet1(Street idStreet1) {
        this.idStreet1 = idStreet1;
    }

    public Street getIdStreet2() {
        return idStreet2;
    }

    public void setIdStreet2(Street idStreet2) {
        this.idStreet2 = idStreet2;
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
        if (!(object instanceof StreetSection)) {
            return false;
        }
        StreetSection other = (StreetSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.StreetSection[ id=" + id + " ]";
    }
    
}
