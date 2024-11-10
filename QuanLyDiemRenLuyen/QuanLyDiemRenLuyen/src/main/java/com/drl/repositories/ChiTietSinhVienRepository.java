/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.SinhVienHoatDong;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ChiTietSinhVienRepository {

    List<Object[]> getChiTietSinhViens(int sinhVienId);

    List<Object[]> getDiemRenLuyenTheoDieu1(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getDiemRenLuyenTheoDieu2(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getDiemRenLuyenTheoDieu3(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getDiemRenLuyenTheoDieu4(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getDiemRenLuyenTheoDieu5(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getTongDiemTheoDieu1(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getTongDiemTheoDieu2(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getTongDiemTheoDieu3(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getTongDiemTheoDieu4(int sinhVienId, int hocKiNamHocId);

    List<Object[]> getTongDiemTheoDieu5(int sinhVienId, int hocKiNamHocId);
    public List<Object[]> getTongDiemTheoDieu(int sinhVienId, int hocKiNamHocId, int dieu);
    public List<Object[]> laydanhsachbaothieu(int hockiId, int sinhvienId, int dieuId);
    public void taoBaoThieu(SinhVienHoatDong svhd);

}
