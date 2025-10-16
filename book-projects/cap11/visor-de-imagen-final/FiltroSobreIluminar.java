import java.awt.Color;

/**
 * Un filtro para crear el efecto de sobre iluminación.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroSobreIluminar extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroSobreIluminar.
     * @param nombre El nombre de este filtro.
     */
    public FiltroSobreIluminar(String nombre)
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
                int rojo = pix.getRed();
                if(rojo <= 127) {
                    rojo = 255 - rojo;
                }
                int verde = pix.getGreen();
                if(verde <= 127) {
                    verde = 255 - verde;
                }
                int azul = pix.getBlue();
                if(azul <= 127) {
                    azul = 255 - azul;
                }
                imagen.setPixel(x, y, new Color(rojo, verde, azul));
            }
        }
    }

}
