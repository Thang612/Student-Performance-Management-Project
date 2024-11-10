/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.services.NguoiDungService;
import com.drl.services.SinhVienHoatDongService;
import java.io.IOException;
import javax.validation.Valid;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author DELL
 */
@Controller
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungservice;
    @Autowired
    private SinhVienHoatDongService svhdService;

    @GetMapping("/admin/troly")
    public String createView(Model model) {
        model.addAttribute("nguoidung", new NguoiDung());
        return "troly";
    }

    @PostMapping("/admin/troly")
    public String createTroLy(@ModelAttribute(value = "nguoidung") @Valid NguoiDung nguoidung, BindingResult rs, @RequestParam("khoaId") int khoaId) {
        if (!rs.hasErrors()) {
            try {
                System.out.println(nguoidung.getHo());
                System.out.println(nguoidung.getNamSinh());

                this.nguoiDungservice.addTroLy(nguoidung, khoaId);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "troly";
    }

    @GetMapping("/login")
    public String loginAdmin() {
        return "login";
    }

    @GetMapping("/admin/napdiem")
    public String napDiemView() {
        return "napdiem";
    }

    @PostMapping("/admin/napdiem")
    public String napDiem(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            // Xử lý khi file rỗng
            System.out.print("KHONG CO FILE");
            return "napdiem";
        } else {
            System.out.println("DA CO FILE");
            try {
                // Đọc file Excel
                Workbook workbook = WorkbookFactory.create(file.getInputStream());
                Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
                boolean firstRow = true;

                for (Row row : sheet) {
                    if (firstRow) {
                        firstRow = false;
                        continue; // Bỏ qua dòng đầu tiên (tiêu đề)
                    }
                    if (row != null) {
                        // Duyệt qua từng ô của hàng
                        Cell mssvCell = row.getCell(0); // Lấy ô đầu tiên (MSSV)
                        Cell hoatDongIDCell = row.getCell(1); // Lấy ô thứ hai (Hoạt Động ID)
                        System.out.println(); // Xuống dòng sau khi duyệt hết các ô của một hàng
                        if (mssvCell != null && hoatDongIDCell != null) {
                            int mssv = (int) mssvCell.getNumericCellValue();
                            int hoatDongID = (int) hoatDongIDCell.getNumericCellValue();

                            if (this.svhdService.getHoatDongSinhVien(mssv, hoatDongID) == null) {
                                System.out.println("KHONG TIM THAY");
                                this.svhdService.addSinhVienHoatDong(mssv, hoatDongID);

                            } else {
                                System.out.println("DA TIM THAY");
                                SinhVienHoatDong svhd = this.svhdService.getHoatDongSinhVien(mssv, hoatDongID);
                                svhd.setTrangThai(Boolean.TRUE);
                                this.svhdService.updateSinhVienHoatDong(svhd);
                            }

                        }
                    }
                } 
            } catch (Exception e) {
                // Xử lý nếu có lỗi xảy ra khi đọc file Excel
                System.out.println(e.getMessage());
            }
        }
        return "napdiem";
    }

}
