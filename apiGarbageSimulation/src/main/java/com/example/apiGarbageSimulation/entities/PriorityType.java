/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "priority_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriorityType.findAll", query = "SELECT p FROM PriorityType p")})
public class PriorityType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 2147483647)
    @Column(name = "priority_description")
    private String priorityDescription;
    
    @Size(max = 2147483647)
    @Column(name = "priority_name")
    private String priorityName;
    
    public PriorityType() {
    }

    public PriorityType(Integer id) {
        this.id = id;
    }
    
    

    public PriorityType(@NotNull Integer id, @Size(max = 2147483647) String priorityDescription, @Size(max = 2147483647) String priorityName) {
		super();
		this.id = id;
		this.priorityDescription = priorityDescription;
		this.priorityName = priorityName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriorityDescription() {
        return priorityDescription;
    }

    public void setPriorityDescription(String priorityDescription) {
        this.priorityDescription = priorityDescription;
    }    

    public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
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
        if (!(object instanceof PriorityType)) {
            return false;
        }
        PriorityType other = (PriorityType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.PriorityType[ id=" + id + " ]";
    }
    
}
