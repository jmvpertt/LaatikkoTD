/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
        
        else if (e.getSource() == this.nollaa) {
            
            this.pelinappulat = new Pelinappulat();
            this.pelinappulat.lisaaUkko(0, 2);
            this.ukot.add(new JLabel("U", SwingConstants.CENTER), 0);
            
            this.info.setText(this.pelinappulat.getApuTeksti(0));
            paivitaUkot();
            paivitaTornit();
            
            this.nollaa.setText("Aloita/Nollaa");
            
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
