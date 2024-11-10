/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.TroLySinhVien;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class TroLySinhVienFormatter implements Formatter<TroLySinhVien> {

    @Override
    public String print(TroLySinhVien object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public TroLySinhVien parse(String id, Locale locale) throws ParseException {
        TroLySinhVien c = new TroLySinhVien();
        c.setId(Integer.parseInt(id));
        return c;
    }

}
