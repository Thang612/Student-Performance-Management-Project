/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.repositories.StatsRepository;
import com.drl.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
        return this.statsRepo.statsDiemRenLuyenTheoKhoa();

    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoKhoa(int min, int max,int hocKi, int namHoc) {
        return this.statsRepo.statsDiemRenLuyenTheoThanhTichVaTheoKhoa(min, max, hocKi, namHoc);
        
    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoLop(int min, int max, int hocKi, int namHoc, int khoaId) {
        return this.statsRepo.statsDiemRenLuyenTheoThanhTichVaTheoLop(min, max, hocKi, namHoc, khoaId);
    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTich(int min, int max, int hocKi, int namHoc, int lopId) {
        return this.statsRepo.statsDiemRenLuyenTheoThanhTich(min, max, hocKi, namHoc, lopId);
    }

}
