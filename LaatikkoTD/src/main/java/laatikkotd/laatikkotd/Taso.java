/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.util.ArrayList;

/**
 *
 * @author juha
 */
public class Taso {
    
    private int tasonPituus;
    private int kylanKoko;
    private Pelinappulat pelinappulat;
    private int tasonNumero;
    
    public Taso(int tasonNumero) {
        this.pelinappulat = new Pelinappulat();
        this.tasonNumero = tasonNumero;
        this.kylanKoko = 10;
        this.tasonPituus = 10;
    }
    
    public void generoiTaso() {
        pelinappulat.lisaaTorni(new Torni(5));
        pelinappulat.lisaaUkko(new Ukko(3,1));
    }
    
    @Override
    public String toString() {
        return ""+this.tasonNumero;
    }
    
}
