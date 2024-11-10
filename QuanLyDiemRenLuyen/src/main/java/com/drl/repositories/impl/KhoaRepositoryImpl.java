/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Khoa;
import com.drl.repositories.KhoaRepository;
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
public class KhoaRepositoryImpl implements KhoaRepository{

    @Autowired
    private LocalSessionFactoryBean factocry;
    @Override
    public List<Khoa> getKhoas() {
        Session s = this.factocry.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Khoa.findAll");
        return query.getResultList();
    }
    
}
