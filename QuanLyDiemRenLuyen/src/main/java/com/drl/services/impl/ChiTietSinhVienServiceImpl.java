/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.ChiTietSinhVienRepository;
import com.drl.services.ChiTietSinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ChiTietSinhVienServiceImpl implements ChiTietSinhVienService {

    @Autowired
    private ChiTietSinhVienRepository chiTietSvRepo;

    @Override
    public List<Object[]> getChiTietSinhViens(int sinhVienId) {
        return this.chiTietSvRepo.getChiTietSinhViens(sinhVienId);
    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu1(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getDiemRenLuyenTheoDieu1(sinhVienId, hocKiNamHocId);
    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu2(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getDiemRenLuyenTheoDieu2(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu3(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getDiemRenLuyenTheoDieu3(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu4(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getDiemRenLuyenTheoDieu4(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getDiemRenLuyenTheoDieu5(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getDiemRenLuyenTheoDieu5(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getTongDiemTheoDieu1(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getTongDiemTheoDieu1(sinhVienId, hocKiNamHocId);
    }

    @Override
    public List<Object[]> getTongDiemTheoDieu2(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getTongDiemTheoDieu2(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getTongDiemTheoDieu3(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getTongDiemTheoDieu3(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getTongDiemTheoDieu4(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getTongDiemTheoDieu4(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getTongDiemTheoDieu5(int sinhVienId, int hocKiNamHocId) {
        return this.chiTietSvRepo.getTongDiemTheoDieu5(sinhVienId, hocKiNamHocId);

    }

    @Override
    public List<Object[]> getTongDiemTheoDieu(int sinhVienId, int hocKiNamHocId, int dieu) {
        return this.chiTietSvRepo.getTongDiemTheoDieu(sinhVienId, hocKiNamHocId, dieu);
    }

    @Override
    public List<Object[]> laydanhsachbaothieu(int hockiId, int sinhvienId, int dieuId) {
        return this.chiTietSvRepo.laydanhsachbaothieu(hockiId, sinhvienId, dieuId);
    }

    @Override
    public void taoBaoThieu(SinhVienHoatDong svhd) {
         this.chiTietSvRepo.taoBaoThieu(svhd);
    }

}
