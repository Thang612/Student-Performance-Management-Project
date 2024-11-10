/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Lop;
import com.drl.repositories.LopRepository;
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
@Transactional
@Repository
public class LopRepositoryImpl implements LopRepository {

    @Autowired
    private LocalSessionFactoryBean factocry;

    @Override
    public List<Lop> getLops() {
        Session s = this.factocry.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Lop.findAll");
        return query.getResultList();
    }
    public Lop getLopById(int id) {
                Session s = this.factocry.getObject().getCurrentSession();
                return s.get(Lop.class, id);
    }
}
