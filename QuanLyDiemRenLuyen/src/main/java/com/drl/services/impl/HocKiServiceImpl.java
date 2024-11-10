/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.HocKi;
import com.drl.repositories.HocKiRepository;
import com.drl.services.HocKiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class HocKiServiceImpl implements HocKiService{
    @Autowired
    private HocKiRepository hocKiRepo;

    @Override
    public List<HocKi> getHocKis() {
        return this.hocKiRepo.getHocKis();
    }
}
