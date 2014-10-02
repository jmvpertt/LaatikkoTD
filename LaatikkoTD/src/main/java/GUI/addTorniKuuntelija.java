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
public class addTorniKuuntelija implements ActionListener {
    
    private laatikkotd.laatikkotd.Pelinappulat pelinappulat;
    private JButton addTorni;
    private JLabel TorniLabel;
    private int paikka;
    
    public addTorniKuuntelija(Pelinappulat pelinappulat, JButton addTorni, JLabel Torni, int paikka) {
        this.pelinappulat = pelinappulat;
        this.addTorni = addTorni;
        this.TorniLabel = Torni;
        this.paikka = paikka;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Torni torni = new Torni(this.paikka);
        pelinappulat.lisaaTorni(torni);
        this.TorniLabel.setText("T");
    }
    
}
