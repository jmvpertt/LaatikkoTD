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
        
        JLabel u0 = new JLabel("U", SwingConstants.CENTER);
        JLabel u1 = new JLabel(" ");
        JLabel u2 = new JLabel(" ");
        JLabel u3 = new JLabel(" ");
        JLabel u4 = new JLabel(" ");
        JLabel u5 = new JLabel(" ");
        JLabel u6 = new JLabel(" ");
        JLabel u7 = new JLabel(" ");
        JLabel u8 = new JLabel(" ");
        JLabel u9 = new JLabel("KYLÄ", SwingConstants.CENTER);
        
        JPanel Ukkopolku = new JPanel(new GridLayout(1,10));
        
        Ukkopolku.add(u0);
        Ukkopolku.add(u1);
        Ukkopolku.add(u2);
        Ukkopolku.add(u3);
        Ukkopolku.add(u4);
        Ukkopolku.add(u5);
        Ukkopolku.add(u6);
        Ukkopolku.add(u7);
        Ukkopolku.add(u8);
        Ukkopolku.add(u9);
        
        JButton t0 = new JButton(""+0);
        JButton t1 = new JButton(""+1);
        JButton t2 = new JButton(""+2);
        JButton t3 = new JButton(""+3);
        JButton t4 = new JButton(""+4);
        JButton t5 = new JButton(""+5);
        JButton t6 = new JButton(""+6);
        JButton t7 = new JButton(""+7);
        JButton t8 = new JButton(""+8);
        JButton t9 = new JButton(""+9);
        
        JPanel Tornirivi = new JPanel(new GridLayout(1, 10));
        
        Tornirivi.add(t0);
        Tornirivi.add(t1);
        Tornirivi.add(t2);
        Tornirivi.add(t3);
        Tornirivi.add(t4);
        Tornirivi.add(t5);
        Tornirivi.add(t6);
        Tornirivi.add(t7);
        Tornirivi.add(t8);
        Tornirivi.add(t9);
        
        JButton vuoronVaihto = new JButton("Seuraava vuoro");
        JButton nollaa = new JButton("Nollaa");
        JButton lopeta = new JButton("Lopeta");
        
        JPanel Valikko = new JPanel(new GridLayout(1,3));
        Valikko.add(vuoronVaihto);
        Valikko.add(nollaa);
        Valikko.add(lopeta);
        
        JLabel Hautausmaa = new JLabel();
        
        Kuuntelija k = new Kuuntelija(infoTeksti, Ukkopolku, t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, vuoronVaihto, nollaa, lopeta, ikkuna);
        
        t0.addActionListener(k);
        t1.addActionListener(k);
        t2.addActionListener(k);
        t3.addActionListener(k);
        t4.addActionListener(k);
        t5.addActionListener(k);
        t6.addActionListener(k);
        t7.addActionListener(k);
        t8.addActionListener(k);
        t9.addActionListener(k);
        
        vuoronVaihto.addActionListener(k);
        nollaa.addActionListener(k);
//        lopeta.addActionListener(k);
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
            
            JLabel ruutu = new JLabel(""+i, SwingConstants.CENTER);
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
