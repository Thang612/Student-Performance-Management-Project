/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.Comment;
import com.drl.repositories.BinhLuanRepository;
import com.drl.services.BinhLuanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BinhLuanServiceImpl implements BinhLuanService{
@Autowired
private BinhLuanRepository binhLuanRepo;
    @Override
    public Comment taoBinhLuan(Comment comment) {
        return this.binhLuanRepo.taoBinhLuan(comment);
    }

    @Override
    public List<Comment> layBinhLuan(int baiVietId) {
        return this.binhLuanRepo.layBinhLuan(baiVietId);
    }

    @Override
    public List<Comment> layBinhLuanCon(int binhLuanId) {
        return this.binhLuanRepo.layBinhLuanCon(binhLuanId);
    }
    
}
