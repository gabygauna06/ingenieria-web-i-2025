/**
 * La clase JuegoDeMesa representa un objecto Juego. Se almacena informaci�n
 * sobre el Juego de Mesa que puede ser consultada.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traduccion: Maximiliano A. Eschoyez
 * @author Carlos A. Bart�
 * @version 2006.03.30
 */
public class JuegoDeMesa extends Juego
{
   private String tablero;

    /**
     * Inicializa el JuegoDeMesa.
     * @param elTitulo El titulo del JuegoDeMesa.
     * @param plataforma El tablero del JuegoDeMesa.
     * @param temas El numero de jugadores del JuegoDeMesa.
     * @param tiempo El tiempo que dura el JuegoDeMesa.
     */
    public JuegoDeMesa(String elTitulo, String tablero, int jugadores, int tiempo)
    {
        super(elTitulo, jugadores, tiempo);
        this.tablero = tablero;
    }

    /**
     * @return El tablero de este JuegoDeMesa.
     */
    public String getTablero()
    {
        return tablero;
    }

}
