package laatikkotd.laatikkotd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
        Pelialusta pelialusta = new Pelialusta();
        Pelilauta pelilauta = new Pelilauta(pelialusta);
        pelialusta.lisaaUkko(new Ukko(3,1));
        pelialusta.lisaaTorni(new Torni(4));

        pelilauta.piirraLauta(pelialusta);
        pelilauta.seuraavaVuoro();
        pelilauta.piirraLauta(pelialusta);
        pelilauta.seuraavaVuoro();
        pelilauta.piirraLauta(pelialusta);
    }
}
