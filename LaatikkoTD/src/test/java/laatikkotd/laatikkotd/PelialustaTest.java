/*
 * To change this template, choose Tools | Templates
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
 * @author juha
 */
public class PelialustaTest {
    
    public PelialustaTest() {
    }
    
    Pelialusta pelialusta;
    
    @Before
    public void setUp() {
        pelialusta = new Pelialusta();
    }
    
    @Test
    public void alkuasetelmaOikein() {
        assertEquals(0, pelialusta.getKuolleet());
    }
    
    @Test
    public void tapaUkko() {
        pelialusta.lisaaUkko(new Ukko(1,1));
        pelialusta.poistaUkko(1);
        assertEquals(1, pelialusta.getKuolleet());
    }
    
    @Test
    public void tapaToinenUkko() {
        pelialusta.lisaaUkko(new Ukko(1,1));
        pelialusta.lisaaUkko(new Ukko(3,1));
        pelialusta.poistaUkko(1);
        pelialusta.poistaUkko(3);
        assertEquals(2, pelialusta.getKuolleet());
    }
    
   
}
