/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.Dieu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class DieuFormatter implements Formatter<Dieu>{
            @Override
    public String print(Dieu dieu, Locale locale) { // Đẩy đối tượng lên web
        return String.valueOf(dieu.getId());
    }

    @Override // Lấy đối tượng trên web về -> Chuyển vè đối tượng
    public Dieu parse(String id, Locale locale) throws ParseException {
        Dieu c = new Dieu();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
}
