/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.pdfmanipulate;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;

/**
 *
 * @author Przemo
 */
public class PDFBuilder {

    public static PDDocument build(final String sourcePath, final Formularz form) throws IOException {
        PDDocument doc = PDDocument.load(new File(sourcePath));
        renderForm(form, doc);
        return doc;
    }

    private static void renderForm(Formularz form, PDDocument doc) throws IOException {
        int i = 0;
        PDFont f = PDType1Font.HELVETICA;
        float fontSize = 17.0f;
        for (FormPage page : form.getPages()) {
            PDPage pag = doc.getPage(i);
            PDRectangle pageSize = pag.getMediaBox();
            try (PDPageContentStream contentStream = new PDPageContentStream(doc, pag, PDPageContentStream.AppendMode.APPEND, false)) {
                contentStream.setFont(f, fontSize);
                contentStream.beginText();
                contentStream.setNonStrokingColor(Color.black);
                for (Pole p : page.getPola()) {
                    int x = p.getPozycjaX();
                    if(p.isRightAlign()){
                        x-=f.getStringWidth(p.getWartosc())/1000*fontSize;
                    }
                    contentStream.setTextMatrix(Matrix.getTranslateInstance(x, pageSize.getHeight() - p.getPozycjaY()));
                    contentStream.showText(p.getWartosc());
                }
                contentStream.endText();
            }
            i++;
        }

    }
}
