import java.awt.Color;

/**
 * Un filtro que espeja la imagen en forma horizontal.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroEspejo extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroEspejo.
     * @param nombre El nombre de este filtro.
     */
    public FiltroEspejo(String nombre)
    {
        super(nombre);
    }

    /**
     * Aplica este filtro a una imagen.
     * 
     * @param  imagen  La imagen a cambiar por este filtro.
     */
    public void aplicar(ImagenOF imagen)
    {
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho / 2; x++) {
                Color izquierda = imagen.getPixel(x, y);
                imagen.setPixel(x, y, imagen.getPixel(ancho - 1 - x, y));
                imagen.setPixel(ancho - 1 - x, y, izquierda);
            }
        }
    }
}
