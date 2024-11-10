/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.ChiTietSinhVienService;
import com.drl.services.HoatDongService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class SinhVienController {

    @Autowired
    private ChiTietSinhVienService chiTietSvService;

    @Autowired
    private HoatDongService hoatDongService;

    @GetMapping("/sinhvien/{sinhVienId}")
    public String chiTietSinhVien(Model model, @PathVariable(value = "sinhVienId") int sinhVienId, @RequestParam Map<String, String> params) {
        model.addAttribute("chitiets", this.chiTietSvService.getChiTietSinhViens(sinhVienId));

        int hocKiNamHocId = 1;
        String hocKiNamHocIdString = params.get("hocKiNamHocId");
        if (hocKiNamHocIdString != null) {
            hocKiNamHocId = Integer.parseInt(hocKiNamHocIdString);
        }
        model.addAttribute("hoatdongdieu1s", this.chiTietSvService.getDiemRenLuyenTheoDieu1(sinhVienId, hocKiNamHocId));
        model.addAttribute("hoatdongdieu2s", this.chiTietSvService.getDiemRenLuyenTheoDieu2(sinhVienId, hocKiNamHocId));
        model.addAttribute("hoatdongdieu3s", this.chiTietSvService.getDiemRenLuyenTheoDieu3(sinhVienId, hocKiNamHocId));
        model.addAttribute("hoatdongdieu4s", this.chiTietSvService.getDiemRenLuyenTheoDieu4(sinhVienId, hocKiNamHocId));
        model.addAttribute("hoatdongdieu5s", this.chiTietSvService.getDiemRenLuyenTheoDieu5(sinhVienId, hocKiNamHocId));
        model.addAttribute("diemdieu1", this.chiTietSvService.getTongDiemTheoDieu1(sinhVienId, hocKiNamHocId));
        model.addAttribute("diemdieu2", this.chiTietSvService.getTongDiemTheoDieu2(sinhVienId, hocKiNamHocId));
        model.addAttribute("diemdieu3", this.chiTietSvService.getTongDiemTheoDieu3(sinhVienId, hocKiNamHocId));
        model.addAttribute("diemdieu4", this.chiTietSvService.getTongDiemTheoDieu4(sinhVienId, hocKiNamHocId));
        model.addAttribute("diemdieu5", this.chiTietSvService.getTongDiemTheoDieu5(sinhVienId, hocKiNamHocId));

        return "chitietsinhvien";
    }
}
