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
        
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == this.tornit.getComponent(i)) {
                this.pelinappulat.lisaaTorni(i);
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
                this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
            }
        }
        
        if (e.getSource() == this.vuoro) {
            this.vuoro.setText("Seuraava vuoro ("+this.pelinappulat.getVuoro()+")");

            this.pelinappulat.setVuoro(1);
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
            
            if (this.pelinappulat.getUkkoArray()[9] != null) {
                this.info.append("Peli päättyi, hävisit!");
                this.vuoro.removeActionListener(this);
                return;
            }
            
            if (this.pelinappulat.getVuoro() == 9) {
                this.info.append("\n\nVoitit!");
                this.vuoro.removeActionListener(this);
                return;
            }
            
            this.info.append("Vuoro vaihtui"+Arrays.toString(this.pelinappulat.getTorniArray())+" "+Arrays.toString(this.pelinappulat.getUkkoArray()) +"\n");
        }
        
        else if (e.getSource() == this.nollaa) {
            
            if (this.pelinappulat.getVuoro() == 0) {
                this.pelinappulat.lisaaUkko(0, 2);
                
                for (int i = 0; i < 10 ; i++) {
                    this.tornit.removeAll();
                    for (int j = 0; j < 10; j++) {
                        if (this.pelinappulat.getTorniArray()[j] != null) {
                            String merkki = this.pelinappulat.getTorniArray()[j].toString();
                            JButton tornipaikka = new JButton(merkki);
                            tornipaikka.addActionListener(this);
                            this.tornit.add(tornipaikka);
                        }
                        else {
                            JButton tornipaikka = new JButton(""+j);
                            tornipaikka.addActionListener(this);
                            this.tornit.add(tornipaikka);
                        }
                    
                    }
                }
                this.nollaa.setText("Nollaa");
            }
            else {
                this.pelinappulat = new Pelinappulat();
            
                this.vuoro.addActionListener(this);
                this.vuoro.setText("Seuraava vuoro ("+this.pelinappulat.getVuoro()+")");
            
                for (int i = 0 ; i < 10 ; i++) {
                    this.ukot.remove(i);
                    if (i == 0) {
                        this.ukot.add(new JLabel("U", SwingConstants.CENTER), i);
                    }
                    else if (i == 9) {
                        this.ukot.add(new JLabel("KYLÄ", SwingConstants.CENTER), i);
                    }
                    else {
                        this.ukot.add(new JLabel(" "), i);
                    }
                }
            
                this.info.append("Peli nollattu");
            }
        }
        
    }
    
    
}
