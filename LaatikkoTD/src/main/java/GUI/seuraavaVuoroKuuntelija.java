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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import laatikkotd.laatikkotd.Torni;

/**
 *
 * @author Juha
 */
public class seuraavaVuoroKuuntelija implements ActionListener {
    
    private Pelinappulat pelinappulat;
    private JPanel panel;
    private JButton nappi;
    
    public seuraavaVuoroKuuntelija(Pelinappulat pelinappulat, JButton vuoronVaihto, JPanel panel) {
        this.pelinappulat = pelinappulat;
        this.panel = panel;
        this.nappi = vuoronVaihto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel ruutu = new JLabel("U", SwingConstants.CENTER);
        JLabel tyhjaruutu = new JLabel(" ", SwingConstants.CENTER);
        
        pelinappulat.setVuoro(1);
        int i = pelinappulat.getVuoro();
        
        panel.remove(i - 1);
        panel.add(tyhjaruutu, i - 1);
        panel.remove(i);
        panel.add(ruutu, i);
        
    }
    
}