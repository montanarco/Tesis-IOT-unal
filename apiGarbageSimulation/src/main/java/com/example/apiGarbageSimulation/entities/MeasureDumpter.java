/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.apiGarbageSimulation.helper.DateToJsonSerializer;
import com.example.apiGarbageSimulation.helper.JsonToDateDeserializer;
import com.example.apiGarbageSimulation.helper.GeometryDeserializer;
import com.example.apiGarbageSimulation.helper.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author roa.fabio
 */
@Entity
@Table(name = "measure_dumpter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasureDumpter.findAll", query = "SELECT m FROM MeasureDumpter m")})
public class MeasureDumpter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "level")
    private Integer level;
    
    @Column(name = "measure_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = DateToJsonSerializer.class)
    @JsonDeserialize(using = JsonToDateDeserializer.class)
    private Date measureDate;
    

    @JoinColumn(name = "id_dumpster", referencedColumnName = "id")
    @ManyToOne
    private Dumpster idDumpster;
    
    @JoinColumn(name = "priority", referencedColumnName = "id")
    @ManyToOne
    private PriorityType priority;

    public MeasureDumpter() {
    }

    public MeasureDumpter(Integer id) {
        this.id = id;
    }

    public MeasureDumpter( Integer level, Date measureDate, Dumpster idDumpster) {
        super();
        this.level = level;
        this.measureDate = measureDate;
        this.idDumpster = idDumpster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getMeasureDate() {
        return measureDate;
    }

    public void setMeasureDate(Date measureDate) {
        this.measureDate = measureDate;
    }

    public Dumpster getIdDumpster() {
        return idDumpster;
    }

    public void setIdDumpster(Dumpster idDumpster) {
        this.idDumpster = idDumpster;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
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
        if (!(object instanceof MeasureDumpter)) {
            return false;
        }
        MeasureDumpter other = (MeasureDumpter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.MeasureDumpter[ id=" + id + " ]";
    }

    public void computePriority() {
        if (this.level >= 80) {
            this.priority = new PriorityType(4, ">= 81%","Full");
        }
        if (this.level >= 55 && this.level < 80) {
            this.priority = new PriorityType(1, "between 55% AND 80%", "High");
        }
        if (this.level >= 30 && this.level < 55) {
            this.priority = new PriorityType(2, "between 30% AND 55%", "Medium");
        }
        if (this.level < 30) {
            this.priority = new PriorityType(3, "between 11% AND 30%", "Low");
        }
        if (this.level == 0) {
            this.priority = new PriorityType(5, "<10%", "Empty");
        }
    }
    
    

}
