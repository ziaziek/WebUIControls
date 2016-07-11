/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.pdfmanipulate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Przemo
 */
public class FormularzBuilder {
    
    public static final String pageSign = "[Page]";
    
    public static Formularz build(final String path, final String nazwa) throws FileNotFoundException, IOException{
        Formularz f = new Formularz();
        f.setNazwa(nazwa);
        File r = new File(path);
        FormPage p=null;
        if(r.exists()){           
            BufferedReader reader = new BufferedReader(new FileReader(r));
            String line = reader.readLine();
            while(line!=null){
                String[] w = line.split(",");
                if(w.length==1 && w[0].equals(pageSign)){
                    p = addNewPage(f);
                }
                if(w.length==5 && p!=null && p.getPola()!=null){
                    p.getPola().add(new Pole(Integer.valueOf(w[1]), Integer.valueOf(w[2]), w[0], w[3], w[4].equals("T")));  
                }
                line=reader.readLine();
            }           
        } else {
            System.out.println("File does not exist "+r.getPath());
        }
        return f;
    }
   
    private static FormPage addNewPage(final Formularz formularz){
        FormPage p = new FormPage(); 
        p.setPola(new ArrayList<>());
        formularz.getPages().add(p);       
        return p;
    }
}
