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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tro_ly_sinh_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TroLySinhVien.findAll", query = "SELECT t FROM TroLySinhVien t"),
    @NamedQuery(name = "TroLySinhVien.findById", query = "SELECT t FROM TroLySinhVien t WHERE t.id = :id")})
public class TroLySinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "troLyId")
    @JsonIgnore
    private Set<HoatDong> hoatDongSet;
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Khoa khoaId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NguoiDung nguoiDung;

    public TroLySinhVien() {
    }

    public TroLySinhVien(Integer id) {
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

    public Khoa getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(Khoa khoaId) {
        this.khoaId = khoaId;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
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
        if (!(object instanceof TroLySinhVien)) {
            return false;
        }
        TroLySinhVien other = (TroLySinhVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.TroLySinhVien[ id=" + id + " ]";
    }
    
}
