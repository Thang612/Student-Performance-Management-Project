/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.Comment;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BinhLuanService {
    public Comment taoBinhLuan(Comment comment);
        public List<Comment> layBinhLuan(int baiVietId);
    public List<Comment> layBinhLuanCon(int binhLuanId);
}
