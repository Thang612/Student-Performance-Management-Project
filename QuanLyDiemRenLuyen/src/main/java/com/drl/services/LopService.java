/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.Lop;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface LopService{
    List<Lop> getLops();
    public Lop getLopById(int id);
}
