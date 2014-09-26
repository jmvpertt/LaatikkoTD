package laatikkotd.laatikkotd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
        Pelinappulat pelialusta = new Pelinappulat();
        Pelilauta pelilauta = new Pelilauta(pelialusta);
        pelialusta.lisaaUkko(new Ukko(3,1));
        pelialusta.lisaaTorni(new Torni(4));

        pelilauta.piirraLauta();
        pelilauta.seuraavaVuoro();
        pelilauta.piirraLauta();
        pelilauta.seuraavaVuoro();
        pelilauta.piirraLauta();
    }
}
