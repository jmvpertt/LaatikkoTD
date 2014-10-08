/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import laatikkotd.laatikkotd.Pelinappulat;
import laatikkotd.laatikkotd.Ukko;
import java.awt.Component;

/**
 *
 * @author Juha
 */
public class seuraavaVuoroKuuntelija implements ActionListener {
    
    private laatikkotd.laatikkotd.Pelinappulat pelinappulat;
    private Component component;
    private JButton nappi;
    
    public seuraavaVuoroKuuntelija(Pelinappulat pelinappulat, JButton vuoronVaihto, Component component) {
        this.pelinappulat = pelinappulat;
        this.component = component;
        this.nappi = vuoronVaihto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        component.repaint();
        pelinappulat.seuraavaVuoro();
    }
    
}
