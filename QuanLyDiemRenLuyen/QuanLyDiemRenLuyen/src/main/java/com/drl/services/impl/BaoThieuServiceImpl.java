/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.BaoThieu;
import com.drl.repositories.BaoThieuRepository;
import com.drl.services.BaoThieuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BaoThieuServiceImpl implements BaoThieuService{
    @Autowired
    private BaoThieuRepository baoThieurepo;
    @Override
    public List<BaoThieu> getBaoThieus(Map<String, String> params) {
        return this.baoThieurepo.getBaoThieus(params);
    }

    @Override
    public void updateBaoThieu(int id) {
        this.baoThieurepo.updateBaoThieu(id);
    }

    @Override
    public void deleteBaoThieu(int id) {
        this.baoThieurepo.deleteBaoThieu(id);
    }
    
    
    
}
