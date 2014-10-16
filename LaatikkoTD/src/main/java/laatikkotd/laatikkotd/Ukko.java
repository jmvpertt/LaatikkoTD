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
    private int hp;
    private String merkki;
    
    public Ukko(int sijainti, int hp) {
        this.sijainti = sijainti;
        this.hp = hp;
        this.merkki = "U";
    }
    
    /**
    * Metodi palauttaa ukon sijainnin kokonaislukuna.
    */
    public int getSijainti(){
        return this.sijainti;
    }
    
    /**
    * Metodi vähentää hp:ta yhdellä ja ukon kuollessa asettaa elossa-attribuutin falseksi.
    */
    
    public void setMerkki(String merkki) {
        this.merkki = merkki;
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
        this.sijainti++;
    }
    
    
    @Override
    public String toString() {
        return this.merkki;
    }
}
