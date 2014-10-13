/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juha
 */
public class Pelinappulat {

    private int kuolleet;
    private Ukko[] ukkoArray;
    private Torni[] torniArray;
    
    public Pelinappulat() {
        this.kuolleet = 0;
        this.ukkoArray = new Ukko[10];
        this.torniArray = new Torni[10];
    }
    
    /**
    * Metodi lisää torni-olion ArrayList -listalle
    */
    public void lisaaTorni(Torni torni) {
        this.torniArray[torni.haeSijainti()] = torni;
    }
    
    /**
    * Metodi poistaa torni-olion tyhjentämällä koko listan.
    */
    public void poistaTorni(int i) {
        this.torniArray[i] = null;
    }
    
    /**
    * Metodi lisää ukko-olion ArrayList -listalle
    */
    public void lisaaUkko (Ukko ukko) {
        this.ukkoArray[ukko.haeSijainti()] = ukko;
    }
    
    /**
    * Metodi poistaa ukko-olion tyhjentämällä koko listan.
    */
    public void poistaUkko(int i) {
        this.ukkoArray[i] = null;
        this.kuolleet++;
    }
    
    /**
    * Metodi palauttaa ArrayList-listan
    */
    public Torni[] getTorniArray() {
        return this.torniArray;
    }
    
    /**
    * Metodi palauttaa ArrayList-listan
    */
    public Ukko[] getUkkoArray() {
        return this.ukkoArray;
    }
    
    /**
    * Metodi lisää +1 hautausmaalle.
    */
    public void lisaaHautausmaalle() {
        this.kuolleet++;
    }
    
    /**
    * Metodi palauttaa kuolleet kokonaislukuna
    */
    public int getKuolleet() {
        return this.kuolleet;
    }
    
    public void seuraavaVuoro() {
        Ukko[] ukkoArrayApu = new Ukko[10];
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                break;
            }
            ukkoArrayApu[i + 1] = this.ukkoArray[i];
        }
        this.ukkoArray = ukkoArrayApu.clone();
        
    }
    
    @Override
    public String toString() {
        return "Ukot: "+this.ukkoArray.length+", Tornit: "+this.torniArray.length+", Kuolleet: "+this.kuolleet;
    }
    
}