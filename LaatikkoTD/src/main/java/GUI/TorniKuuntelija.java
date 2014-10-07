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
import laatikkotd.laatikkotd.Torni;

/**
 *
 * @author Juha
 */
public class TorniKuuntelija implements ActionListener {
    
    private Pelinappulat pelinappulat;
    private JButton torni;
    private int paikka;
    
    public TorniKuuntelija(Pelinappulat pelinappulat, JButton torni, int paikka) {
        this.pelinappulat = pelinappulat;
        this.torni = torni;
        this.paikka = paikka;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Torni torni = new Torni(this.paikka);
        pelinappulat.lisaaTorni(torni);
        this.torni.setText("T");
    }
    
}
