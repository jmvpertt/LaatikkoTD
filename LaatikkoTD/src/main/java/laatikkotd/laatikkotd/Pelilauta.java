/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

/**
 *
 * @author Juha
 */
public class Pelilauta {
    
    public void piirraLauta(Ukko ukko, Torni torni, Pelialusta pelialusta) {
        StringBuilder sb = new StringBuilder();
        sb.append(" LÄHTÖ  ");
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            sb.append(".");
        }
        sb.append("MAALI     ");
        
        sb.append("HAUTA\n");
        
        
        sb.append(" UKOT   ");
        for (int i = 0; i < 10; i++) {
            if (i == ukko.haeSijainti() && ukko.haeSijainti() == torni.haeSijainti()) {
                sb.append(" ");
                pelialusta.vieHautausmaalle();
                ukko.kuole();
            }
            else if (i == ukko.haeSijainti()) {
                sb.append("U");
            }
            else {
                sb.append(" ");
            }
            sb.append(".");
        }
        sb.append("     ");
        sb.append("     ");
        
        sb.append(pelialusta.haeKuolleet());
        sb.append("\n");
        
        sb.append(" TORNIT ");
        for (int i = 0; i < 10; i++) {
            if (i == torni.haeSijainti()) {
                sb.append("T");
            }
            else {
                sb.append(" ");
            }
            sb.append(".");
        }
        sb.append("     ");
        
        System.out.println(sb);
        
    }
    
    
}
