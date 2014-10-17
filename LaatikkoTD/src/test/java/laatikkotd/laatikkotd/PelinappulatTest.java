/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.util.Arrays;
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
public class PelinappulatTest {
    
    Pelinappulat pelinappulat;
    
    @Before
    public void setUp() {
        pelinappulat = new Pelinappulat();
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(0, pelinappulat.getKuolleet());
        assertEquals(0, pelinappulat.getVuoro());
        assertEquals(4, pelinappulat.getRahaaJaljella());
        assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
        assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getTorniArray()));
        
    }
    
    @Test
    public void torninLisaysKunRahaa() {
        
        pelinappulat.lisaaTorni(1);
        
        assertEquals(3, pelinappulat.getRahaaJaljella());
        assertEquals(1, pelinappulat.getTorniArray()[1].getSijainti());
        assertEquals("[null, T, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getTorniArray()));
    }
    
    @Test
    public void kuolleidenMaara() {
        assertEquals(0, pelinappulat.getKuolleet());
        pelinappulat.lisaaHautausmaalle();
        assertEquals(1, pelinappulat.getKuolleet());
    }
    
    @Test
    public void vuoronNollaus() {
        pelinappulat.eteneVuoro();
        pelinappulat.eteneVuoro();
        pelinappulat.eteneVuoro();
        pelinappulat.eteneVuoro();
        pelinappulat.nollaaVuoro();
        assertEquals(0, pelinappulat.getVuoro());
    }
    @Test
    public void torninLisaysKunRahatLoppu() {
        pelinappulat.setRaha(0);
        pelinappulat.lisaaTorni(1);
        
        assertEquals(0, pelinappulat.getRahaaJaljella());
        assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getTorniArray()));
    }
    
    @Test
    public void ukonLisaysToimii() {
        pelinappulat.lisaaUkko(3, 2);
        
        assertEquals(3, pelinappulat.getUkkoArray()[3].getSijainti());
        assertEquals(2, pelinappulat.getUkkoArray()[3].getHp());
        assertEquals("[null, null, null, U, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
    }
    
    @Test
    public void ukonTappoToimii() {
        pelinappulat.lisaaUkko(3, 2);
        pelinappulat.tapaUkko(3);
        
        assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
        assertEquals(1, pelinappulat.getKuolleet());
    }
    
    @Test
    public void vuoronVaihtoToimiiKunUkkoEiKuole() {
        pelinappulat.lisaaUkko(1, 2);
        assertEquals("[null, U, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
        pelinappulat.seuraavaVuoro();
        assertEquals("[null, null, U, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
    }
    
    @Test
    public void vuoronVaihtoToimiiKunUkkoKuolee() {
        pelinappulat.lisaaUkko(1, 2);
        assertEquals("[null, U, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
        pelinappulat.lisaaTorni(2);
        assertEquals("[null, null, T, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getTorniArray()));
        pelinappulat.seuraavaVuoro();
        
        assertEquals(1, pelinappulat.getKuolleet());
        assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getUkkoArray()));
        assertEquals("[null, null, T, null, null, null, null, null, null, null]", Arrays.toString(this.pelinappulat.getTorniArray()));
    }
    
    @Test
    public void apuTekstitoimii() {
        assertEquals("Tervetuloa!\nKun olet valmis, paina Aloita-nappia", pelinappulat.getApuTeksti(0));
        assertEquals("Vuoro: "+1+
                            "\nRahaa: "+4+
                            "\nKuolleita: "+0+
                            "\n\n", pelinappulat.getApuTeksti(1));
        assertEquals("Peli päättyi, hävisit!", pelinappulat.getApuTeksti(2));
        assertEquals("Voitit!", pelinappulat.getApuTeksti(3));
        assertEquals("", pelinappulat.getApuTeksti(9999));
    }
    
    @Test
    public void vuoronEteneminen() {
        assertEquals(0, pelinappulat.getVuoro());
        pelinappulat.eteneVuoro();
        assertEquals(1, pelinappulat.getVuoro());
    }
    
}
