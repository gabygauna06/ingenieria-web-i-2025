import java.awt.Color;

/**
 * An image filter to invert colors.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroInvertir extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroInvertir.
     * @param nombre El nombre de este filtro.
     */
    public FiltroInvertir(String nombre)
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
                imagen.setPixel(x, y, new Color(255 - pix.getRed(),
                                                255 - pix.getGreen(),
                                                255 - pix.getBlue()));
            }
        }
    }
}
