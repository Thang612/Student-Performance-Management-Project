/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface NguoiDungService extends UserDetailsService{
    NguoiDung getNguoiDungByUsername(String username);
    void addTroLy(NguoiDung nd, int khoaId);
    void addNguoiDung(NguoiDung nd);
}
