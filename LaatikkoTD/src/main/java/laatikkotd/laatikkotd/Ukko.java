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
    
    private int hp;
    private int nopeus;
    
    public Ukko() {
        this.hp = 1;
        this.nopeus = 1;
    }
    
    public void hakkaa() {
        
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public int getNopeus() {
        return this.nopeus;
    }
    
    public void osuma() {
        this.hp--;
    }
    
}
