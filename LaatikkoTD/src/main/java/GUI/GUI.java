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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
        ikkuna.setPreferredSize(new Dimension(1000, 300));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());
        

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(luoTekstilaatikko());
        container.add(luoUkkopolku());
        container.add(luoTornirivi());
        container.add(luoHautausmaa());
        container.add(luoValikonPainikkeet());
             
    }
    
    private JPanel luoTekstilaatikko() {
        JPanel laatikko = new JPanel (new GridLayout(1,1));
        
        JTextArea infoTeksti = new JTextArea("Tervetuloa");
        
        laatikko.add(infoTeksti);
        
        return laatikko;
        
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
                    JLabel ruutu = new JLabel(" ", SwingConstants.CENTER);
                    polku.add(ruutu);
                }
            }
        }
        
        
        return polku;
    }
    
    private JPanel luoTornirivi() {
        JPanel rivi = new JPanel (new GridLayout(1,10));
        
        
        for (int i = 0 ; i < 10 ; i++) {
            JButton torniButton = new JButton(" ");
            
            TorniKuuntelija kuuntelija  = new TorniKuuntelija(pelinappulat, torniButton, i);
            torniButton.addActionListener(kuuntelija);
            
            rivi.add(torniButton);
        }
        
        
        return rivi;
        
    }
    
    private JPanel luoHautausmaa() {        
        JPanel hautausmaa = new JPanel (new GridLayout(1,1));
        
        JLabel kuolleet = new JLabel("Kuolleita: "+pelinappulat.getKuolleet());
        
        hautausmaa.add(kuolleet);
        
        return hautausmaa;
    }
    
    private JPanel luoValikonPainikkeet() {
        JPanel painikkeet = new JPanel (new GridLayout (1,3));
        
        JButton vuoronVaihto = new JButton("Seuraava vuoro");
        seuraavaVuoroKuuntelija kuuntelija = new seuraavaVuoroKuuntelija(pelinappulat, vuoronVaihto, luoUkkopolku());
        vuoronVaihto.addActionListener(kuuntelija);
        
        painikkeet.add(vuoronVaihto);
        
        JButton nollaa = new JButton("Nollaa");
        nollaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pelinappulat.getTornit().clear();
                pelinappulat.getUkot().clear();
                
            }
        });
        painikkeet.add(nollaa);
        
        JButton lopeta = new JButton("Lopeta");
        lopeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ikkuna.dispose();
            }
        });
        painikkeet.add(lopeta);
        
        return painikkeet;
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }
    
}
