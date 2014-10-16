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
    
    
    
    Ukko ukko;
    
    @Before
    public void setUp() {
        ukko = new Ukko(1, 2);
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(1, ukko.getSijainti());
        assertEquals(2, ukko.getHp());
        assertEquals("U", ukko.toString());
    }
    
    @Test
    public void siirraUkkoa() {
        ukko.siirra();
        assertEquals(2, ukko.getSijainti());
    }
    
    @Test
    public void merkinVaihtoToimii() {
        ukko.setMerkki("asdf");
        assertEquals("asdf", ukko.toString());
    }
    
}
