/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juha
 */
public class UkkoTest {
    
    public UkkoTest() {
    }
    
    Ukko ukko = new Ukko(0, 3);
    
    @Before
    public void setUp() {
        Ukko ukko = new Ukko(0, 3);
    }
    
    @Test
    public void alkuasetelmaOikein() {
        assertEquals(0, ukko.haeSijainti());
        assertEquals(3, ukko.getHp());
    }
    
    @Test
    public void kuollutUkko() {
        ukko.kuole();
        ukko.kuole();
        ukko.kuole();
        assertEquals(11, ukko.haeSijainti());
    }
    
    @Test
    public void siirraUkkoa() {
        ukko.siirra();
        assertEquals(1, ukko.haeSijainti());
    }
    
    @Test
    public void kuollutUkkoEiSiirry() {
        ukko.kuole();
        ukko.kuole();
        ukko.kuole();
        assertEquals(11, ukko.haeSijainti());
        ukko.siirra();
        assertEquals(11, ukko.haeSijainti());
    }
    
    @Test
    public void haeUkonSijainti() {
        Ukko ukko2 = new Ukko(4, 3);
        assertEquals(4, ukko2.haeSijainti());
    }
    
}
