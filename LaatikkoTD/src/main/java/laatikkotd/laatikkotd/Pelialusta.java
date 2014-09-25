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
public class Pelialusta {

    private int kuolleet;
    private ArrayList<Ukko> ukot;
    private ArrayList<Torni> tornit;
    
    public Pelialusta() {
        this.kuolleet = 0;
        this.ukot = new ArrayList<>();
        this.tornit = new ArrayList<>();
        
    }
    
    /**
    * Metodi lisää torni-olion ArrayList -listalle
    */
    public void lisaaTorni(Torni torni) {
        this.tornit.add(torni);
    }
    
    /**
    * Metodi poistaa torni-olion tyhjentämällä koko listan.
    */
    public void poistaTorni(int i) {
        this.tornit.remove(i);
    }
    
    /**
    * Metodi lisää ukko-olion ArrayList -listalle
    */
    public void lisaaUkko (Ukko ukko) {
        this.ukot.add(ukko);
    }
    
    /**
    * Metodi poistaa ukko-olion tyhjentämällä koko listan.
    */
    public void poistaUkko(int i) {
        this.ukot.clear();
        this.kuolleet++;
    }
    
    /**
    * Metodi palauttaa ArrayList-listan
    */
    public ArrayList<Torni> getTornit() {
        return this.tornit;
    }
    
    /**
    * Metodi palauttaa ArrayList-listan
    */
    public ArrayList<Ukko> getUkot() {
        return this.ukot;
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

}
