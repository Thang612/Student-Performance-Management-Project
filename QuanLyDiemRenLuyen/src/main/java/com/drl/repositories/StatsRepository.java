/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import java.util.List;

/**
 *
 * @author DELL
 */
public interface StatsRepository {
    List<Object[]> statsDiemRenLuyenTheoKhoa();
    List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoKhoa(int min, int max, int hocKi, int namHoc);
    List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoLop(int min, int max, int hocKi, int namHoc, int khoaId);
     List<Object[]> statsDiemRenLuyenTheoThanhTich(int min, int max, int hocKi, int namHoc, int lopId);
}
