/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.NguoiDung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class NguoiDungFormatter implements Formatter<NguoiDung> {

    @Override
    public String print(NguoiDung object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public NguoiDung parse(String id, Locale locale) throws ParseException {
                NguoiDung c = new NguoiDung();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
}
