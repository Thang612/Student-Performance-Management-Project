/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "nam_hoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NamHoc.findAll", query = "SELECT n FROM NamHoc n"),
    @NamedQuery(name = "NamHoc.findById", query = "SELECT n FROM NamHoc n WHERE n.id = :id"),
    @NamedQuery(name = "NamHoc.findByNamHoc", query = "SELECT n FROM NamHoc n WHERE n.namHoc = :namHoc")})
public class NamHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_hoc")
    private int namHoc;
    @OneToMany(mappedBy = "namHocId")
    @JsonIgnore
    private Set<HocKiNamHoc> hocKiNamHocSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "namHocId")
    @JsonIgnore
    private Set<SinhVien> sinhVienSet;

    public NamHoc() {
    }

    public NamHoc(Integer id) {
        this.id = id;
    }

    public NamHoc(Integer id, int namHoc) {
        this.id = id;
        this.namHoc = namHoc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    @XmlTransient
    public Set<HocKiNamHoc> getHocKiNamHocSet() {
        return hocKiNamHocSet;
    }

    public void setHocKiNamHocSet(Set<HocKiNamHoc> hocKiNamHocSet) {
        this.hocKiNamHocSet = hocKiNamHocSet;
    }

    @XmlTransient
    public Set<SinhVien> getSinhVienSet() {
        return sinhVienSet;
    }

    public void setSinhVienSet(Set<SinhVien> sinhVienSet) {
        this.sinhVienSet = sinhVienSet;
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
        if (!(object instanceof NamHoc)) {
            return false;
        }
        NamHoc other = (NamHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.NamHoc[ id=" + id + " ]";
    }

}
