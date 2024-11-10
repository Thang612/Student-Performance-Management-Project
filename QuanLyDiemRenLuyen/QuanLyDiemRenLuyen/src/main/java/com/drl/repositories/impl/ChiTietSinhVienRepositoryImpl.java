/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.BaoThieu;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.ChiTietSinhVienRepository;
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
public class ChiTietSinhVienRepositoryImpl implements ChiTietSinhVienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getChiTietSinhViens(int sinhVienId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT nd.avatar, sv.id, nd.ho, nd.ten, nd.email, nd.namSinh, nd.gioiTinh "
                + "FROM SinhVien sv "
                + "JOIN sv.nguoiDung nd "
                + "JOIN sv.lopId l "
                + "JOIN sv.namHocId "
                + "WHERE sv.id = :sinhVienId ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu1(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.ten, hd.diem " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = 1 AND svhd.trangThai = 1 ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);

        return query.getResultList();

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu2(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.ten, hd.diem " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = 2 AND svhd.trangThai = 1 ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);

        return query.getResultList();

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu3(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.ten, hd.diem " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = 3 AND svhd.trangThai = 1 ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);

        return query.getResultList();

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu4(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.ten, hd.diem " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = 4 AND svhd.trangThai = 1 ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);

        return query.getResultList();

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu5(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.ten, hd.diem " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = 5 AND svhd.trangThai = 1 ";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);

        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu1(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = : hocKiNamHocId AND d.id = 1 "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu2(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = : hocKiNamHocId AND d.id = 2 "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu3(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = : hocKiNamHocId AND d.id = 3 "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu4(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = : hocKiNamHocId AND d.id = 4 "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu5(int sinhVienId, int hocKiNamHocId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = : hocKiNamHocId AND d.id = 5 "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        return query.getResultList();

    }

    public List<Object[]> getTongDiemTheoDieu(int sinhVienId, int hocKiNamHocId, int dieu) {
        Session s = factory.getObject().getCurrentSession();
        String HQL
                = "SELECT sv.id, d.dieu, d.diemToiDa, SUM(hd.diem) "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND d.id = :dieu "
                + "GROUP BY sv.id, d.dieu, d.diemToiDa";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhVienId);
        query.setParameter("hocKiNamHocId", hocKiNamHocId);
        query.setParameter("dieu", dieu);
        return query.getResultList();
    }

    public List<Object[]> laydanhsachbaothieu(int hockiId, int sinhvienId, int dieuId) {
        Session s = factory.getObject().getCurrentSession();
        String HQL = "SELECT hd.id, hd.ten, hd.diem  FROM HoatDong hd WHERE hd.hocKiNamHocId.id = :hocKiNamHocId AND hd.dieuId.id = :dieu AND hd NOT IN (SELECT hd " + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hd.dieuId d "
                + "WHERE sv.id = :sinhVienId AND hn.id = :hocKiNamHocId AND svhd.trangThai = 1 AND d.id = :dieu)";
        Query query = s.createQuery(HQL);
        query.setParameter("sinhVienId", sinhvienId);
        query.setParameter("hocKiNamHocId", hockiId);
        query.setParameter("dieu", dieuId);

        return query.getResultList();
    }

    public void taoBaoThieu(SinhVienHoatDong svhd) {
        BaoThieu baothieu = new BaoThieu();

        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM SinhVienHoatDong WHERE hoatDongId = :hoatDongId AND sinhVienId = :sinhVienId");
        query.setParameter("hoatDongId", svhd.getHoatDongId());
        query.setParameter("sinhVienId", svhd.getSinhVienId());
        SinhVienHoatDong h = (SinhVienHoatDong) query.uniqueResult();

        if (h == null) {
            s.save(svhd);
            baothieu.setSinhVienHoatDongId(svhd);
            baothieu.setActive((short) 1);
            s.save(baothieu);
        } else {
            baothieu.setSinhVienHoatDongId(h);
            baothieu.setActive((short) 1);
            s.save(baothieu);
        }
    }



}
