/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Juha
 */
public class Tervetuloa implements Runnable{

    private JFrame ikkuna;
    
    
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
        JLabel teksti = new JLabel("Tervetuloa!");
        container.add(teksti);
    }
    
}
