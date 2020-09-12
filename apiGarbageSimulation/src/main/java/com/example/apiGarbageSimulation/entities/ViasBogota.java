/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.entities;

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
@Table(name = "ViasBogota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViasBogota.findAll", query = "SELECT v FROM ViasBogota v")})
public class ViasBogota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Column(name = "mviccalzad")
    private Long mviccalzad;
    @Size(max = 10)
    @Column(name = "mviccat")
    private String mviccat;
    @Column(name = "mvitcla")
    private Long mvitcla;
    @Size(max = 3)
    @Column(name = "mvitipo")
    private String mvitipo;
    @Size(max = 40)
    @Column(name = "mvinombre")
    private String mvinombre;
    @Size(max = 50)
    @Column(name = "mvinaltern")
    private String mvinaltern;
    @Size(max = 10)
    @Column(name = "mvinprinci")
    private String mvinprinci;
    @Size(max = 10)
    @Column(name = "mvingenera")
    private String mvingenera;
    @Size(max = 50)
    @Column(name = "mvinantigu")
    private String mvinantigu;
    @Size(max = 50)
    @Column(name = "mvietiquet")
    private String mvietiquet;
    @Size(max = 2)
    @Column(name = "mvisvia")
    private String mvisvia;
    @Column(name = "mviciv")
    private Long mviciv;
    @Column(name = "shape_leng")
    private BigInteger shapeLeng;
    @Lob
    @Column(name = "geom")
    private Object geom;

    public ViasBogota() {
    }

    public ViasBogota(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Long getMviccalzad() {
        return mviccalzad;
    }

    public void setMviccalzad(Long mviccalzad) {
        this.mviccalzad = mviccalzad;
    }

    public String getMviccat() {
        return mviccat;
    }

    public void setMviccat(String mviccat) {
        this.mviccat = mviccat;
    }

    public Long getMvitcla() {
        return mvitcla;
    }

    public void setMvitcla(Long mvitcla) {
        this.mvitcla = mvitcla;
    }

    public String getMvitipo() {
        return mvitipo;
    }

    public void setMvitipo(String mvitipo) {
        this.mvitipo = mvitipo;
    }

    public String getMvinombre() {
        return mvinombre;
    }

    public void setMvinombre(String mvinombre) {
        this.mvinombre = mvinombre;
    }

    public String getMvinaltern() {
        return mvinaltern;
    }

    public void setMvinaltern(String mvinaltern) {
        this.mvinaltern = mvinaltern;
    }

    public String getMvinprinci() {
        return mvinprinci;
    }

    public void setMvinprinci(String mvinprinci) {
        this.mvinprinci = mvinprinci;
    }

    public String getMvingenera() {
        return mvingenera;
    }

    public void setMvingenera(String mvingenera) {
        this.mvingenera = mvingenera;
    }

    public String getMvinantigu() {
        return mvinantigu;
    }

    public void setMvinantigu(String mvinantigu) {
        this.mvinantigu = mvinantigu;
    }

    public String getMvietiquet() {
        return mvietiquet;
    }

    public void setMvietiquet(String mvietiquet) {
        this.mvietiquet = mvietiquet;
    }

    public String getMvisvia() {
        return mvisvia;
    }

    public void setMvisvia(String mvisvia) {
        this.mvisvia = mvisvia;
    }

    public Long getMviciv() {
        return mviciv;
    }

    public void setMviciv(Long mviciv) {
        this.mviciv = mviciv;
    }

    public BigInteger getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigInteger shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public Object getGeom() {
        return geom;
    }

    public void setGeom(Object geom) {
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
        if (!(object instanceof ViasBogota)) {
            return false;
        }
        ViasBogota other = (ViasBogota) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.ViasBogota[ gid=" + gid + " ]";
    }
    
}
