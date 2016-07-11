/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.pdfmanipulate;

/**
 *
 * @author Przemo
 */
public class Pole {
    
    private int pozycjaX, pozycjaY;
    private String oznaczenie, wartosc;
    private boolean rightAlign;

    public boolean isRightAlign() {
        return rightAlign;
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }
    
    public int getPozycjaX() {
        return pozycjaX;
    }

    public void setPozycjaX(int pozycjaX) {
        this.pozycjaX = pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public void setPozycjaY(int pozycjaY) {
        this.pozycjaY = pozycjaY;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }

    public void setOznaczenie(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }
    
    public Pole(){};
    
    public Pole(int x, int y, String oznaczenie, String wartosc, boolean rightAlign){
        this.pozycjaX=x;
        this.pozycjaY=y;
        this.oznaczenie=oznaczenie;
        this.wartosc=wartosc;
        this.rightAlign=rightAlign;
    }
}
