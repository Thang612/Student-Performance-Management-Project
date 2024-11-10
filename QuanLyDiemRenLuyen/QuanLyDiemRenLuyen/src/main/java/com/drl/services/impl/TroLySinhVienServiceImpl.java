/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.TroLySinhVien;
import com.drl.repositories.TroLySinhVienRepository;
import com.drl.services.TroLySinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TroLySinhVienServiceImpl implements TroLySinhVienService{

    @Autowired
    private TroLySinhVienRepository troLySinhVienRepo;
    @Override
    public List<TroLySinhVien> getTroLys() {
        return this.troLySinhVienRepo.getTroLys();
    }
    
}
