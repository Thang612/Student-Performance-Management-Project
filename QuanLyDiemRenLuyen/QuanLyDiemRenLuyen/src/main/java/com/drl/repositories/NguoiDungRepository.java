/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.NguoiDung;

/**
 *
 * @author DELL
 */
public interface NguoiDungRepository {
    NguoiDung getNguoiDungByUsername(String username);
    void addTroLy(NguoiDung nd, int khoaId);
    void addNguoiDung(NguoiDung nd);
}
