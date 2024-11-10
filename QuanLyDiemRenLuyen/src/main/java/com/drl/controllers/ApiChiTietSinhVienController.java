/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.SinhVienHoatDong;
import com.drl.services.ChiTietSinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiChiTietSinhVienController {
    @Autowired
    private ChiTietSinhVienService chiTietSinhVienService;
    @GetMapping("/ketquarenluyen/{id}")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listChiTiet(@RequestParam("hocki") int hocki, @RequestParam("sinhvien") int sinhvien, @PathVariable("id") int id) {
        switch (id) {
            case 1:
                return new ResponseEntity<>(this.chiTietSinhVienService.getDiemRenLuyenTheoDieu1(hocki, sinhvien), HttpStatus.OK);
            case 2:
                return new ResponseEntity<>(this.chiTietSinhVienService.getDiemRenLuyenTheoDieu2(hocki, sinhvien), HttpStatus.OK);
            case 3:
                return new ResponseEntity<>(this.chiTietSinhVienService.getDiemRenLuyenTheoDieu3(hocki, sinhvien), HttpStatus.OK);
            case 4:
                return new ResponseEntity<>(this.chiTietSinhVienService.getDiemRenLuyenTheoDieu4(hocki, sinhvien), HttpStatus.OK);
            case 5:
                return new ResponseEntity<>(this.chiTietSinhVienService.getDiemRenLuyenTheoDieu5(hocki, sinhvien), HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/ketquarenluyen/dieu/{id}")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listDieu(@RequestParam("hocki") int hocki, @RequestParam("sinhvien") int sinhvien, @PathVariable("id") int id) {
        return new ResponseEntity<>(this.chiTietSinhVienService.getTongDiemTheoDieu(hocki, sinhvien, id), HttpStatus.OK);
    }
    
    
    @GetMapping("/baothieu/{id}")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listBaoThieu(@RequestParam("hocki") int hocki, @RequestParam("sinhvien") int sinhvien, @PathVariable("id") int id) {
        return new ResponseEntity<>(this.chiTietSinhVienService.laydanhsachbaothieu(hocki, sinhvien, id), HttpStatus.OK);
    }
    
    
    @PostMapping("/baothieu/")
    @CrossOrigin
    public ResponseEntity<String> createBaoThieu(@RequestBody SinhVienHoatDong svhd) {
        try {
             chiTietSinhVienService.taoBaoThieu(svhd);
            return new ResponseEntity<>("Tao Thanh Cong", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
