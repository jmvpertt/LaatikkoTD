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

/**
 *
 * @author Juha
 */
public class seuraavaVuoroKuuntelija implements ActionListener {
    
    private laatikkotd.laatikkotd.Pelinappulat pelinappulat;
    private JButton vuoronVaihto;
    private JLabel ruutu1;
    private JLabel ruutu2;
    private JLabel ruutu3;
    private JLabel ruutu4;
    private JLabel ruutu5;
    private JLabel ruutu6;
    private JLabel ruutu7;
    private JLabel ruutu8;
    private JLabel ruutu9;
    private JLabel ruutu0;

    
    public seuraavaVuoroKuuntelija(Pelinappulat pelinappulat, JButton vuoronVaihto, JLabel ruutu0,
            JLabel ruutu1, JLabel ruutu2, JLabel ruutu3, JLabel ruutu4, JLabel ruutu5,
            JLabel ruutu6, JLabel ruutu7, JLabel ruutu8, JLabel ruutu9 ) {
        this.pelinappulat = pelinappulat;
        this.vuoronVaihto = vuoronVaihto;
        this.ruutu0 = ruutu0;
        this.ruutu1 = ruutu1;
        this.ruutu2 = ruutu2;
        this.ruutu3 = ruutu3;
        this.ruutu4 = ruutu4;
        this.ruutu5 = ruutu5;
        this.ruutu6 = ruutu6;
        this.ruutu7 = ruutu7;
        this.ruutu8 = ruutu8;
        this.ruutu9 = ruutu9;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pelinappulat.seuraavaVuoro();
        String[] ukkoja = new String[10];
        for (Ukko i : pelinappulat.getUkot()) { 
            for (int j = 0; j < 10; j++ ) {
                if (i.haeSijainti() == j) {
                    ukkoja[j] = "U";
                }
                else {
                    ukkoja[j] = " ";
                }
            }            
        }
        
        this.ruutu0.setText(ukkoja[0]);
        this.ruutu1.setText(ukkoja[1]);
        this.ruutu2.setText(ukkoja[2]);
        this.ruutu3.setText(ukkoja[3]);
        this.ruutu4.setText(ukkoja[4]);
        this.ruutu5.setText(ukkoja[5]);
        this.ruutu6.setText(ukkoja[6]);
        this.ruutu7.setText(ukkoja[7]);
        this.ruutu8.setText(ukkoja[8]);
        this.ruutu9.setText(ukkoja[9]);
    }
    
}
