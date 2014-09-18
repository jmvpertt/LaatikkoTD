/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

/**
 *
 * @author juha
 */
public class Ukko {
    
    private int sijainti;
    
    public Ukko(int sijainti) {
        this.sijainti = sijainti;
    }
    
    public int haeSijainti() {
        return this.sijainti;
    }
    
    public void kuole() {
        this.sijainti = 99;
    }
    
    public void siirra() {
        if ( this.sijainti == 99) {
            return;
        }
        this.sijainti++;
    }
}
