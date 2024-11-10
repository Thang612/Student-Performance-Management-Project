/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.HoatDong;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class HoatDongFormatter implements Formatter<HoatDong>{
        @Override
    public String print(HoatDong object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public HoatDong parse(String id, Locale locale) throws ParseException {
        HoatDong c = new HoatDong();
        c.setId(Integer.parseInt(id));
        return c;
    }
}
