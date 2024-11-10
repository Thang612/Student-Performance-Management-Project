/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.HoatDong;
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
public class HoatDongController {
    
    @Autowired
    private HoatDongService hoatDongService;
    
    @GetMapping("/admin/hoatdongs")
    public String createView(Model model) {
        model.addAttribute("hoatDong", new HoatDong());
        return "hoatdongs";
    }
    
    @PostMapping("/admin/hoatdongs")
    public String createHoatDong(@ModelAttribute(value = "hoatDong") @Valid HoatDong h,
            BindingResult rs) { //1. ModelAttribute có 2 công dụng : + 1 là xài chung, 2 là gửi backing beans    Sau đó đóng gói lại đối tượng HoatDong h(Desireilizer)
        //Tất cả lõi sẽ hiện ở BindingResult rs
        if (!rs.hasErrors()) {
            try {
                System.out.println(h.getId());
                System.out.println(h.getTen());
                System.out.println(h.getMoTa());
                
                System.out.println(h.getDiem());
                System.out.println(h.getDieuId());
                System.out.println(h.getHocKiNamHocId());
                System.out.println(h.getKhoaId());
                
                
                System.out.print(h.getTroLyId());
                
                this.hoatDongService.addOrUpdate(h);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "hoatdongs";
    }
    
    @GetMapping("/admin/hoatdongs/{hoatdongId}")
    public String updateView(Model model, @PathVariable(value = "hoatdongId") int id) {
        model.addAttribute("hoatDong", this.hoatDongService.getHoatDongByIDd(id));
        return "hoatdongs";
        
    }
}
