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
    
    /**
     * Luokka luo ukko-olioita. Konstruktorille annetaan ukon sijainti ja hp.
     * Lisäksi ukko-oliolla on merkki-attribuutti joka korvaa toString()-metodin
     * palauttaman merkkijonon.
     * 
     * @param sijainti olion sijainti ukkoArray-taulukossa
     * @param hp Ukon sietämien kohtaamisten määrä tornin kanssa.
     * 
     * @see laatikkotd.laatikkotd.Pelinappulat#ukkoArray
     */
    public Ukko(int sijainti, int hp) {
        this.sijainti = sijainti;
        this.hp = hp;
        this.merkki = "U";
    }
    
    public int getSijainti(){
        return this.sijainti;
    }
    
    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public void haavoitu(int hp) {
        if ((this.hp - hp) > 1) {
            this.hp = this.hp - hp;
            this.merkki = "u";
        }
        else if ((this.hp - hp) <= 0) {
            this.hp = 0;
            setMerkki("X");
        }
    }
    
    /**
    * Metodi lisää +1 sijaintiin.
    */
    public void siirra() {
        this.sijainti++;
    }
    
    @Override
    public String toString() {
        return this.merkki;
    }
}
