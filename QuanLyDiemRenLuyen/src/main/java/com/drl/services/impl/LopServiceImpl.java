/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.Lop;
import com.drl.repositories.LopRepository;
import com.drl.services.LopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LopServiceImpl implements LopService {
    @Autowired
    private LopRepository lopRepo;

    @Override
    public List<Lop> getLops() {
        return this.lopRepo.getLops();
    }

    @Override
    public Lop getLopById(int id) {
        return this.lopRepo.getLopById(id);
    }
    
    
}
