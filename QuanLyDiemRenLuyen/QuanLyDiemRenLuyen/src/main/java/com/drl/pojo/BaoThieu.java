/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "bao_thieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaoThieu.findAll", query = "SELECT b FROM BaoThieu b"),
    @NamedQuery(name = "BaoThieu.findById", query = "SELECT b FROM BaoThieu b WHERE b.id = :id"),
    @NamedQuery(name = "BaoThieu.findByActive", query = "SELECT b FROM BaoThieu b WHERE b.active = :active"),
    @NamedQuery(name = "BaoThieu.findByMinhChung", query = "SELECT b FROM BaoThieu b WHERE b.minhChung = :minhChung")})
public class BaoThieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Short active;
    @Size(max = 500)
    @Column(name = "minh_chung")
    private String minhChung;
    @JoinColumn(name = "sinh_vien_hoat_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SinhVienHoatDong sinhVienHoatDongId;

    public BaoThieu() {
    }

    public BaoThieu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getMinhChung() {
        return minhChung;
    }

    public void setMinhChung(String minhChung) {
        this.minhChung = minhChung;
    }

    public SinhVienHoatDong getSinhVienHoatDongId() {
        return sinhVienHoatDongId;
    }

    public void setSinhVienHoatDongId(SinhVienHoatDong sinhVienHoatDongId) {
        this.sinhVienHoatDongId = sinhVienHoatDongId;
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
        if (!(object instanceof BaoThieu)) {
            return false;
        }
        BaoThieu other = (BaoThieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.BaoThieu[ id=" + id + " ]";
    }
    
}
