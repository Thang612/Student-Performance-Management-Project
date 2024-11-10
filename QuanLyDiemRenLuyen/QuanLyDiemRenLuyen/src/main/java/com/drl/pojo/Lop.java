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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "lop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lop.findAll", query = "SELECT l FROM Lop l"),
    @NamedQuery(name = "Lop.findById", query = "SELECT l FROM Lop l WHERE l.id = :id"),
    @NamedQuery(name = "Lop.findByTen", query = "SELECT l FROM Lop l WHERE l.ten = :ten")})
public class Lop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "ten")
    private String ten;
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    @ManyToOne
    private Khoa khoaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lopId")
    @JsonIgnore
    private Set<SinhVien> sinhVienSet;

    public Lop() {
    }

    public Lop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Khoa getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(Khoa khoaId) {
        this.khoaId = khoaId;
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
        if (!(object instanceof Lop)) {
            return false;
        }
        Lop other = (Lop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.Lop[ id=" + id + " ]";
    }
    
}
