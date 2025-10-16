/**
 * La clase CD representa un objecto Juego. Se almacena informaci�n
 * sobre el Juego que puede ser consultada.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traduccion: Maximiliano A. Eschoyez
 * @author Carlos A. Bart�
 * @version 2006.03.30
 */
public class Juego extends Elemento
{
   private int numeroDeJugadores;

    /**
     * Inicializa el Juego.
     * @param elTitulo El titulo del Juego.
     * @param tiempo El tiempo que dura el Juego.
     * @param temas El numero de jugadores del Juego.
     */
    public Juego(String elTitulo, int jugadores, int tiempo)
    {
        super(elTitulo, tiempo);
        numeroDeJugadores = jugadores;
    }

    
    /**
     * @return El numero de jugadores de este Juego.
     */
    public int getNumeroDeJugadores()
    {
        return numeroDeJugadores;
    }
    
//    public void imprimir()
//    {
//        super.imprimir();
//        System.out.println("Soy un juego");
//    }
}
