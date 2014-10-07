/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import laatikkotd.laatikkotd.Pelinappulat;
import laatikkotd.laatikkotd.Ukko;

/**
 *
 * @author Juha
 */
public class GUI implements Runnable {

    private JFrame ikkuna;
    private Pelinappulat pelinappulat;

    public GUI(Pelinappulat pelinappulat) {
        this.pelinappulat = pelinappulat;
    }

    @Override
    public void run() {
        ikkuna = new JFrame("LaatikkoTD");
        ikkuna.setPreferredSize(new Dimension(500, 150));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());
        

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(luoUkkopolku());
        container.add(luoTornirivi());
        container.add(luoValikonPainikkeet());
             
    }
    
    private JPanel luoUkkopolku() {
        JPanel polku = new JPanel (new GridLayout(1,10));
        
        for (int i = 0; i < 10 ; i++) {
            for (Ukko j : pelinappulat.getUkot()) {
                if (j.haeSijainti() == i) {
                    JLabel ruutu = new JLabel("U", SwingConstants.CENTER);
                    polku.add(ruutu);
                }
                else {
                    JLabel ruutu = new JLabel("_", SwingConstants.CENTER);
                    polku.add(ruutu);
                }
            }
        }
        
        
        return polku;
    }
    
    private JPanel luoTornirivi() {
        JPanel rivi = new JPanel (new GridLayout(1,10));
        
        for (int i = 0 ; i < 10 ; i++) {
            JButton torni = new JButton("_");
            
            TorniKuuntelija kuuntelija  = new TorniKuuntelija(pelinappulat, torni, i);
            torni.addActionListener(kuuntelija);
            
            rivi.add(torni);
        }
        
        return rivi;
        
    }
    
    private JPanel luoValikonPainikkeet() {
        JPanel painikkeet = new JPanel (new GridLayout (1,1));
        
        JButton nappi = new JButton("Seuraava vuoro");
        
        seuraavaVuoroKuuntelija kuuntelija = new seuraavaVuoroKuuntelija(pelinappulat, nappi, luoUkkopolku());
        
        nappi.addActionListener(kuuntelija);
        
        painikkeet.add(nappi);
        
        return painikkeet;
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }
    
}
