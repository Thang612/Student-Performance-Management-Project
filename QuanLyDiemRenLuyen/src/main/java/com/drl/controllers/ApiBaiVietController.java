/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.BaiViet;
import com.drl.services.BaiVietService;
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
public class ApiBaiVietController {
    @Autowired
    private BaiVietService baiVietService;
    @GetMapping("/baiviets/")
    @CrossOrigin
    public ResponseEntity<List<BaiViet>> list() {
        return new ResponseEntity<>(this.baiVietService.getAllBaiViets(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/baiviets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<BaiViet> getBaiVietById(@PathVariable(value = "id") int id) {
        BaiViet baiViet = baiVietService.getBaiVietById(id);
        if (baiViet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(baiViet, HttpStatus.OK);
    }
}
