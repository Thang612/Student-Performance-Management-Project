/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.Comment;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BinhLuanRepository {
    public List<Comment> layBinhLuan(int baiVietId);
    public List<Comment> layBinhLuanCon(int binhLuanId);
    public Comment taoBinhLuan(Comment comment);

    
}
