/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import laatikkotd.laatikkotd.Pelinappulat;
import laatikkotd.laatikkotd.Torni;

/**
 *
 * @author Juha
 */
public class addTorniKuuntelija implements ActionListener {
    
    private laatikkotd.laatikkotd.Pelinappulat pelinappulat;
    private JButton addTorni0;
    private JButton addTorni1;
    private JButton addTorni2;
    private JButton addTorni3;
    private JButton addTorni4;
    private JButton addTorni5;
    private JButton addTorni6;
    private JButton addTorni7;
    private JButton addTorni8;
    private JButton addTorni9;
    
    public addTorniKuuntelija(Pelinappulat pelinappulat, JButton addTorni0) {
        this.pelinappulat = pelinappulat;
        this.addTorni0 = addTorni0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Torni torni = new Torni(0);
        pelinappulat.lisaaTorni(torni);
        
    }
    
}
