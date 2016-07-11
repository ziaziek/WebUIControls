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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Przemo
 */
public class FlatFileFormDataProvider implements IFormDataProvider {

    private File file;
    private Map<String, String> wartosciPol;

    public FlatFileFormDataProvider(final String fileLocation) throws IOException {
        file = new File(fileLocation);
        if (!file.exists()) {
            throw new IOException("File does not exist.");
        }
    }

    @Override
    public void wypelnijPolaDanymi(Formularz form) {
        if (wartosciPol != null && !wartosciPol.isEmpty()) {
            form.getPages().stream().forEach((p) -> {
                p.getPola().stream().forEach((pl) -> {
                    pl.setWartosc(wartosciPol.get(pl.getOznaczenie()));
                });
            });
        }
    }

    @Override
    public void wczytajDane() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String l = reader.readLine();
            wartosciPol = new HashMap<>();
            while (l != null) {
                String[] s = l.split(",");
                if (s.length == 2) {
                    wartosciPol.put(s[0], s[1]);
                }
                l=reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlatFileFormDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlatFileFormDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
