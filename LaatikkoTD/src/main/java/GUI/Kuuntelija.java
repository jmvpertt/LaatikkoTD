/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import laatikkotd.laatikkotd.Pelinappulat;

/**
 *
 * @author juha
 */
public class Kuuntelija implements ActionListener{

    private Pelinappulat pelinappulat;
    private JTextArea info;
    private JPanel ukot;
    private JButton t0;
    private JButton t1;
    private JButton t2;
    private JButton t3;
    private JButton t4;
    private JButton t5;
    private JButton t6;
    private JButton t7;
    private JButton t8;
    private JButton t9;
    private JButton vuoro;
    private JButton nollaa;
    private JButton lopeta;
    private JFrame ikkuna;
    
    
    
    public Kuuntelija (JTextArea info, JPanel ukot, JButton t0, JButton t1, JButton t2, JButton t3, JButton t4, JButton t5, JButton t6, JButton t7, JButton t8, JButton t9, JButton vuoro, JButton nollaa, JButton lopeta, JFrame ikkuna) {
        this.pelinappulat = new Pelinappulat();
        this.info = info;
        this.ukot = ukot;
        this.t0 = t0;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
        this.vuoro = vuoro;
        this.nollaa = nollaa;
        this.lopeta = lopeta;
        this.ikkuna = ikkuna;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == this.t0) {
            this.pelinappulat.lisaaTorni(0);
            this.t0.setText(this.pelinappulat.getTorniArray()[0].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella()+" "+this.pelinappulat.getTorniArray()[0].toString());
        }
        
        else if (e.getSource() == this.t1) {
            this.pelinappulat.lisaaTorni(1);
            this.t1.setText(this.pelinappulat.getTorniArray()[1].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t2) {
            this.pelinappulat.lisaaTorni(2);
            this.t2.setText(this.pelinappulat.getTorniArray()[2].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t3) {
            this.pelinappulat.lisaaTorni(3);
            this.t3.setText(this.pelinappulat.getTorniArray()[3].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t4) {
            this.pelinappulat.lisaaTorni(4);
            this.t4.setText(this.pelinappulat.getTorniArray()[4].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t5) {
            this.pelinappulat.lisaaTorni(5);
            this.t5.setText(this.pelinappulat.getTorniArray()[5].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t6) {
            this.pelinappulat.lisaaTorni(6);
            this.t6.setText(this.pelinappulat.getTorniArray()[6].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t7) {
            this.pelinappulat.lisaaTorni(7);
            this.t7.setText(this.pelinappulat.getTorniArray()[7].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t8) {
            this.pelinappulat.lisaaTorni(8);
            this.t8.setText(this.pelinappulat.getTorniArray()[8].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.t9) {
            this.pelinappulat.lisaaTorni(9);
            this.t9.setText(this.pelinappulat.getTorniArray()[9].toString());
            this.info.append("Torni lisatty, rahaa jaljella: "+this.pelinappulat.getRahaaJaljella());
        }
        
        else if (e.getSource() == this.vuoro) {
            this.vuoro.setText("Seuraava vuoro ("+this.pelinappulat.getVuoro()+")");
            
            JLabel ruutu = new JLabel("U", SwingConstants.CENTER);
            JLabel haavoitettu = new JLabel("u", SwingConstants.CENTER);
            JLabel tapettu = new JLabel("X", SwingConstants.CENTER);
            JLabel tyhjaruutu = new JLabel(" ", SwingConstants.CENTER);
        
            this.pelinappulat.setVuoro(1);
            int i = this.pelinappulat.getVuoro();
        
            this.ukot.remove(i - 1);
            this.ukot.add(tyhjaruutu, i - 1);
            this.ukot.remove(i);
            
            if (this.pelinappulat.getUkkoArray()[i] != null) {
                if (this.pelinappulat.getUkkoArray()[i].toString().equals("U")) {
                    this.ukot.add(ruutu, i);
                }
                else if (this.pelinappulat.getUkkoArray()[i].toString().equals("u")) {
                    this.ukot.add(haavoitettu, i);
                }
                else if (this.pelinappulat.getUkkoArray()[i].toString().equals("X")) {
                    this.ukot.add(tapettu, i);
                    this.info.append("Ukko tuhottu");
                    this.info.append("Voitit");
                    this.vuoro.removeActionListener(this);
                }
            }
            else if (this.pelinappulat.getUkkoArray()[i] == null) {
                this.ukot.add(tapettu, i);
                this.info.append("Ukko tuhottu");
                this.info.append("\n\nVoitit");
                this.vuoro.removeActionListener(this);
                return;
            }
            
            if (this.pelinappulat.getUkkoArray()[9] != null) {
                this.info.append("Peli päättyi, hävisit!");
                this.vuoro.removeActionListener(this);
                return;
            }
            
            if (this.pelinappulat.getVuoro() == 9) {
                this.info.append("\n\nVoitit!");
                this.vuoro.removeActionListener(this);
                return;
            }
            
            this.info.append("Vuoro vaihtui"+Arrays.toString(this.pelinappulat.getTorniArray())+" "+Arrays.toString(this.pelinappulat.getUkkoArray()) +"\n");
        }
        
        else if (e.getSource() == this.nollaa) {
            this.pelinappulat = new Pelinappulat();
            this.t0.setText(""+0);
            this.t1.setText(""+1);
            this.t2.setText(""+2);
            this.t3.setText(""+3);
            this.t4.setText(""+4);
            this.t5.setText(""+5);
            this.t6.setText(""+6);
            this.t7.setText(""+7);
            this.t8.setText(""+8);
            this.t9.setText(""+9);
            
            this.vuoro.addActionListener(this);
            this.vuoro.setText("Seuraava vuoro ("+this.pelinappulat.getVuoro()+")");
            
            for (int i = 0 ; i < 10 ; i++) {
                this.ukot.remove(i);
                if (i == 0) {
                    this.ukot.add(new JLabel("U", SwingConstants.CENTER), i);
                }
                else if (i == 9) {
                    this.ukot.add(new JLabel("KYLÄ", SwingConstants.CENTER), i);
                }
                else {
                    this.ukot.add(new JLabel(" "), i);
                }
            }
            
            this.info.append("Peli nollattu");
        }
        
        if (this.pelinappulat.getRahaaJaljella() == 0) {
            this.t0.removeActionListener(this);
            this.t1.removeActionListener(this);
            this.t2.removeActionListener(this);
            this.t3.removeActionListener(this);
            this.t4.removeActionListener(this);
            this.t5.removeActionListener(this);
            this.t6.removeActionListener(this);
            this.t7.removeActionListener(this);
            this.t8.removeActionListener(this);
            this.t9.removeActionListener(this);
        }
        
    }
    
    
}
