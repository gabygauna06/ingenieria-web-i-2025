/**
 * 
 * Esta clase es parte de la apliciacioon "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Esta clase contiene informacion sobre los comandos que han sido editados
 * por el usuario.
 * Un comando consiste de dos cadenas: una PalabraComando y una cadena (por 
 * ejemplo, si el comando fue "tomar mapa", entonces las dos
 * partes seran "TOMAR" y "mapa").
 * 
 * La forma en que esto se usa es: Comandos han sido verificados como
 * palabras comando. Si el usuario ingresa un comando invalido (una palabra 
 * desconocida) entonces la PalabraComando es DESCONOCIDO.
 *
 * Si el comando solo contiene una palabra, entonces la segunda palabra
 * es <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Comando
{
    private PalabraComando palabraComando;
    private String segundaPalabra;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param palabraComando The PalabraComando. DESCONOCIDO if the command word
     *                  was not recognised.
     * @param segundaPalabra The second word of the command. May be null.
     */
    public Comando(PalabraComando palabraComando, String segundaPalabra)
    {
        this.palabraComando = palabraComando;
        this.segundaPalabra = segundaPalabra;
    }

    /**
     *  Devuelve la plabara comando (la primer palabra) de este comando.
     * @return La palabra comando.
     */
    public PalabraComando getPalabraComando()
    {
        return palabraComando;
    }

    /**
     * @return La segunda palabra de este comando. Devuelve null si no 
     * hay segunda palabra.
     */
    public String getSegundaPalabra()
    {
        return segundaPalabra;
    }
    
    /**
     * @return true si el comando no fue reconocido.
     */
    public boolean esDesconocido()
    {
        return (palabraComando == PalabraComando.DESCONOCIDO);
    }

    /**
     * @return true si el comando tiene segunda palabra
     */
    public boolean tieneSegundaPalabra()
    {
        return (segundaPalabra != null);
    }
}

