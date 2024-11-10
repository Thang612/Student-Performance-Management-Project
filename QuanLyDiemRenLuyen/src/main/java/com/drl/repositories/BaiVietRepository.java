/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.BaiViet;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BaiVietRepository {
        public void addOrUpdate(BaiViet b);
        public List<BaiViet> getAllBaiViets();
public BaiViet getBaiVietById(int id);
public void deleteBaiViet(int id);

}
