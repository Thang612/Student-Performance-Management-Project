/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.HocKiNamHoc;
import com.drl.services.HocKiNamHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiHocKiNamHocController {
        @Autowired
    private  HocKiNamHocService hocKiNamHocService;
    
    @GetMapping("/hockinamhoc/")
    @CrossOrigin
    public ResponseEntity<List<HocKiNamHoc>> list() {
        return new ResponseEntity<>(this.hocKiNamHocService.getHocKiNamHocs(), HttpStatus.OK);
    }
}
