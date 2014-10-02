/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import laatikkotd.laatikkotd.Pelinappulat;

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
         
        GridLayout layout = new GridLayout(4, 10, 10, 10);
        container.setLayout(layout);
        
        
        JLabel ruutu0 = new JLabel("U", SwingConstants.CENTER);
        JLabel ruutu1 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu2 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu3 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu4 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu5 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu6 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu7 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu8 = new JLabel("_", SwingConstants.CENTER);
        JLabel ruutu9 = new JLabel("_", SwingConstants.CENTER);
        
        JLabel torni0 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni1 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni2 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni3 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni4 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni5 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni6 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni7 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni8 = new JLabel("_", SwingConstants.CENTER);
        JLabel torni9 = new JLabel("_", SwingConstants.CENTER);
        
        JButton addTorni0 = new JButton("+");
        JButton addTorni1 = new JButton("+");
        JButton addTorni2 = new JButton("+");
        JButton addTorni3 = new JButton("+");
        JButton addTorni4 = new JButton("+");
        JButton addTorni5 = new JButton("+");
        JButton addTorni6 = new JButton("+");
        JButton addTorni7 = new JButton("+");
        JButton addTorni8 = new JButton("+");
        JButton addTorni9 = new JButton("+");
        
        JButton vuoronVaihto = new JButton("Seuraava vuoro");
        JButton vuoronVaihto1 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto2 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto3 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto4 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto5 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto6 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto7 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto8 = new JButton("Seuraava vuoro");
        JButton vuoronVaihto9 = new JButton("Seuraava vuoro");
        
        addTorniKuuntelija kuuntelija0 = new addTorniKuuntelija(pelinappulat, addTorni0, torni0, 0);
        addTorni0.addActionListener(kuuntelija0);
        addTorniKuuntelija kuuntelija1 = new addTorniKuuntelija(pelinappulat, addTorni1, torni1, 1);
        addTorni1.addActionListener(kuuntelija1);
        addTorniKuuntelija kuuntelija2 = new addTorniKuuntelija(pelinappulat, addTorni2, torni2, 2);
        addTorni2.addActionListener(kuuntelija2);
        addTorniKuuntelija kuuntelija3 = new addTorniKuuntelija(pelinappulat, addTorni3, torni3, 3);
        addTorni3.addActionListener(kuuntelija3);
        addTorniKuuntelija kuuntelija4 = new addTorniKuuntelija(pelinappulat, addTorni4, torni4, 4);
        addTorni4.addActionListener(kuuntelija4);
        addTorniKuuntelija kuuntelija5 = new addTorniKuuntelija(pelinappulat, addTorni5, torni5, 5);
        addTorni5.addActionListener(kuuntelija5);
        addTorniKuuntelija kuuntelija6 = new addTorniKuuntelija(pelinappulat, addTorni6, torni6, 6);
        addTorni6.addActionListener(kuuntelija6);
        addTorniKuuntelija kuuntelija7 = new addTorniKuuntelija(pelinappulat, addTorni7, torni7, 7);
        addTorni7.addActionListener(kuuntelija7);
        addTorniKuuntelija kuuntelija8 = new addTorniKuuntelija(pelinappulat, addTorni8, torni8, 8);
        addTorni8.addActionListener(kuuntelija8);
        addTorniKuuntelija kuuntelija9 = new addTorniKuuntelija(pelinappulat, addTorni9, torni9, 9);
        addTorni9.addActionListener(kuuntelija9);
        
        seuraavaVuoroKuuntelija svkuuntelija = new seuraavaVuoroKuuntelija(pelinappulat, vuoronVaihto, 
        ruutu0, ruutu1, ruutu2, ruutu3, ruutu4, ruutu5, ruutu6, ruutu7, ruutu8, ruutu9);
        vuoronVaihto.addActionListener(svkuuntelija);
        
        container.add(ruutu0);
        container.add(ruutu1);
        container.add(ruutu2);
        container.add(ruutu3);
        container.add(ruutu4);
        container.add(ruutu5);
        container.add(ruutu6);
        container.add(ruutu7);
        container.add(ruutu8);
        container.add(ruutu9);
        
        container.add(torni0);
        container.add(torni1);
        container.add(torni2);
        container.add(torni3);
        container.add(torni4);
        container.add(torni5);
        container.add(torni6);
        container.add(torni7);
        container.add(torni8);
        container.add(torni9);
        
        container.add(addTorni0);
        container.add(addTorni1);
        container.add(addTorni2);
        container.add(addTorni3);
        container.add(addTorni4);
        container.add(addTorni5);
        container.add(addTorni6);
        container.add(addTorni7);
        container.add(addTorni8);
        container.add(addTorni9);
        
        container.add(vuoronVaihto);
        container.add(vuoronVaihto1);
        container.add(vuoronVaihto2);
        container.add(vuoronVaihto3);
        container.add(vuoronVaihto4);
        container.add(vuoronVaihto5);
        container.add(vuoronVaihto6);
        container.add(vuoronVaihto7);
        container.add(vuoronVaihto8);
        container.add(vuoronVaihto9);
        
             
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }
    
}
