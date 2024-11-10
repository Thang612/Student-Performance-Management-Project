/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.HoatDongRepository;
import com.drl.services.HoatDongService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class HoatDongServiceImpl implements HoatDongService{
    @Autowired
    private HoatDongRepository hoatDongRepo;

    @Override
    public List<HoatDong> getHoatDongs(Map<String, String> params) {
        return this.hoatDongRepo.getHoatDongs(params);
    }

    @Override
    public void addOrUpdate(HoatDong h) {
        this.hoatDongRepo.addOrUpdate(h);
    }

    @Override
    public HoatDong getHoatDongByIDd(int id) {
        return this.hoatDongRepo.getHoatDongByIDd(id);
    }

    @Override
    public void deleteHoatDong(int id) {
        this.hoatDongRepo.deleteHoatDong(id);
    }

    @Override
    public List<HoatDong> getAllHoatDongs() {
        return this.hoatDongRepo.getAllHoatDongs();
    }

    @Override
    public List<Object[]> getAllHoatDongTheoSinhVien(int hocki, int sinhvien) {
        return this.hoatDongRepo.getAllHoatDongTheoSinhVien(hocki, sinhvien);
    }

    @Override
    public List<HoatDong> getHoatDongDangKy(int hocki, int sinhvien) {
        return this.hoatDongRepo.getHoatDongDangKy(hocki, sinhvien);
    }

    @Override
    public SinhVienHoatDong taoDangKySuKien(SinhVienHoatDong svhd) {
        return this.hoatDongRepo.taoDangKySuKien(svhd);
    }
    
}
