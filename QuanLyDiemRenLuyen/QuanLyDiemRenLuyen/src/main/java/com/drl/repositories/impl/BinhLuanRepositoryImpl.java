/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Comment;
import com.drl.repositories.BinhLuanRepository;
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
public class BinhLuanRepositoryImpl implements BinhLuanRepository{
     @Autowired
    private LocalSessionFactoryBean factory;
    
    public List<Comment> layBinhLuan(int baiVietId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT c FROM Comment c WHERE c.baiVietId.id = :baiVietId AND c.commentId.id = NULL ORDER BY c.thoiGian DESC" );
        q.setParameter("baiVietId",baiVietId);
        return q.getResultList();      
    }
    
    public List<Comment> layBinhLuanCon(int binhLuanId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT c FROM Comment c WHERE c.commentId.id = :binhLuanId ORDER BY c.thoiGian DESC" );
        q.setParameter("binhLuanId",binhLuanId);
        return q.getResultList();      
    }

    public Comment taoBinhLuan(Comment comment) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(comment);
        return comment;
    }
}
