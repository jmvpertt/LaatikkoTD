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
    
    Ukko ukko = new Ukko(0);
    
    @Before
    public void setUp() {
        Ukko ukko = new Ukko(0);
    }
    
    @Test
    public void alkuasetelmaOikein() {
        assertEquals(0, ukko.haeSijainti());
    }
    
    @Test
    public void kuollutUkko() {
        ukko.kuole();
        assertEquals(99, ukko.haeSijainti());
    }
    
    @Test
    public void siirraUkkoa() {
        ukko.siirra();
        assertEquals(1, ukko.haeSijainti());
    }
    
    @Test
    public void kuollutUkkoEiSiirry() {
        ukko.kuole();
        assertEquals(99, ukko.haeSijainti());
        ukko.siirra();
        assertEquals(99, ukko.haeSijainti());
    }
    
    @Test
    public void haeUkonSijainti() {
        Ukko ukko2 = new Ukko(4);
        assertEquals(4, ukko2.haeSijainti());
    }
    
}
