/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.pdfmanipulate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Przemo
 */
public class Formularz {
    
    private List<FormPage> pages = new ArrayList<>();

    public List<FormPage> getPages() {
        return pages;
    }

    public void setPages(List<FormPage> pages) {
        this.pages = pages;
    }
    
    

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    private String nazwa;
    
    public Formularz(){
        
    }
    
    public Formularz(List<FormPage> pages, String nazwa){
        this.nazwa=nazwa;
        this.pages=pages;
    }
}
