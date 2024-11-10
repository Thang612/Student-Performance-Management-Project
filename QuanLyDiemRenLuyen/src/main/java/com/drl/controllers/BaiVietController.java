/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.BaiViet;
import com.drl.services.BaiVietService;
import com.drl.services.HoatDongService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class BaiVietController {
    
        @Autowired
    private HoatDongService hoatDongService;
        @Autowired
        private BaiVietService baiVietService;
    @GetMapping("/admin/baiviet")
    public String createView(Model model) {
        model.addAttribute("baiViet", new BaiViet());
        return "baiviet";
    }
    
    @PostMapping("/admin/baiviet")
    public String addBaiViet(@ModelAttribute(value = "baiViet") @Valid BaiViet b, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.baiVietService.addOrUpdate(b);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "baiviet";
    }
    @GetMapping("/admin/baiviets")
    public String showBaiViets(Model model) {
        model.addAttribute("baiViets", this.baiVietService.getAllBaiViets());
        
        return "baiviets";
    }
    @GetMapping("/admin/baiviet/{baiVietId}")
    public String updateView(Model model, @PathVariable(value = "baiVietId") int id) {
                model.addAttribute("baiViet", this.baiVietService.getBaiVietById(id));
                return "baiviet";
    }
}
