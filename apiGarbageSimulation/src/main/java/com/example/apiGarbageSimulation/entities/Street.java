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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "street")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s")})
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "location")
    private Object location;
    @OneToMany(mappedBy = "idMainStreet")
    private List<StreetSection> streetSectionList;
    @OneToMany(mappedBy = "idStreet1")
    private List<StreetSection> streetSectionList1;
    @OneToMany(mappedBy = "idStreet2")
    private List<StreetSection> streetSectionList2;

    public Street() {
    }

    public Street(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    @XmlTransient
    public List<StreetSection> getStreetSectionList() {
        return streetSectionList;
    }

    public void setStreetSectionList(List<StreetSection> streetSectionList) {
        this.streetSectionList = streetSectionList;
    }

    @XmlTransient
    public List<StreetSection> getStreetSectionList1() {
        return streetSectionList1;
    }

    public void setStreetSectionList1(List<StreetSection> streetSectionList1) {
        this.streetSectionList1 = streetSectionList1;
    }

    @XmlTransient
    public List<StreetSection> getStreetSectionList2() {
        return streetSectionList2;
    }

    public void setStreetSectionList2(List<StreetSection> streetSectionList2) {
        this.streetSectionList2 = streetSectionList2;
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
        if (!(object instanceof Street)) {
            return false;
        }
        Street other = (Street) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Street[ id=" + id + " ]";
    }
    
}
