/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import laatikkotd.laatikkotd.Pelinappulat;

/**
 *
 * @author juha
 */
public class Kuuntelija implements ActionListener{

    private Pelinappulat pelinappulat;
    private JTextArea info;
    private JPanel ukot;
    private JPanel tornit;
    private JButton vuoro;
    private JButton nollaa;
    private JButton lopeta;
    private JFrame ikkuna;
    
    /**
     * Luokka hoitaa käyttöliittymän nappien toimisen ja tekstin ynnä muun
     * päivittymisen. Luo Pelinappulat-olion ja käyttää sitä suurimpaan
     * osaan toimintoja.
     * 
     * @param info tekstiruutu jossa kerrotaan pelin tapahtumista
     * @param ukot JPanel jossa JLabelit ukon "polun" varrella
     * @param tornit JPanel jossa tornien paikat JButtoneina
     * @param vuoro JButton vuoronvaihtoon
     * @param nollaa JButton aloittamiseen, nollaukseen
     * @param lopeta JButton pelin lopettamiseen, GUI hallinnoi
     * @param ikkuna pelin JFrame
     * 
     */
    
    
    
    public Kuuntelija (JTextArea info, JPanel ukot, JPanel tornit, JButton vuoro, JButton nollaa, JButton lopeta, JFrame ikkuna) {
        this.pelinappulat = new Pelinappulat();
        this.info = info;
        this.ukot = ukot;
        this.tornit = tornit;
        this.vuoro = vuoro;
        this.nollaa = nollaa;
        this.lopeta = lopeta;
        this.ikkuna = ikkuna;
        
        this.nollaa.addActionListener(this);
        this.vuoro.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        torniNappi(e);
        vuoroNappi(e);
        nollaaNappi(e);
    }
    
    /**
     * Nollaa pelin luomalla uuden Pelinappulat-olion vanhan tilalle.
     * 
     * @param e napin painallus
     */
    private void nollaaNappi(ActionEvent e) {
        if (e.getSource() == this.nollaa) {
            
            this.pelinappulat = new Pelinappulat();
            this.pelinappulat.lisaaUkko(0, 2);
            
            
            this.info.setText(this.pelinappulat.getApuTeksti(0));
            paivitaUkot();
            paivitaTornit();
            
            this.pelinappulat.nollaaVuoro();
            this.vuoro.removeActionListener(this);
            this.vuoro.addActionListener(this);
            
            this.nollaa.setText("Aloita/Nollaa");
        }
    }
    
    
    /**
     * Nappia painamalla peli etenee vuoron. Kutsuu paivitaUkot-metodia
     * Jos vuoron on 9 tai ukko pääsee viimeiseen ruutuun ilmoittaa pelin
     * päättymisestä ja poistaa oman ActionListenerinsä.
     * 
     * @param e napin painallus
     */
    private void vuoroNappi(ActionEvent e) {
        if (e.getSource() == this.vuoro) {
            this.pelinappulat.eteneVuoro();
            paivitaUkot();
            
            if (this.pelinappulat.getUkkoArray()[9] != null) {
                this.info.setText(this.pelinappulat.getApuTeksti(2));
                this.vuoro.removeActionListener(this);
                return;
            }
            
            if (this.pelinappulat.getVuoro() == 9) {
                this.info.setText(this.pelinappulat.getApuTeksti(3));
                this.vuoro.removeActionListener(this);
                return;
            }
            
            this.info.setText(this.pelinappulat.getApuTeksti(1)+"Vuoro vaihtui.");
        }
    }
    
    private void torniNappi(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == this.tornit.getComponent(i)) {
                this.pelinappulat.lisaaTorni(i);
                paivitaTornit();
                this.info.setText(this.pelinappulat.getApuTeksti(1)+"Torni lisätty.");
            }
        }
    }
    
    /**
     * Päivittää JButtonit poistamalla ne ja luomalla uudelleen.
     */
    private void paivitaTornit() {
        this.tornit.removeAll();
            for (int j = 0; j < 10; j++) {
                if (this.pelinappulat.getTorniArray()[j] != null) {
                    String merkki = this.pelinappulat.getTorniArray()[j].toString();
                    JButton tornipaikka = new JButton(merkki);
                    if (this.pelinappulat.getRahaaJaljella() > 0) {
                        tornipaikka.addActionListener(this);
                    }
                    this.tornit.add(tornipaikka);
                }
                else {
                    JButton tornipaikka = new JButton(""+j);
                    tornipaikka.addActionListener(this);
                    this.tornit.add(tornipaikka);
                }
                
            }
        this.tornit.validate();
    }
    
    /**
     * Päivittää JButtonit poistamalla ne ja luomalla uudelleen.
     */
    private void paivitaUkot() {
        this.ukot.removeAll();
        for (int j = 0; j < 10; j++) {
            if (this.pelinappulat.getUkkoArray()[j] != null) {
                String merkki = this.pelinappulat.getUkkoArray()[j].toString();
                JLabel paikka = new JLabel(merkki, SwingConstants.CENTER);
                this.ukot.add(paikka);
            }
            else {
                String merkki = " ";
                JLabel paikka = new JLabel(merkki, SwingConstants.CENTER);
                this.ukot.add(paikka);
            }
        }
        this.ukot.validate();
    }
    
    
}
