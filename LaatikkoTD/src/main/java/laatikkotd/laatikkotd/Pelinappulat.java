/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikkotd.laatikkotd;

import java.util.Arrays;

/**
 *
 * @author juha
 */
public class Pelinappulat {

    private int kuolleet;
    private Ukko[] ukkoArray;
    private Torni[] torniArray;
    private int vuoro;
    private int raha;
    private String aputeksti;
    
    /**
     * Luokka hoitaa keskeisen toimintalogiikan. Ukkojen ja tornien paikka, rahan määrä sekä
     * mikä vuoro nyt on ovat kaikki tämän luokan hallinnassa. Luokka tarjoaa metodit ukkojen ja
     * tornien lisäämiseen ja poistamiseen. Konstruktori luo taulukot ukoille ja torneille johon kyseiset
     * oliot laitetaan.
     */
    public Pelinappulat() {
        this.kuolleet = 0;
        this.ukkoArray = new Ukko[10];
        this.torniArray = new Torni[10];
        this.vuoro = 0;
        this.raha = 4;
        this.aputeksti = "";
        
    }
    
    /**
    * Metodi lisää torni-olion torniArray-taulukkoon parametrina annetulle
    * paikalle. Jos raha on loppu, metodi ei tee mitään. Jos paikalla on jo
    * torni, metodi ylentää sen.
    * 
    * @param sijainti lisättävän tornin sijainti torniArray-taulukossa
    */
    public void lisaaTorni(int sijainti) {
        if (this.raha == 0) {
            return;
        }
        else if (this.torniArray[sijainti] != null) {
            if (this.torniArray[sijainti].toString().equals("T")) {
                Torni torni = new Torni(sijainti);
                torni.ylenna();
                this.raha--;
                this.torniArray[sijainti] = torni;
            }
        }
//        else if (this.torniArray[sijainti].toString() == "T+") {
//            return;
//        }
        else {
            Torni torni = new Torni(sijainti);
            this.raha--;
            this.torniArray[sijainti] = torni;
        }
    }
    
    /**
    * Metodi lisää ukko-olion ukkoArray-taulukkoon.
    * 
    * @param sijainti lisättävän ukon sijainti ukkoArray-taulukossa
    * @param hp ukon kestämän iskujen määrä
    * 
    */
    public void lisaaUkko (int sijainti, int hp) {
        Ukko ukko = new Ukko(sijainti, hp);
        this.ukkoArray[ukko.getSijainti()] = ukko;
    }
    
    /**
    * Metodi poistaa ukko-olion asettamalla sen sen paikka nulliksi
    * ukkoArray-taulukossa.
    * 
    * @param i poistettavan ukon sijainti ukkoArray-taulukossa.
    */
    public void tapaUkko(int i) {
        this.ukkoArray[i] = null;
        this.kuolleet++;
    }
    
    
    public Torni[] getTorniArray() {
        return this.torniArray;
    }
    
    public Ukko[] getUkkoArray() {
        return this.ukkoArray;
    }
    
    public int getRahaaJaljella() {
        return this.raha;
    }
    
    public void setRaha(int summa) {
        this.raha = summa;
    }
    /**
    * Metodi lisää +1 hautausmaalle.
    */
    public void lisaaHautausmaalle() {
        this.kuolleet++;
    }
    
    /**
    * Metodi palauttaa kuolleet kokonaislukuna
    * 
    * @return kuolleiden määrä.
    */
    public int getKuolleet() {
        return this.kuolleet;
    }
    
    public int getVuoro() {
        return this.vuoro;
    }
    
    /**
     * Asettaa vuoroksi 0.
     */
    public void nollaaVuoro() {
        this.vuoro = 0;
    }
    
    /**
     * Metodi kutsuu seuraavaVuoro() -metodia ja lisää this.vuoroon + 1.
     * 
     * @see #seuraavaVuoro() 
     * 
     */
    public void eteneVuoro() {
        seuraavaVuoro();
        this.vuoro ++;
    } 
    
    /**
     * Metodi luo aluksi aputaulukon johon se lisää ukkojen uuden sijainnin.
     * Ukkoarray korvataan tämän jälkeen aputaulukolla. Seuraavaksi tarkistetaan
     * jos ukkoArray ja torniArray-taulukoissa on samalla indeksillä olio. Jos
     * on kyseisen indeksin ukko-olio poistetaan tapaUkko -metodilla. Tätä
     * metodia kutsutaan eteneVuoro()-metodissa.
     * 
     * @see #eteneVuoro() 
     */
    public void seuraavaVuoro() {
        Ukko[] ukkoArrayApu = new Ukko[10];
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                break;
            }
            else if (this.ukkoArray[i] != null) {
                this.ukkoArray[i].siirra();
            }
            ukkoArrayApu[i + 1] = this.ukkoArray[i];
        }
        this.ukkoArray = ukkoArrayApu.clone();
        
        for (int j = 0; j < 10 ; j++) {
            if (this.ukkoArray[j] != null && this.torniArray[j] != null) {
                int hp = this.ukkoArray[j].getHp();
                int voima = this.torniArray[j].getVoima();
                if (hp - voima > 2) {
                    this.getUkkoArray()[j] = new Ukko(j, hp);
                    this.getUkkoArray()[j].setMerkki("u");
                }
                else if (hp - voima == 2) {
                    this.getUkkoArray()[j] = new Ukko(j, 1);
                    this.getUkkoArray()[j].setMerkki("X");
                }
                else if (hp - voima <= 1) {
                    tapaUkko(j);
                }
            }
        }
        
        
    }
    
    /**
     * Metodi palauttaa halutun tekstin käyttöliittymälle. Neljä eri tekstin-
     * pätkää. Valitaan numeroilla 0 -3, muut numerot palauttavat tyhjän
     * merkkijono.
     * 
     * @param vaihe 0 - 3 riippuen halutusta tekstistä
     * @return  0 - "Tervetuloa!\nKun olet valmis, paina Aloita-nappia"
     *          1 - "Vuoro: int" (vuoron numero)
     *              "Rahaa: int" (Kuinka paljon rahaa jäljellä
     *          2 - "Peli päättyi, hävisit!"
     *          3 - "Voitit"
     * 
     * 
     */
    
    public String getApuTeksti(int vaihe) {
        if (vaihe == 0) {
            this.aputeksti = "Tervetuloa!\nKun olet valmis, paina Aloita-nappia";
            return this.aputeksti;
        }
        else if (vaihe == 1) {
            this.aputeksti = "Vuoro: "+(this.getVuoro() + 1)+
                            "\nRahaa: "+this.getRahaaJaljella()+
                            "\nKuolleita: "+this.getKuolleet()+
//                            "\n"+Arrays.toString(getTorniArray())+
//                            "\n"+Arrays.toString(getUkkoArray())+
                            "\n\n";
            return this.aputeksti;
        }
        else if (vaihe == 2) {
            this.aputeksti = "Peli päättyi, hävisit!";
            return this.aputeksti;
        }
        else if (vaihe == 3) {
            this.aputeksti = "Voitit!";
            return this.aputeksti;
        }
        else {
            return "";
        }
        
    }
    
}