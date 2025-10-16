/**
 * Un filtro que aclara un poco la imagen.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroClaro extends Filtro
{
    /**
     * Constructor de objetos de la clase FiltroClaro.
     * @param nombre El nombre de este filtro.
     */
	public FiltroClaro(String nombre)
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
                imagen.setPixel(x, y, imagen.getPixel(x, y).brighter());
            }
        }
    }

}
