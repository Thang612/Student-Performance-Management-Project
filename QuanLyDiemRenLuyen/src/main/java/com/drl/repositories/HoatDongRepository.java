/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVienHoatDong;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface HoatDongRepository {

    List<HoatDong> getHoatDongs(Map<String, String> params);

    void addOrUpdate(HoatDong h);

    HoatDong getHoatDongByIDd(int id);

    void deleteHoatDong(int id);

    List<HoatDong> getAllHoatDongs();

    public List<Object[]> getAllHoatDongTheoSinhVien(int hocki, int sinhvien);

    public List<HoatDong> getHoatDongDangKy(int hocki, int sinhvien);

    public SinhVienHoatDong taoDangKySuKien(SinhVienHoatDong svhd);

}
