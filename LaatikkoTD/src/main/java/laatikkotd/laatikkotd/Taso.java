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
    private int numero;
    
    public Taso(Pelinappulat pelinappulat) {
        this.pelinappulat = pelinappulat;
        this.numero = 1;
    }
    
    @Override
    public String toString() {
        return ""+this.numero;
    }
    
}
