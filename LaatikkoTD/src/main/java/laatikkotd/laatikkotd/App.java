package laatikkotd.laatikkotd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
        Pelilauta pelilauta = new Pelilauta();
        Pelialusta pelialusta = new Pelialusta();
        Ukko ukko = new Ukko(1);
        Torni torni = new Torni(4);
        pelilauta.piirraLauta(ukko, torni, pelialusta);
        ukko.siirra();
        torni = new Torni(3);
        pelilauta.piirraLauta(ukko, torni, pelialusta);
        ukko.siirra();
        pelilauta.piirraLauta(ukko, torni, pelialusta);
    }
}
