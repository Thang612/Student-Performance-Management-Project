/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.BaiViet;
import com.drl.repositories.BaiVietRepository;
import com.drl.services.BaiVietService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BaiVietServiceImpl implements BaiVietService {
    @Autowired
    private BaiVietRepository baiVietRepo;
    @Override
        public void addOrUpdate(BaiViet b) {
            this.baiVietRepo.addOrUpdate(b);
        }

    @Override
    public List<BaiViet> getAllBaiViets() {
        return this.baiVietRepo.getAllBaiViets();
    }

    @Override
    public BaiViet getBaiVietById(int id) {
        return this.baiVietRepo.getBaiVietById(id);
    }

    @Override
    public void deleteBaiViet(int id) {
        this.baiVietRepo.deleteBaiViet(id);
    }
        

}
