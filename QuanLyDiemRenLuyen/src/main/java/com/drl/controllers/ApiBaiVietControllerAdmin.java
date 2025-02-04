/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
public class ApiBaiVietControllerAdmin {

    @Autowired
    private BaiVietService baiVietService;

    @DeleteMapping("/admin/baiviets/{baivietid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateView(Model model, @PathVariable(value = "baivietid") int id) {
        this.baiVietService.deleteBaiViet(id);
    }
}
