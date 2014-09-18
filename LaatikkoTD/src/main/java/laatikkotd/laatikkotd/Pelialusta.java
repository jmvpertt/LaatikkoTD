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
public class Pelialusta {

    private int kuolleet;
   
    public Pelialusta() {
        this.kuolleet = 0;

    }
    
    public int haeKuolleet() {
        return this.kuolleet;
    }
    
    public void vieHautausmaalle() {
        this.kuolleet++;
    }

}
