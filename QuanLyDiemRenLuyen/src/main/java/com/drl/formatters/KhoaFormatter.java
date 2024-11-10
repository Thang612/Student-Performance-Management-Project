/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.Khoa;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class KhoaFormatter implements Formatter<Khoa>{
        @Override
    public String print(Khoa khoa, Locale locale) { // Đẩy đối tượng lên web
        return String.valueOf(khoa.getId());
    }

    @Override // Lấy đối tượng trên web về -> Chuyển vè đối tượng
    public Khoa parse(String id, Locale locale) throws ParseException {
        Khoa c = new Khoa();
        c.setId(Integer.parseInt(id));
        return c;
    }

}
