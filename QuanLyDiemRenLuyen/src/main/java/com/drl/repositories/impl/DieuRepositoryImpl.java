/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Dieu;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.drl.repositories.DieuRepository;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class DieuRepositoryImpl implements DieuRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Dieu> getDieus() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Dieu.findAll");
        return q.getResultList();
    }
    
}
