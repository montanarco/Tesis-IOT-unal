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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
@Table(name = "daily_operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailyOperation.findAll", query = "SELECT d FROM DailyOperation d")})
public class DailyOperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "idPriority")
    private Integer idPriority;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = DateToJsonSerializer.class)
    @JsonDeserialize(using = JsonToDateDeserializer.class)
    private Date date;

    @JoinColumn(name = "idVia", referencedColumnName = "idvia")
    @ManyToOne(optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Via via;

    public DailyOperation() {
    }

    
    public DailyOperation(Integer volume, Date date, Via via) {
        super();
        this.volume = volume;
        this.date = date;
        this.via = via;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Integer idPriority) {
        this.idPriority = idPriority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

}
