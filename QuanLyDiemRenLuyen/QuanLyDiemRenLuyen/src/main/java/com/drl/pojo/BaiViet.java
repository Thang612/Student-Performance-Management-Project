/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "bai_viet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaiViet.findAll", query = "SELECT b FROM BaiViet b"),
    @NamedQuery(name = "BaiViet.findById", query = "SELECT b FROM BaiViet b WHERE b.id = :id"),
    @NamedQuery(name = "BaiViet.findByTen", query = "SELECT b FROM BaiViet b WHERE b.ten = :ten"),
    @NamedQuery(name = "BaiViet.findByNgayTao", query = "SELECT b FROM BaiViet b WHERE b.ngayTao = :ngayTao"),
    @NamedQuery(name = "BaiViet.findByNoiDung", query = "SELECT b FROM BaiViet b WHERE b.noiDung = :noiDung")})
public class BaiViet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "ten")
    @NotEmpty(message = "Tên không được phép rỗng")
    private String ten;
    @Column(name = "ngay_tao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Size(max = 1000)
    @Column(name = "noi_dung")
    private String noiDung;
    @JoinColumn(name = "hoat_dong_id", referencedColumnName = "id")
    @ManyToOne
    private HoatDong hoatDongId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiVietId")
    @JsonIgnore
    private Set<Comment> commentSet;

    public BaiViet() {
        this.ngayTao = new Date();
    }

    public BaiViet(Integer id) {
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public HoatDong getHoatDongId() {
        return hoatDongId;
    }

    public void setHoatDongId(HoatDong hoatDongId) {
        this.hoatDongId = hoatDongId;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof BaiViet)) {
            return false;
        }
        BaiViet other = (BaiViet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.BaiViet[ id=" + id + " ]";
    }
    
}
