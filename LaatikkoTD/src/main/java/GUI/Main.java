/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Juha
 */
import javax.swing.SwingUtilities;
import laatikkotd.laatikkotd.Pelinappulat;

public class Main {

    public static void main(String[] args) {
        Tervetuloa t = new Tervetuloa();
        Pelinappulat pn = new Pelinappulat();
        GUI gui = new GUI(pn);
        SwingUtilities.invokeLater(gui);
    }
}