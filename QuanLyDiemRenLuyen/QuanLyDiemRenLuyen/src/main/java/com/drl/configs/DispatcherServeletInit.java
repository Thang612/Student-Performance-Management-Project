/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author DELL
 */
//Nơi đầu não hệ thống, xử lý các request
public class DispatcherServeletInit extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
        HibernateConfig.class,
         TilesConfig.class,
         SpringSecurityConfig.class
                
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            WebApplicationContextConfig.class
        };
        
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};     
    }
    
}
