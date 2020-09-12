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
@Table(name = "physical_state_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhysicalStateType.findAll", query = "SELECT p FROM PhysicalStateType p")})
public class PhysicalStateType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "state_description")
    private String stateDescription;
    @OneToMany(mappedBy = "idPhysicalState")
    private List<Dumpster> dumpsterList;

    public PhysicalStateType() {
    }

    public PhysicalStateType(Integer id) {
        this.id = id;
    }

    public PhysicalStateType(Integer id, String stateDescription) {
        this.id = id;
        this.stateDescription = stateDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    @XmlTransient
    public List<Dumpster> getDumpsterList() {
        return dumpsterList;
    }

    public void setDumpsterList(List<Dumpster> dumpsterList) {
        this.dumpsterList = dumpsterList;
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
        if (!(object instanceof PhysicalStateType)) {
            return false;
        }
        PhysicalStateType other = (PhysicalStateType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.PhysicalStateType[ id=" + id + " ]";
    }
    
}
