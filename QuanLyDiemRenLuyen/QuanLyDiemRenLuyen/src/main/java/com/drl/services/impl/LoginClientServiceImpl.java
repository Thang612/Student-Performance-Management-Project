/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.NguoiDung;
import com.drl.repositories.LoginClientRepository;
import com.drl.services.LoginClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LoginClientServiceImpl implements LoginClientService{
    @Autowired
    private LoginClientRepository loginRepo;

    @Override
    public NguoiDung laySinhVien(String email) {
        return this.loginRepo.laySinhVien(email);
    }
     
}
