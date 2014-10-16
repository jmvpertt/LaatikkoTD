/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

    @Override
    public void run() {
        ikkuna = new JFrame("LaatikkoTD");
        ikkuna.setPreferredSize(new Dimension(1000, 500));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());
        

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JTextArea infoTeksti = new JTextArea("Tervetuloa\n");
        infoTeksti.setRows(15);
        JPanel infoTekstiPanel = new JPanel(new GridLayout(1,1));
        infoTekstiPanel.add(infoTeksti);
        
        JPanel Ukkopolku = luoUkkopolku();
        
        JPanel Tornirivi = luoTornirivi();
        
        JButton vuoronVaihto = new JButton("Seuraava vuoro");
        JButton nollaa = new JButton("Aloita");
        JButton lopeta = new JButton("Lopeta");
        
        JPanel Valikko = new JPanel(new GridLayout(1,3));
        Valikko.add(vuoronVaihto);
        Valikko.add(nollaa);
        Valikko.add(lopeta);
        
        JLabel Hautausmaa = new JLabel();
        
        Kuuntelija k = new Kuuntelija(infoTeksti, Ukkopolku, Tornirivi , vuoronVaihto, nollaa, lopeta, ikkuna);
        
        lopeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ikkuna.dispose();
            }
        });
        
        container.add(infoTekstiPanel);
        container.add(Ukkopolku);
        container.add(Tornirivi);
        container.add(Hautausmaa);
        container.add(Valikko);
             
    }
    
    private JPanel luoUkkopolku() {
        JPanel polku = new JPanel (new GridLayout(1,10));        
        for (int i = 0; i < 10 ; i++) {
            
            JLabel ruutu = new JLabel(" ", SwingConstants.CENTER);
            polku.add(ruutu);
        }
        
        return polku;
    }
    
    private JPanel luoTornirivi() {
        JPanel rivi = new JPanel (new GridLayout(1,10));
        
        for (int i = 0 ; i < 10 ; i++) {
            JButton torniButton = new JButton(""+i);
            rivi.add(torniButton);
        }
        
        return rivi;
        
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }
    
}
