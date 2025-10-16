import java.awt.Color;

/**
 * Un filtro umbral de tres niveles en tonos de gris.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroUmbral extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroUmbral.
     * @param nombre El nombre de este filtro.
     */
    public FiltroUmbral(String nombre)
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
                Color pixel = imagen.getPixel(x, y);
                int brillo = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                if(brillo <= 85) {
                    imagen.setPixel(x, y, Color.BLACK);
                }
                else if(brillo <= 170) {
                    imagen.setPixel(x, y, Color.GRAY);
                }
                else {
                    imagen.setPixel(x, y, Color.WHITE);
                }
            }
        }
    }
}
