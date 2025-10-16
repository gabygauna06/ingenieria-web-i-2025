import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Un filtro que suaviza los bordes y la pixelación. Parecido a una
 * lente de suavizado.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroSuavizar extends Filtro
{
    private ImagenOF original;
    private int ancho;
    private int alto;
    
    /**
     * Constructor de objetos de la clase FiltroSuavizar.
     * @param nombre El nombre de este filtro.
     */
    public FiltroSuavizar(String nombre)
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
        original = new ImagenOF(imagen);
        ancho = original.getWidth();
        alto = original.getHeight();
        
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho; x++) {
                imagen.setPixel(x, y, suavizar(x, y));
            }
        }
    }
    
    /**
     * Devuelve un nuevo color que es el color suavizado de una posición
     * dada. El "color suavizado" es el color resultante de promediar
     * el pixel y los pixeles adyacentes.
     * @param xpos La posición x del pixel.
     * @param ypos La posición x del pixel.
     * @return El color suavizado.
     */
    private Color suavizar(int xpos, int ypos)
    {
        List<Color> pixeles = new ArrayList<Color>(9);
        
        for(int y = ypos - 1; y <= ypos + 1; y++) {
            for(int x = xpos - 1; x <= xpos + 1; x++) {
                if( x >= 0 && x < ancho && y >= 0 && y < alto )
                    pixeles.add(original.getPixel(x, y));
            }
        }

        return new Color(promRojo(pixeles), promVerde(pixeles), promAzul(pixeles));
    }

    /**
     * @param pixeles La lista de los pixeles.
     * @return El promedio de todos los valores rojo en la lista de pixeles.
     */
    private int promRojo(List<Color> pixeles)
    {
        int total = 0;
        for(Color color : pixeles) {
            total += color.getRed();
        }
        return total / pixeles.size();
    }

    /**
     * @param pixeles La lista de los pixeles.
     * @return El promedio de todos los valores verde en la lista de pixeles.
     */
    private int promVerde(List<Color> pixeles)
    {
        int total = 0;
        for(Color color : pixeles) {
            total += color.getGreen();
        }
        return total / pixeles.size();
    }

    /**
     * @param pixeles La lista de los pixeles.
     * @return El promedio de todos los valores azul en la lista de pixeles.
     */
    private int promAzul(List<Color> pixeles)
    {
        int total = 0;
        for(Color color : pixeles) {
            total += color.getBlue();
        }
        return total / pixeles.size();
    }
}
