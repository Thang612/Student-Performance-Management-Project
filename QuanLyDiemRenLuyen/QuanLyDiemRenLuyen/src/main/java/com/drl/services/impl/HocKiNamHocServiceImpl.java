/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.HocKiNamHoc;
import com.drl.repositories.HocKiNamHocRepository;
import com.drl.services.HocKiNamHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class HocKiNamHocServiceImpl implements HocKiNamHocService{
    @Autowired
    private HocKiNamHocRepository hocKiNamHocRepo;

    @Override
    public List<HocKiNamHoc> getHocKiNamHocs() {
        return this.hocKiNamHocRepo.getHocKiNamHocs();
    }
    
}
