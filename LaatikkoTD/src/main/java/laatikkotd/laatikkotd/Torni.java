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
    
    public Torni(int sijainti) {
        this.sijainti = sijainti;
        this.voima = 2;
    }
    
    /**
    * Metodi palauttaa tornin sijainnin kokonaislukuna. Arvo on välillä
    * 0-10
    */
    public int haeSijainti() {
        return this.sijainti;
    }
    
    /**
    * Metodi "ampuu" palauttamalla tornin "voiman" kokonaislukuna
    * 
    * @return this.voima (int)
    */
    public int ammu() {
        return this.voima;
    }
}
