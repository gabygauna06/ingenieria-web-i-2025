import java.awt.Color;

/**
 * Un filtro para remover el color de una imagen.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroEscalaGris extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroEscalaGris.
     * @param nombre El nombre de este filtro.
     */
    public FiltroEscalaGris(String nombre)
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
            for(int x = 0; x < ancho; x++) {
                Color pix = imagen.getPixel(x, y);
                int prom = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;
                imagen.setPixel(x, y, new Color(prom, prom, prom));
            }
        }
    }
}
