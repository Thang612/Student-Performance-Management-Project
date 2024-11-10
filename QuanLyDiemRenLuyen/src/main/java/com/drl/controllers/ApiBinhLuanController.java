/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.Comment;
import com.drl.services.BinhLuanService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiBinhLuanController {
    @Autowired
    private BinhLuanService binhLuanService;
    
    @GetMapping("/binhluans/{baiVietId}")
    @CrossOrigin
    public ResponseEntity<List<Comment>> list(@PathVariable(value = "baiVietId") int baiVietId) {
        return new ResponseEntity<>(this.binhLuanService.layBinhLuan(baiVietId), HttpStatus.OK);
    }
    
        @GetMapping("/binhLuanCon/{binhluanId}")
    @CrossOrigin
    public ResponseEntity<List<Comment>> subComment(@PathVariable(value = "binhluanId") int binhluanId) {
        return new ResponseEntity<>(this.binhLuanService.layBinhLuanCon(binhluanId), HttpStatus.OK);
    }
    
    @PostMapping("/binhluans/")
    @CrossOrigin
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        try {
            Comment newComment = binhLuanService.taoBinhLuan(comment);
            return new ResponseEntity<>(newComment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
