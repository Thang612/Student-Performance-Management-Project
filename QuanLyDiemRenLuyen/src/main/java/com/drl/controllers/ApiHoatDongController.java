/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.services.HoatDongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiHoatDongController {
        @Autowired
    private HoatDongService hoatDongService;
    @GetMapping("/hoatdongs/")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> list(@RequestParam("hocki") int hocki, @RequestParam("sinhvien") int sinhvien) {
        return new ResponseEntity<>(this.hoatDongService.getAllHoatDongTheoSinhVien(hocki, sinhvien), HttpStatus.OK);
    }
    
    @GetMapping("/hoatdongs/chuadangky")
    @CrossOrigin
    public ResponseEntity<List<HoatDong>> listDsChuaDky(@RequestParam("hocki") int hocki, @RequestParam("sinhvien") int sinhvien) {
        return new ResponseEntity<>(this.hoatDongService.getHoatDongDangKy(hocki, sinhvien), HttpStatus.OK);
    }
    
    @PostMapping("/hoatdongs/")
    @CrossOrigin
    public ResponseEntity<SinhVienHoatDong> createSinhVienHoatDong(@RequestBody SinhVienHoatDong svhd) {
        try {
            SinhVienHoatDong newHoatDong = hoatDongService.taoDangKySuKien(svhd);
            return new ResponseEntity<>(newHoatDong, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
