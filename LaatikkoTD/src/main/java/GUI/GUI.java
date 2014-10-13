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
    private JPanel ukkoPolkuPanel;

    public GUI(Pelinappulat pelinappulat) {
        this.pelinappulat = pelinappulat;
        this.ukkoPolkuPanel = new JPanel(new GridLayout(1,1));
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
        container.add(luoUkkopolku(this.ukkoPolkuPanel));
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
    
    private JPanel luoUkkopolku(JPanel polku) {
                
        for (int i = 0; i < 10 ; i++) {
            
            JLabel ruutu = new JLabel(" ", SwingConstants.CENTER);
            polku.add(ruutu);
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
        vuoronVaihto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paivitaUkkoPolku();
            }
        });
        
        painikkeet.add(vuoronVaihto);
        
        final JButton nollaa = new JButton("Nollaa");
        nollaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nollaa.setText("asd");
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
    
    public void paivitaUkkoPolku() {
        this.ukkoPolkuPanel.remove(2);
        JLabel ruutu = new JLabel("ASD", SwingConstants.CENTER);
        
        this.ukkoPolkuPanel.add(ruutu, 2);
    }
    
}
