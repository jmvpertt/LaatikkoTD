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
    
    public Torni(int sijainti) {
        this.sijainti = sijainti;
    }
    
    /**
    * Metodi palauttaa tornin sijainnin kokonaislukuna. Arvo on välillä
    * 0-10
    */
    public int haeSijainti() {
        return this.sijainti;
    }
    
    /**
    * Metodi "ampuu" palauttamalla tornin sijainnin kokonaislukuna
    * Arvo on välillä 0-10
    */
    public int ammu() {
        return this.sijainti;
    }
}
