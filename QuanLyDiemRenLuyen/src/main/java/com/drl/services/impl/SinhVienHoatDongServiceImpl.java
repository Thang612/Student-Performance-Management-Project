/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.SinhVienHoatDongRepository;
import com.drl.services.SinhVienHoatDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class SinhVienHoatDongServiceImpl implements SinhVienHoatDongService{

    @Autowired
    private SinhVienHoatDongRepository repo;

    @Override
    public void addSinhVienHoatDong(int svId, int hdId) {
        this.repo.addSinhVienHoatDong(svId, hdId);
    }

    @Override
    public SinhVienHoatDong getHoatDongSinhVien(int svId, int hdId) {
        return this.repo.getHoatDongSinhVien(svId, hdId);
    }

    @Override
    public void updateSinhVienHoatDong(SinhVienHoatDong svhd) {
        this.repo.updateSinhVienHoatDong(svhd);
    }
    
}
