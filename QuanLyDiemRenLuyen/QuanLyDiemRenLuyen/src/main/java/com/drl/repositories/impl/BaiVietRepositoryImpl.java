/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.BaiViet;
import com.drl.repositories.BaiVietRepository;
import java.util.List;
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
public class BaiVietRepositoryImpl implements BaiVietRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addOrUpdate(BaiViet b) {
        Session s = this.factory.getObject().getCurrentSession();
        if (b.getId() != null) {
            s.update(b);
        } else {
            s.save(b);
        }
    }

    public List<BaiViet> getAllBaiViets() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createNamedQuery("BaiViet.findAll");
        return query.getResultList();
    }

    public BaiViet getBaiVietById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(BaiViet.class, id);
    }
    public void deleteBaiViet(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        BaiViet b = s.get(BaiViet.class, id);
        s.delete(b);
    }

}
