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
    
    Torni torni;

    @Before
    public void setUp() {
        torni = new Torni(1);
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(1, torni.getSijainti());
        assertEquals(1, torni.getVoima());
        assertEquals("T", torni.toString());
    }
    
    @Test
    public void ylennysKunNormaali() {
        torni.ylenna();
        
        assertEquals(2, torni.getVoima());
        assertEquals("T+", torni.toString());
    }
    
    @Test
    public void ylennysKunJoYlennetty() {
        torni.ylenna();
        
        assertEquals(2, torni.getVoima());
        assertEquals("T+", torni.toString());
    }

}
