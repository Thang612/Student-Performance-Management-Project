/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.HoatDongRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class HoatDongRepositoryImpl implements HoatDongRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<HoatDong> getHoatDongs(Map<String, String> params) {
        Session s = this.factory.getObject().openSession();
        CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện

        CriteriaQuery<HoatDong> q = b.createQuery(HoatDong.class);//Tạo những lệnh truy vấn đến bảng nào

        Root r = q.from(HoatDong.class);//Muốn lấy trường (column)
        q.select(r);
        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
        }
        String dieuId = params.get("dieuId");
        if (dieuId != null && !dieuId.isEmpty()) {
            predicates.add(b.equal(r.get("dieuId"), Integer.parseInt(dieuId)));
        }

        String hocKiNamHocId = params.get("hocKiNamHocId");
        if (hocKiNamHocId != null && !hocKiNamHocId.isEmpty()) {
            predicates.add(b.equal(r.get("hocKiNamHocId"), Integer.parseInt(hocKiNamHocId)));
        }

        q.where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.desc(r.get("id")));
        Query query = s.createQuery(q);

        String p = params.get("page");
        if (p != null && !p.isEmpty()) {
            int pageSize = Integer.parseInt(env.getProperty("hoatDong.pageSize").toString());
            int start = (Integer.parseInt(p) - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);
        }

        List<HoatDong> hoatDongs = query.getResultList();
        return hoatDongs;
    }

    @Override
    public void addOrUpdate(HoatDong h) {
        Session s = this.factory.getObject().getCurrentSession();
        if (h.getId() != null) {
            s.update(h);
        } else {
            s.save(h);
        }
    }

    @Override
    public HoatDong getHoatDongByIDd(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(HoatDong.class, id);
    }

    @Override
    public void deleteHoatDong(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM SinhVienHoatDong WHERE hoatDongId.id = :id");
        query.setParameter("id", id);
        List<SinhVienHoatDong> rs = query.getResultList();
        for (SinhVienHoatDong svhd : rs) {
            s.delete(svhd);
        }

        HoatDong h = this.getHoatDongByIDd(id);
        System.out.print(h);

        s.delete(h);
    }

    @Override
    public List<HoatDong> getAllHoatDongs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createNamedQuery("HoatDong.findAll");
        return query.getResultList();

    }

    public List<Object[]> getAllHoatDongTheoSinhVien(int hocki, int sinhvien) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("SELECT svhd.hoatDongId, svhd.trangThai FROM SinhVienHoatDong svhd WHERE svhd.sinhVienId.id = :sinhvien AND svhd.hoatDongId.hocKiNamHocId.id = :hocki ");
        query.setParameter("sinhvien", sinhvien);
        query.setParameter("hocki", hocki);
        return query.getResultList();
    }

    public List<HoatDong> getHoatDongDangKy(int hocki, int sinhvien) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM HoatDong h WHERE h.hocKiNamHocId.id =:hocki AND (h.id NOT IN (SELECT svhd.hoatDongId.id FROM SinhVienHoatDong svhd WHERE svhd.sinhVienId.id = :sinhvien AND svhd.hoatDongId.hocKiNamHocId.id = :hocki ))");
        query.setParameter("sinhvien", sinhvien);
        query.setParameter("hocki", hocki);
        return query.getResultList();
    }

    public SinhVienHoatDong taoDangKySuKien(SinhVienHoatDong svhd) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(svhd);
        return svhd;
    }
}
