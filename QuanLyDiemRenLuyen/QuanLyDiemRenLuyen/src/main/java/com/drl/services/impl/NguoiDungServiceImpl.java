/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.drl.pojo.NguoiDung;
import com.drl.repositories.NguoiDungRepository;
import com.drl.services.NguoiDungService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class NguoiDungServiceImpl implements NguoiDungService{
        
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private NguoiDungRepository nguoiDungRepo;

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        return this.nguoiDungRepo.getNguoiDungByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung u = this.getNguoiDungByUsername(username);
        if(u ==null)
            throw new UsernameNotFoundException("Khong tim thay nguoi dung");
        Set<GrantedAuthority> a = new HashSet<>();
        a.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new User(u.getUsername(), u.getPassword(), a);
    }

    @Override
    public void addTroLy(NguoiDung nd, int khoaId) {
        if(!nd.getFile().isEmpty()) {
            System.out.println("File da co");
            try {
                Map res = this.cloudinary.uploader().upload(nd.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                nd.setAvatar(res.get("secure_url").toString());
                System.out.println(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                this.nguoiDungRepo.addTroLy(nd,khoaId);

        
    }

    @Override
    public void addNguoiDung(NguoiDung nd) {
        if(!nd.getFile().isEmpty()) {
            System.out.println("File da co");
            try {
                Map res = this.cloudinary.uploader().upload(nd.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                nd.setAvatar(res.get("secure_url").toString());
                System.out.println(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.nguoiDungRepo.addNguoiDung(nd);
    }
    
}
