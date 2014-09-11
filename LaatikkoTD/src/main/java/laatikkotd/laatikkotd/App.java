package laatikkotd.laatikkotd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Pelialusta pelialusta = new Pelialusta();
        Torni torni = new Torni();
        pelialusta.setTorni(1, torni);
        pelialusta.tulostaTornit();
    }
}
