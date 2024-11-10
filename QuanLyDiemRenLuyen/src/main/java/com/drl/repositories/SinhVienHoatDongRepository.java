/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;

/**
 *
 * @author DELL
 */
public interface SinhVienHoatDongRepository {

    void addSinhVienHoatDong(int svId, int hdId);
    SinhVienHoatDong getHoatDongSinhVien (int svId, int hdId);
    void updateSinhVienHoatDong(SinhVienHoatDong svhd);
}
