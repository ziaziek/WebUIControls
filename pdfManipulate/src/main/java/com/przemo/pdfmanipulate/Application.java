/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.pdfmanipulate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Przemo
 */
public class Application {

    static float ph = 0.0f; //page height

    public static void main(String[] arg) {
        
        try {
            PDDocument doc = PDFBuilder.build("H:\\dra.pdf", FormularzBuilder.buildAndFill("H:\\zusdra2", "ZUS DRA", new FlatFileFormDataProvider("H:\\dra_dane")));
            if(doc!=null){
                doc.save("H:\\draY2.pdf");
            }
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
