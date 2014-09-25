/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author Juha
 */
public class Pelilauta {
    
    private Pelialusta pelialusta;
    private char[] ukot;
    private char[] tornit;
    private int hautausmaa;
    
    
    public Pelilauta(Pelialusta pelialusta) {
        this.pelialusta = pelialusta;
        this.ukot = new char[10];
        this.tornit = new char[10];
        this.hautausmaa = 0;
    }
    
    /**
    * Metodi piirtää ukkojen paikat taulukon toString -metodin
    * avulla.
    */
    public void piirraUkot() {
        this.ukot = new char[10];
        for (Ukko i : pelialusta.getUkot()) {
            String str = "U";
            this.ukot[i.haeSijainti()] = str.charAt(0);
        }
        System.out.println(Arrays.toString(this.ukot));
    }
    
    /**
    * Metodi piirtää tornien paikat taulukon toString -metodin
    * avulla.
    */
    public void piirraTornit() {
        for (Torni i : pelialusta.getTornit()) {
            String str = "T";
            this.tornit[i.haeSijainti()] = str.charAt(0);
        }
        System.out.println(Arrays.toString(this.tornit));
    }
    
    /**
    * Metodi antaa kuolleiden ukkojen määrän kokonaislukuna
    */
    public void piirraHautausmaa() {
        System.out.println(pelialusta.getKuolleet());
    }
    
    /**
    * Metodi käy läpi kaikki ukko-oliot ja siirtää niitä askeleen eteenpäin.
    * Jos torni ja ukko ovat samalla paikalla, se poistaa ukon ja lisää
    * hautausmaalle +1
    */
    public void seuraavaVuoro() {
        for (Ukko i : pelialusta.getUkot()) {
            if (i.haeSijainti() < 10 ) {
                i.siirra();
            }
        }
        String str = "T";
        int torneja = Arrays.binarySearch(this.tornit, str.charAt(0));
        str = "U";
        int ukkoja = Arrays.binarySearch(this.ukot, str.charAt(0));
        if (torneja == ukkoja) {
            pelialusta.poistaUkko(ukkoja);
            pelialusta.lisaaHautausmaalle();
        }
        
    }
    
    
    /**
    * Metodi piirtää ukkojen ja tornien paikat taulukon toString -metodin
    * avulla ja antaa kuolleiden määrän kokonailukuna.
    */
    public void piirraLauta(Pelialusta pelialusta) {
        piirraUkot();
        piirraTornit();
        piirraHautausmaa();
    }

}
