/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.SinhVienHoatDongRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class SinhVienHoatDongRepositoryImpl implements SinhVienHoatDongRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    public void addSinhVienHoatDong(int svId, int hdId) {
        Session s = this.factory.getObject().getCurrentSession();
        SinhVienHoatDong svhd = new SinhVienHoatDong();
        Query q1 = s.createQuery("SELECT s FROM SinhVien s WHERE s.id = :id");
        q1.setParameter("id", svId);
        SinhVien sv = (SinhVien) q1.getSingleResult();

        Query q2 = s.createQuery("SELECT h FROM HoatDong h WHERE h.id = :id");
        q2.setParameter("id", hdId);
        HoatDong hd = (HoatDong) q2.getSingleResult();
        svhd.setSinhVienId(sv);
        svhd.setHoatDongId(hd);
        svhd.setTrangThai(Boolean.TRUE);

        s.save(svhd);
    }

    public void updateSinhVienHoatDong(SinhVienHoatDong svhd) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(svhd);
    }

    @Override
    public SinhVienHoatDong getHoatDongSinhVien(int svId, int hdId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q1 = s.createQuery("SELECT s FROM SinhVien s WHERE s.id = :id");
        q1.setParameter("id", svId);
        SinhVien sv = (SinhVien) q1.getSingleResult();

        Query q2 = s.createQuery("SELECT h FROM HoatDong h WHERE h.id = :id");
        q2.setParameter("id", hdId);
        HoatDong hd = (HoatDong) q2.getSingleResult();
        
        Query q = s.createQuery("SELECT s FROM SinhVienHoatDong s WHERE s.hoatDongId = :hoatdongId AND s.sinhVienId = :sinhVienId");
        q.setParameter("hoatdongId", hd);
        q.setParameter("sinhVienId", sv);
        SinhVienHoatDong svhd = (SinhVienHoatDong) q.uniqueResult();
        System.out.println(svhd);
        return svhd;
    }
}
