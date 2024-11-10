/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.NamHoc;
import com.drl.repositories.NamHocRepository;
import com.drl.services.NamHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class NamHocServiceImpl implements NamHocService {

    @Autowired
    private NamHocRepository namHocRepo;
    @Override
    public List<NamHoc> getNamHocs() {
        return this.namHocRepo.getNamHocs();
    }

    @Override
    public NamHoc getNamHocById(int id) {
        return this.namHocRepo.getNamHocById(id);
    }
    

}
