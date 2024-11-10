/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.BaoThieu;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.BaoThieuRepository;
import java.util.List;
import java.util.Map;
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
public class BaoThieuRepositoryImpl implements BaoThieuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<BaoThieu> getBaoThieus(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        String hocKiNamHocId = (params.get("hocKiNamHocId"));

        Query query;

        if (hocKiNamHocId != null && !hocKiNamHocId.isEmpty()) {
            query = s.createQuery("FROM BaoThieu WHERE active = 1 AND sinhVienHoatDongId.hoatDongId.hocKiNamHocId.id = :hocKiNamHocId");
            query.setParameter("hocKiNamHocId", Integer.parseInt(hocKiNamHocId));
        } else {
            query = s.createQuery("FROM BaoThieu WHERE active = 1");
        }

        return query.getResultList();
    }

    @Override
    public void updateBaoThieu(int id) {
        Session s = this.factory.getObject().getCurrentSession();
//         Query query = s.createQuery("UPDATE BaoThieu SET active = 0 WHERE active = 1 AND id = :id");
//         query.setParameter("id", id);
//         query.executeUpdate();
        BaoThieu b = s.get(BaoThieu.class, id);
        b.setActive((short) 0);
        s.update(b);

        int svhdId = b.getSinhVienHoatDongId().getId();
        Query query = s.createQuery("UPDATE SinhVienHoatDong SET trangThai = 1 WHERE trangThai = 0 AND id = :id");
        query.setParameter("id", svhdId);
        query.executeUpdate();

    }

    public void deleteBaoThieu(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        BaoThieu b = s.get(BaoThieu.class, id);
        int svhdId = b.getSinhVienHoatDongId().getId();
        SinhVienHoatDong svhd = s.get(SinhVienHoatDong.class, svhdId);
        s.delete(b);
        s.delete(svhd);

    }
}
