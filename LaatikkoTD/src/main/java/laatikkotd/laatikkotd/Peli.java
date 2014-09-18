/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

/**
 *
 * @author juha
 */
public class Peli {
    
    private Pelialusta pelialusta;
    
    public Peli() {
        this.pelialusta = new Pelialusta();
    }
    
    public void pelaaVuoro() {
        this.pelialusta.setTorni(5, new Torni());
        this.pelialusta.setUkko(10, new Ukko());
        
    }
    
}
