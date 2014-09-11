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
        assertEquals(0, pelialusta.vuoronNumero());
    }
    
    @Test
    public void vuoroVaihtuu() {
        pelialusta.vuoronvaihto();
        assertEquals(1, pelialusta.vuoronNumero());
    }
    
    @Test
    public void tornitOikeillaPaikoilla() {
        Torni torni = new Torni();
        pelialusta.setTorni(2, torni);
        assertEquals("2, torni", pelialusta.tulostaTornit());
    }
    
    @Test
    public void ukotOikeillaPaikoilla() {
        Ukko ukko = new Ukko();
        pelialusta.setUkko(2, ukko);
        assertEquals("2, ukko", pelialusta.tulostaUkot());
    }
    
    
}
