import java.awt.Color;

/**
 * Un filtro para crear un efecto de pixelación, como cuando se agranda
 * una imagen de baja resolución.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroPixelizar extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroPixelizar.
     * @param nombre El nombre de este filtro.
     */
    public FiltroPixelizar(String nombre)
    {
        super(nombre);
    }

    /**
     * Aplica este filtro a una imagen.
     * 
     * @param  imagen  La imagen a cambiar por este filtro.
     */
    public void aplicar(ImagenOF image)
    {
        final int TAMANO_PIXEL = 5;
        int ancho = image.getWidth();
        int alto = image.getHeight();
        
        for(int y = 0; y < alto; y += TAMANO_PIXEL) {
            for(int x = 0; x < ancho; x += TAMANO_PIXEL) {
                Color pix = image.getPixel(x, y);
                for(int dy = y; dy < y + TAMANO_PIXEL; dy++) {
                    for(int dx = x; dx < x + TAMANO_PIXEL; dx++) {
                        if( dx < ancho && dy < alto )
                            image.setPixel(dx, dy, pix);
                    }
                }
            }
        }
    }
}
