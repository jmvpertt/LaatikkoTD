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
    private boolean elossa;
    private int hp;
    
    public Ukko(int sijainti, int hp) {
        this.sijainti = sijainti;
        this.elossa = true;
        this.hp = 3;
    }
    
    /**
    * Metodi palauttaa ukon sijainnin kokonaislukuna. Arvo on välillä
    * 0-10
    */
    public int haeSijainti() {
        if (!this.elossa) {
            return 0;
        }
        return this.sijainti;
    }
    
    /**
    * Metodi nollaa hp:n ja asettaa sijainniksi 11.
    */
    public void kuole() {
        this.hp = 0;
        this.sijainti = 11;
//        if (this.hp == 0) {
//            this.elossa = false;
//        }
    }
    
    /**
    * Metodi palauttaa hp:n kokonaislukuna.
    */
    public int getHp() {
        return this.hp;
    }
    
    /**
    * Metodi lisää +1 sijaintiin. Ei tee mitään jos ukko on kuollut.
    */
    public void siirra() {
        if ( this.sijainti == 11 ) {
            return;
        }
        this.sijainti++;
    }
}
