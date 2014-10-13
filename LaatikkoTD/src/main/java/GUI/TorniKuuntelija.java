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
    private JButton torniButton;
    private int paikka;
    
    public TorniKuuntelija(Pelinappulat pelinappulat, JButton torni, int paikka) {
        this.pelinappulat = pelinappulat;
        this.torniButton = torni;
        this.paikka = paikka;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.torniButton.getText().equals(" ")) {
            this.torniButton.setText("T");
            this.pelinappulat.lisaaTorni(new Torni(this.paikka));
        }
        else {
            this.torniButton.setText(" ");
            this.pelinappulat.poistaTorni(this.paikka);
        }
    }
    
}
