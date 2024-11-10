/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.Dieu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drl.services.DieuService;
import com.drl.repositories.DieuRepository;

/**
 *
 * @author DELL
 */
@Service
public class DieuServiceImpl implements DieuService{
    @Autowired
    private DieuRepository dieuRepo;
    @Override
    public List<Dieu> getDieus() {
        return this.dieuRepo.getDieus();
    }
    
}
