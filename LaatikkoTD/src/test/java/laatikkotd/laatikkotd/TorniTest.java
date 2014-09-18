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
public class TorniTest {
    
    public TorniTest() {
    }

    Torni torni = new Torni(1);
    
    @Before
    public void setUp() {
        Torni torni = new Torni(1);
    }
    
    @Test
    public void alkuasetelmaOikein() {
        assertEquals(1, torni.haeSijainti());
    }
    
    @Test
    public void torninSijainti() {
        Torni torni2 = new Torni(2);
        assertEquals(2, torni2.haeSijainti());
    }

}
