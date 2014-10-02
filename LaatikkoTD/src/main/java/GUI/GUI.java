/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        ikkuna.setPreferredSize(new Dimension(500, 300));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
         
        GridLayout layout = new GridLayout(3, 10);
        container.setLayout(layout);
        
        JLabel ruutu0 = new JLabel("_");
        JLabel ruutu1 = new JLabel("_");
        JLabel ruutu2 = new JLabel("_");
        JLabel ruutu3 = new JLabel("_");
        JLabel ruutu4 = new JLabel("_");
        JLabel ruutu5 = new JLabel("_");
        JLabel ruutu6 = new JLabel("_");
        JLabel ruutu7 = new JLabel("_");
        JLabel ruutu8 = new JLabel("_");
        JLabel ruutu9 = new JLabel("_");
        
        JLabel torni0 = new JLabel("0");
        JLabel torni1 = new JLabel("|");
        JLabel torni2 = new JLabel("|");
        JLabel torni3 = new JLabel("|");
        JLabel torni4 = new JLabel("|");
        JLabel torni5 = new JLabel("|");
        JLabel torni6 = new JLabel("|");
        JLabel torni7 = new JLabel("|");
        JLabel torni8 = new JLabel("|");
        JLabel torni9 = new JLabel("|");
        
        JButton addTorni0 = new JButton("0");
        JButton addTorni1 = new JButton("1");
        JButton addTorni2 = new JButton("2");
        JButton addTorni3 = new JButton("3");
        JButton addTorni4 = new JButton("4");
        JButton addTorni5 = new JButton("5");
        JButton addTorni6 = new JButton("6");
        JButton addTorni7 = new JButton("7");
        JButton addTorni8 = new JButton("8");
        JButton addTorni9 = new JButton("9");
        
        addTorniKuuntelija kuuntelija = new addTorniKuuntelija(pelinappulat, addTorni0);
        addTorni0.addActionListener(kuuntelija);
        
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
        
             
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }
    
}
