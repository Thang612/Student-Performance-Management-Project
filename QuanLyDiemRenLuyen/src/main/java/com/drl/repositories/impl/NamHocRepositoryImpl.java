/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.NamHoc;
import com.drl.repositories.NamHocRepository;
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
public class NamHocRepositoryImpl implements NamHocRepository {

    @Autowired
    private LocalSessionFactoryBean factocry;

    @Override
    public List<NamHoc> getNamHocs() {
        Session s = this.factocry.getObject().getCurrentSession();
        Query query = s.createNamedQuery("NamHoc.findAll");
        return query.getResultList();
    }
    public NamHoc getNamHocById(int id) {
                Session s = this.factocry.getObject().getCurrentSession();
        return s.get(NamHoc.class, id);
    }
}
