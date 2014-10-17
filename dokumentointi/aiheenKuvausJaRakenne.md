Aihe: LaatikkoTD Yksinkertainen Tower Defence -tyyppinen vuoropohjainen peli, jossa pelaaja vuorollaan rakentaa puolustusta ja tietokone puolestaan lähettää "ukkoja" päästäkseen palaajan "kotikylään". Jos tornit eivät tuhoa ukkoja, pääsee tietokone pelaajan "kotikylään" ja peli loppuu.

Pelikenttä muodostuu ruudukosta jonka toisessa päässä on pelaajan "kotikylä". Vastapuolella on tietokoneen "ukkojen" lähtöpaikka. Ukot liikkuvat suoraan ruutu per vuoro kohti kotikylää. Reitin varrelle voi pystyttää torneja jotka ampuvat ukkoja niiden tullessa tornien viereen. Torneja ostetaan rahalla. Ukot eivät voi tuhota torneja.

Peli alkaa pelaajan vuorolla jossa voi asettaa torneja rahan salliman määrän. Pelaaja painaa "seuraava vuoro"-nappulaa. Seuraavaksi tietokoneen ukko ilmestyy lähtöpaikkaan. Vuoro siirtyy taas pelaajalle. Seuraavalla tietokoneen vuorolla ukko liikkuu eteenpäin yhden ruudun. Kun kaikki ukot ovat hävinneet ja on päästy vuoroon 9, pelaaja voittaa.


Käyttäjät: Pelaaja ja "Tietokone"

Käyttäjän toiminnot:
  -Ruudun valinta
    Ruudussa näkyy onko ruutu vapaa vai varattu
    Jos vapaa, voi klikata ruutua ja asettaa tornin
    Jos varattu, voi "ylentää" tornin
  -Tornin valinta
    Esiehto: Ruutu valittu, rahaa tarpeeksi
  -Tornin pystytys
    Esiehto: Torni valittu
  -Vuoron päättäminen
    Seuraava vuoro -napin painaminen
  -Pelin lopetus
    Lopeta -nappi
  -Pelin uudelleenaloitus
    Aloita/Nollaa -nappi

Tietokoneen toiminnot:
  -Ukon siirto
    Esiehto: seuraava vuoro -nappia painettu
    
Rakenne:

Pelinappulat-luokka hallinnoi kahta taulukkoa, ukkoArray ja torniArray. Näihin lisätään ukko- ja torni-oliot. Myös raha ja vuoro on luokan hallinnassa. Tämän lisäksi Käyttöliittymä saa suurimman osan käyttäjälle tulostettavista teksteistä Pelinappulat-luokalta. Ohjelman käyttöliittymä luo Pelinappulat -luokan ja käyttää tätä. Pelinappulat luokka puolestaan luo taulukot ja aina tarvittaessa niihin laitettavan olion. Oliot eivät tunne muita luokkia, mutta niiden sijainti-attribuutin avulla ne sijoitetaan oikeaan kohtaa taulukossa. 
Käyttöliittymän Kuuntelija-luokka, eli ActionListener luo Pelinappulat-luokan. Peliä nollattaessa, Kuuntelija-luokka luo aina uuden Pelinappulat-luokan. GUI-luokka käynnistää käyttöliittymän, mutta Kuuntelija-luokka hoitaa nappien päivittämisen. Main vain käynnistää ohjelman.
