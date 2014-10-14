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
    private int vuoro;
    private String tulostusTeksti;
    private int raha;
    
    public Pelinappulat() {
        this.kuolleet = 0;
        this.ukkoArray = new Ukko[10];
        this.torniArray = new Torni[10];
        this.vuoro = 0;
        this.tulostusTeksti = "Tervetuloa";
        this.raha = 3;
        
        this.ukkoArray[0] = new Ukko(0, 2);
    }
    
    /**
    * Metodi lisää torni-olion ArrayList -listalle
    */
    public void lisaaTorni(int sijainti) {
        if (this.raha == 0) {
            return;
        }
        Torni torni = new Torni(sijainti);
        this.raha--;
        this.torniArray[torni.haeSijainti()] = torni;
    }
    
    /**
    * Metodi poistaa torni-olion tyhjentämällä koko listan.
    */
    public void poistaTorni(int i) {
        this.torniArray[i] = null;
        this.raha++;
    }
    
    /**
    * Metodi lisää ukko-olion ArrayList -listalle
    */
    public void lisaaUkko (int sijainti, int hp) {
        Ukko ukko = new Ukko(sijainti, hp);
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
    
    public String getTulostusTeksti() {
        return this.tulostusTeksti;
    }
    
    /**
    * Metodi palauttaa ArrayList-listan
    */
    public Ukko[] getUkkoArray() {
        return this.ukkoArray;
    }
    
    public int getRahaaJaljella() {
        return this.raha;
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
    
    public int getVuoro() {
        return this.vuoro;
    }
    public void setVuoro(int vuoro) {
        seuraavaVuoro();
        this.vuoro += vuoro;
        this.tulostusTeksti = this.tulostusTeksti + "Vuoro vaihtui.("+this.vuoro+")";
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
        
        for (int j = 0; j < 10 ; j++) {
            if (this.ukkoArray[j] != null && this.torniArray[j] != null) {
                this.ukkoArray[j].haavoita(1);
                if (!this.ukkoArray[j].onkoElossa()) {
                    poistaUkko(j);
                }
            }
        }
        
    }
    
    @Override
    public String toString() {
        return "Ukot: "+this.ukkoArray.length+", Tornit: "+this.torniArray.length+", Kuolleet: "+this.kuolleet;
    }
    
}