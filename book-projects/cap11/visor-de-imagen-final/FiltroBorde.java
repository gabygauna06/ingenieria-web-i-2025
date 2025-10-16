import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

/**
 * Un filtro para detectar bordes y los resalta, se asemeja a un
 * dibujo pintado con lápiz
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroBorde extends Filtro
{
    private static final int TOLERANCIA = 20;
    
    private ImagenOF original;
    private int ancho;
    private int alto;

    /**
     * Constructor de objetos de la clase FiltroBorde.
     * @param nombre El nombre de este filtro.
     */
    public FiltroBorde(String nombre)
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
                imagen.setPixel(x, y, borde(x, y));
            }
        }
    }

    /**
     * Devuelve un nuevo color que es color suavizado para una posición
     * dada. El "color suavizado" es el valor de color resultante de
     * promediar ese pixel con los pixeles adyacentes.
     * @param xpos La posición x del pixel.
     * @param ypos La posición y del pixel.
     * @return El color suavizado.
     */
    private Color borde(int xpos, int ypos)
    {
        List<Color> pixeles = new ArrayList<Color>(9);
        
        for(int y = ypos-1; y <= ypos+1; y++) {
            for(int x = xpos-1; x <= xpos+1; x++) {
                if( x >= 0 && x < ancho && y >= 0 && y < alto ) {
                    pixeles.add(original.getPixel(x, y));
                }
            }
        }

        return new Color(255 - difRojo(pixeles), 255 - difVerde(pixeles), 255 - difAzul(pixeles));
    }

    /**
     * @param pixeles La lista de pixeles a promediar.
     * @return El promedio de todos los valores rojo en la lista de pixeles.
     */
    private int difRojo(List<Color> pixeles)
    {
        int max = 0;
        int min = 255;
        for(Color color : pixeles) {
            int val = color.getRed();
            if(val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
        }
        int diferencia = max - min - TOLERANCIA;
        if(diferencia < 0) {
            diferencia = 0;
        }
        return diferencia;
    }

    /**
     * @param pixeles La lista de pixeles a promediar.
     * @return El promedio de todos los valores verde en la lista de pixeles.
     */
    private int difVerde(List<Color> pixeles)
    {
        int max = 0;
        int min = 255;
        for(Color color : pixeles) {
            int val = color.getGreen();
            if(val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
        }
        int diferencia = max - min - TOLERANCIA;
        if(diferencia < 0) {
            diferencia = 0;
        }
        return diferencia;
    }

    /**
     * @param pixeles La lista de pixeles a promediar.
     * @return El promedio de todos los valores azul en la lista de pixeles.
     */
    private int difAzul(List<Color> pixeles)
    {
        int max = 0;
        int min = 255;
        for(Color color : pixeles) {
            int val = color.getBlue();
            if(val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
        }
        int diferencia = max - min - TOLERANCIA;
        if(diferencia < 0) {
            diferencia = 0;
        }
        return diferencia;
    }

}
