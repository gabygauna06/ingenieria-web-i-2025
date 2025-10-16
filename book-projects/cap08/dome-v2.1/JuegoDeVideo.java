/**
 * La clase JuegoDeVideo representa un objecto Juego. Se almacena informaci�n
 * sobre el Video Juego que puede ser consultada.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traduccion: Maximiliano A. Eschoyez
 * @author Carlos A. Bart�
 * @version 2006.03.30
 */
public class JuegoDeVideo extends Juego
{
   private String plataforma;

    /**
     * Inicializa el JuegoDeVideo.
     * @param elTitulo El titulo del JuegoDeVideo.
     * @param plataforma La plataforma del JuegoDeVideo.
     * @param temas El numero de jugadores del JuegoDeVideo.
     * @param tiempo El tiempo que dura el JuegoDeVideo.
     */
    public JuegoDeVideo(String elTitulo, String plataforma, int jugadores, int tiempo)
    {
        super(elTitulo, jugadores, tiempo);
        this.plataforma = plataforma;
    }

    /**
     * @return La plataforma de este JuegoDeVideo.
     */
    public String getPlataforma()
    {
        return plataforma;
    }

    public void imprimir()
    {
        super.imprimir();
        System.out.println("Soy un VIDEO juego");
    }
}
