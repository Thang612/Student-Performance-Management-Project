/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.drl.services.DieuService;
import com.drl.services.HoatDongService;
import com.drl.services.HocKiNamHocService;
import com.drl.services.HocKiService;
import com.drl.services.KhoaService;
import com.drl.services.LopService;
import com.drl.services.NamHocService;
import com.drl.services.TroLySinhVienService;
import java.util.Locale;
import java.util.Map;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private DieuService dieuService;
    @Autowired
    private HoatDongService hoatDongService;

    @Autowired
    private HocKiNamHocService hocKiNamHocService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private TroLySinhVienService troLySinhVienService;

    @Autowired
    private HocKiService hocKiService;
    @Autowired
    private NamHocService namHocService;

    @Autowired
    private LopService lopService;

    @Autowired
    private BaiVietService baiVietService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params,
            @RequestParam(name = "lang", required = false) String lang) {

        model.addAttribute("hoatDongs", this.hoatDongService.getHoatDongs(params));
        return "index";//Tìm trong tiles
    }

    @ModelAttribute//Tất cả các response trong Controller này sẽ có thông tin này, gắn ControllerAdvice sẽ dùng ModelAt tribute chung cho các controller khác
    public void commonAttribute(Model model, Locale locale) {
        model.addAttribute("dieus", this.dieuService.getDieus());
        model.addAttribute("hocKiNamHocs", this.hocKiNamHocService.getHocKiNamHocs());
        model.addAttribute("khoas", this.khoaService.getKhoas());
        model.addAttribute("troLys", this.troLySinhVienService.getTroLys());
        model.addAttribute("hocKis", this.hocKiService.getHocKis());
        model.addAttribute("namHocs", this.namHocService.getNamHocs());
        model.addAttribute("lops", this.lopService.getLops());
        model.addAttribute("hoatdongs", this.hoatDongService.getAllHoatDongs());

        if (locale == null) {
            locale = Locale.ENGLISH; // hoặc bất kỳ Locale mặc định nào bạn muốn
        }
        String greetingMessage = messageSource.getMessage("greeting", null, locale);
        String ruleMessage = messageSource.getMessage("rule", null, locale);
        String addMessage = messageSource.getMessage("add", null, locale);
        String featureMessage = messageSource.getMessage("feature", null, locale);
        String update = messageSource.getMessage("update", null, locale);
        String delete = messageSource.getMessage("delete", null, locale);
        String name = messageSource.getMessage("name", null, locale);
        String createdDate = messageSource.getMessage("createdDate", null, locale);
        String content = messageSource.getMessage("content", null, locale);
        String activity = messageSource.getMessage("activity", null, locale);
        String addPost = messageSource.getMessage("addPost", null, locale);
        String fullName = messageSource.getMessage("fullname", null, locale);
        String status = messageSource.getMessage("status", null, locale);
        String accept =  messageSource.getMessage("accept", null, locale);
        String process =  messageSource.getMessage("process", null, locale);
        String done =  messageSource.getMessage("done", null, locale);
        String statistic =  messageSource.getMessage("statistic", null, locale);
        String lastname =  messageSource.getMessage("lastname", null, locale);
        String firstname =  messageSource.getMessage("firstname", null, locale);
        String lop =  messageSource.getMessage("lop", null, locale);
        String point =  messageSource.getMessage("point", null, locale);
        String department =  messageSource.getMessage("department", null, locale);
        String detail =  messageSource.getMessage("detail", null, locale);
        String statisticbydepartment = messageSource.getMessage("statisticbydepartment", null, locale);
        String excellent = messageSource.getMessage("excellent", null, locale);
        String verygood = messageSource.getMessage("verygood", null, locale);
        String good = messageSource.getMessage("good", null, locale);
        String choose = messageSource.getMessage("choose", null, locale);
        String achievement = messageSource.getMessage("achievement", null, locale);
        String year = messageSource.getMessage("year", null, locale);
        String semester = messageSource.getMessage("semester", null, locale);
        String filter = messageSource.getMessage("filter", null, locale);
        String number = messageSource.getMessage("number", null, locale);
        String staticsticbyfaculty = messageSource.getMessage("staticsticbyfaculty", null, locale);
        String staticsticbyclass = messageSource.getMessage("staticsticbyclass", null, locale);
        String xuat = messageSource.getMessage("xuat", null, locale);
        String fee = messageSource.getMessage("fee", null, locale);
        String owner = messageSource.getMessage("owner", null, locale);
        String trungbinh = messageSource.getMessage("trungbinh", null, locale);
        String yeu = messageSource.getMessage("yeu", null, locale);
        String kem = messageSource.getMessage("kem", null, locale);

        
        model.addAttribute("greetingMessage", greetingMessage);
        model.addAttribute("ruleMessage", ruleMessage);
        model.addAttribute("addMessage", addMessage);
        model.addAttribute("featureMessage", featureMessage);
        model.addAttribute("update", update);
        model.addAttribute("delete", delete);
        model.addAttribute("name", name);
        model.addAttribute("content", content);
        model.addAttribute("createdDate", createdDate);
        model.addAttribute("activity", activity);
        model.addAttribute("addPost", addPost);
        model.addAttribute("fullname", fullName);
        model.addAttribute("status", status);
        model.addAttribute("accept", accept);
        model.addAttribute("process", process);
        model.addAttribute("done", done);
        model.addAttribute("statistic", statistic);
        model.addAttribute("lastname", lastname);
        model.addAttribute("firstname", firstname);
        model.addAttribute("lop", lop);
        model.addAttribute("point", point);
        model.addAttribute("department", department);
        model.addAttribute("detail", detail);
        model.addAttribute("statisticbydepartment", statisticbydepartment);
        model.addAttribute("excellent", excellent);
        model.addAttribute("verygood", verygood);
        model.addAttribute("good", good);
        model.addAttribute("choose", choose);
        model.addAttribute("achievement", achievement);
        model.addAttribute("year", year);
        model.addAttribute("semester", semester);
        model.addAttribute("filter", filter);
        model.addAttribute("number", number);
        model.addAttribute("staticsticbyfaculty", staticsticbyfaculty);
        model.addAttribute("staticsticbyclass", staticsticbyclass);
        model.addAttribute("xuat", xuat);
        model.addAttribute("fee", fee);
        model.addAttribute("owner", owner);
        model.addAttribute("trungbinh", trungbinh);
        model.addAttribute("yeu", yeu);
        model.addAttribute("kem", kem);



    }
}
