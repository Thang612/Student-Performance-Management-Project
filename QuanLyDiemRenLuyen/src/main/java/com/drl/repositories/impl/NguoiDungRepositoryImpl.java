/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Khoa;
import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVien;
import com.drl.pojo.TroLySinhVien;
import com.drl.repositories.NguoiDungRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class NguoiDungRepositoryImpl implements NguoiDungRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM NguoiDung WHERE username = :username");
        query.setParameter("username", username);
        return (NguoiDung) query.getSingleResult();
    }

    @Override
    public void addTroLy(NguoiDung nd, int khoaId) {
        Session s = this.factory.getObject().getCurrentSession();
        nd.setPassword(encoder.encode(nd.getPassword()));
        s.save(nd);
        int nguoiDungId = nd.getId();
        TroLySinhVien tl = new TroLySinhVien();
        tl.setNguoiDung(nd);
        tl.setId(nguoiDungId);
        Khoa k = s.get(Khoa.class, khoaId);
        
        tl.setKhoaId(k);
        s.save(tl);
    }
    
    public void addSinhVien(SinhVien sv) {
                Session s = this.factory.getObject().getCurrentSession();
                s.save(sv);
    }

    @Override
    public void addNguoiDung(NguoiDung nd) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(nd);

    }
    public boolean authNguoiDung(String username, String pasword) {
        NguoiDung n  = this.getNguoiDungByUsername(username);
        return this.encoder.matches(pasword, n.getPassword());
    }

}
