/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

/**
 *
 * @author juha
 */
public class Torni {
    
    private int sijainti;
    private int voima;
    private String merkki;
    
    
    /**
     * Luokka luo torni-olioita. Konstruktorille annetaan olion toivottu
     * sijainti. Olion muut attribuutit ovat voima ja merkki.
     * @param sijainti torni-olion sijainti torniArray-taulukossa
     * 
     * @see laatikkotd.laatikkotd.Pelinappulat#torniArray
     */
    public Torni(int sijainti) {
        this.sijainti = sijainti;
        this.voima = 1;
        this.merkki = "T";
    }
    
    public int getSijainti() {
        return this.sijainti;
    }
    
    public int getVoima() {
        return this.voima;
    }
    
    /**
     * Metodi "ylentää" tornin asettamalla sen merkki-attribuutiksi "T+" ja
     * lisäämällä voima-attribuuttiin +1. Jos Torni on jo ylennetty, metodi
     * ei tee mitään.
     */
    public void ylenna() {
        if (this.merkki == "T") {
            this.merkki = this.merkki+"+";
            this.voima = 2;
        } 
    }
    
    @Override
    public String toString() {
        return ""+this.merkki;
    }
}
