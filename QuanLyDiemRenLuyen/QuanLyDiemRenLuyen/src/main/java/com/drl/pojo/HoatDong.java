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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hoat_dong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoatDong.findAll", query = "SELECT h FROM HoatDong h"),
    @NamedQuery(name = "HoatDong.findById", query = "SELECT h FROM HoatDong h WHERE h.id = :id"),
    @NamedQuery(name = "HoatDong.findByTen", query = "SELECT h FROM HoatDong h WHERE h.ten = :ten"),
    @NamedQuery(name = "HoatDong.findByMoTa", query = "SELECT h FROM HoatDong h WHERE h.moTa = :moTa"),
    @NamedQuery(name = "HoatDong.findByDiem", query = "SELECT h FROM HoatDong h WHERE h.diem = :diem"),
    @NamedQuery(name = "HoatDong.findByPhi", query = "SELECT h FROM HoatDong h WHERE h.phi = :phi")})
public class HoatDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "ten")
    @NotEmpty(message = "Tên không được để trống")
    private String ten;
    @Size(max = 400)
    @Column(name = "mo_ta")
    private String moTa;
    @Basic(optional = false)
    @NotNull
    @Max(value = 10,message = "{hoatdong.diem.sizeErr}")
    @Min(value = 3,message = "{hoatdong.diem.sizeErr}")

    @Column(name = "diem")
    private int diem;
    @Column(name = "phi")
    private Long phi;
    @JoinColumn(name = "dieu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dieu dieuId;
    @JoinColumn(name = "hoc_ki_nam_hoc_id", referencedColumnName = "id")
    @ManyToOne
    private HocKiNamHoc hocKiNamHocId;
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Khoa khoaId;
    @JoinColumn(name = "tro_ly_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TroLySinhVien troLyId;
    @OneToMany(mappedBy = "hoatDongId")
    @JsonIgnore

    private Set<BaiViet> baiVietSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoatDongId")
    @JsonIgnore

    private Set<SinhVienHoatDong> sinhVienHoatDongSet;

    public HoatDong() {
    }

    public HoatDong(Integer id) {
        this.id = id;
    }

    public HoatDong(Integer id, int diem) {
        this.id = id;
        this.diem = diem;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Long getPhi() {
        return phi;
    }

    public void setPhi(Long phi) {
        this.phi = phi;
    }

    public Dieu getDieuId() {
        return dieuId;
    }

    public void setDieuId(Dieu dieuId) {
        this.dieuId = dieuId;
    }

    public HocKiNamHoc getHocKiNamHocId() {
        return hocKiNamHocId;
    }

    public void setHocKiNamHocId(HocKiNamHoc hocKiNamHocId) {
        this.hocKiNamHocId = hocKiNamHocId;
    }

    public Khoa getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(Khoa khoaId) {
        this.khoaId = khoaId;
    }

    public TroLySinhVien getTroLyId() {
        return troLyId;
    }

    public void setTroLyId(TroLySinhVien troLyId) {
        this.troLyId = troLyId;
    }

    @XmlTransient
    public Set<BaiViet> getBaiVietSet() {
        return baiVietSet;
    }

    public void setBaiVietSet(Set<BaiViet> baiVietSet) {
        this.baiVietSet = baiVietSet;
    }

    @XmlTransient
    public Set<SinhVienHoatDong> getSinhVienHoatDongSet() {
        return sinhVienHoatDongSet;
    }

    public void setSinhVienHoatDongSet(Set<SinhVienHoatDong> sinhVienHoatDongSet) {
        this.sinhVienHoatDongSet = sinhVienHoatDongSet;
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
        if (!(object instanceof HoatDong)) {
            return false;
        }
        HoatDong other = (HoatDong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.HoatDong[ id=" + id + " ]";
    }
    
}
