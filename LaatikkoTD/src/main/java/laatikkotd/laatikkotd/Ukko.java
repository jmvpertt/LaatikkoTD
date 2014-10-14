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
    private String merkki;
    
    public Ukko(int sijainti, int hp) {
        this.sijainti = sijainti;
        this.elossa = true;
        this.hp = hp;
        this.merkki = "U";
    }
    
    /**
    * Metodi palauttaa ukon sijainnin kokonaislukuna. Arvo on välillä
    * 0-10
    */
    public int haeSijainti(){
        return this.sijainti;
    }
    
    /**
    * Metodi vähentää hp:ta yhdellä ja ukon kuollessa asettaa elossa-attribuutin falseksi.
    */
    public void haavoita(int voima) {
        this.hp=- voima;
        if (this.hp == 3) {
            setMerkki("3");
        }
        if (this.hp == 2) {
            setMerkki("2");
        }
        if (this.hp == 1) {
            setMerkki("1");
        }
    }
    
    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
    
    public boolean onkoElossa() {
        if (this.elossa) {
            return true;
        }
        else {
            this.merkki = "X";
            return false;
        }
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
        if (!this.elossa) {
            return;
        }
        this.sijainti++;
    }
    
    @Override
    public String toString() {
        return this.merkki;
    }
}
