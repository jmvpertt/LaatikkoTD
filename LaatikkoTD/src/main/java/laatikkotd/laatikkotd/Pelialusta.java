/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.util.HashMap;

/**
 *
 * @author juha
 */
public class Pelialusta {
    private final int POLKU = 10;
    private final int MUURI = 10;
    
    private int vuoro;
    private HashMap<Integer, Ukko> ukot;
    private HashMap<Integer, Torni> tornit;
    
    
    public Pelialusta() {
        this.vuoro = 0;
    }
    
    public void vuoronvaihto() {
        this.vuoro++;
    }
    
    public int vuoronNumero() {
        return this.vuoro;
    }
    
    public void setTorni(int paikka, Torni torni) {
        this.tornit.put(paikka, new Torni());
    }
    
    public void setUkko(int paikka, Ukko ukko) {
        this.ukot.put(paikka, new Ukko());
    }
    
    public String tulostaTornit() {
        return tornit.toString();
    }
    
    public String tulostaUkot() {
        return ukot.toString();
    }
}
