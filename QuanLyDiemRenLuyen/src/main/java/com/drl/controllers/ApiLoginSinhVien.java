/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.NguoiDung;
import com.drl.services.LoginClientService;
import com.drl.services.LopService;
import com.drl.services.NamHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiLoginSinhVien {
    @Autowired
    private LoginClientService loginClientService;
    
    @Autowired
    private LopService lopService;
    
    @Autowired
    private NamHocService namHocService;
    
    @GetMapping(path = "/loginSinhVien/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<NguoiDung> nguoidung(@PathVariable(value = "email") String email) {
        NguoiDung nguoiDung = loginClientService.laySinhVien(email);
        if (nguoiDung == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nguoiDung, HttpStatus.OK);
    }
    
    @GetMapping("/dslop/")
    @CrossOrigin
    public ResponseEntity<List<Lop>> dsLop(){
        return new ResponseEntity<>(lopService.getLops(), HttpStatus.OK);
    }
    
    @GetMapping("/dsNamhoc/")
    @CrossOrigin
    public ResponseEntity<List<NamHoc>> dsNamhoc(){
        return new ResponseEntity<>(namHocService.getNamHocs(), HttpStatus.OK);
    }
}
