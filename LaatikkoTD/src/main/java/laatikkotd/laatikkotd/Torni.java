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
    
    private int kantama;
    private int nopeus;
    private int voima;
    private int hinta;
    
    public Torni() {
        this.kantama = 1;
        this.nopeus = 1;
        this.voima = 1;
        this.hinta = 1;
    }
    
    public void ammu(Ukko ukko) {
        ukko.osuma();
    }
    
    public boolean tahtaa() {
        return false;
    }
    
}
