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

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
    }
}