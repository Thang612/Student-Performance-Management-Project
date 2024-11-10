/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hoc_ki_nam_hoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HocKiNamHoc.findAll", query = "SELECT h FROM HocKiNamHoc h"),
    @NamedQuery(name = "HocKiNamHoc.findById", query = "SELECT h FROM HocKiNamHoc h WHERE h.id = :id")})
public class HocKiNamHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "hocKiNamHocId")
        @JsonIgnore
    private Set<HoatDong> hoatDongSet;
    @JoinColumn(name = "hoc_ki_id", referencedColumnName = "id")
    @ManyToOne
    private HocKi hocKiId;
    @JoinColumn(name = "nam_hoc_id", referencedColumnName = "id")
    @ManyToOne
    private NamHoc namHocId;

    public HocKiNamHoc() {
    }

    public HocKiNamHoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Set<HoatDong> getHoatDongSet() {
        return hoatDongSet;
    }

    public void setHoatDongSet(Set<HoatDong> hoatDongSet) {
        this.hoatDongSet = hoatDongSet;
    }

    public HocKi getHocKiId() {
        return hocKiId;
    }

    public void setHocKiId(HocKi hocKiId) {
        this.hocKiId = hocKiId;
    }

    public NamHoc getNamHocId() {
        return namHocId;
    }

    public void setNamHocId(NamHoc namHocId) {
        this.namHocId = namHocId;
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
        if (!(object instanceof HocKiNamHoc)) {
            return false;
        }
        HocKiNamHoc other = (HocKiNamHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.HocKiNamHoc[ id=" + id + " ]";
    }
    
}
