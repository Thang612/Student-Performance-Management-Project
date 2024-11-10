/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.HocKiNamHoc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class HocKiNamHocFormatter implements Formatter<HocKiNamHoc> {

    @Override
    public String print(HocKiNamHoc object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public HocKiNamHoc parse(String id, Locale locale) throws ParseException {
        HocKiNamHoc c = new HocKiNamHoc();
        c.setId(Integer.parseInt(id));
        return c;
    }

}
