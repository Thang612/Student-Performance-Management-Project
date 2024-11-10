/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.NguoiDung;
import com.drl.repositories.LoginClientRepository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
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
public class LoginClientRepositoryImpl implements LoginClientRepository{
       @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public NguoiDung laySinhVien(String email) {
        Session s = this.factory.getObject().getCurrentSession();
        TypedQuery<NguoiDung> query = s.createQuery("SELECT nd FROM NguoiDung nd WHERE nd.email = :email AND nd.userRole = 'ROLE_SINHVIEN'", NguoiDung.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
