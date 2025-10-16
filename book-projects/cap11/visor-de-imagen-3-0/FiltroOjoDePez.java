import java.awt.Color;

/**
 * Un filtro que genera un efecto similar a las lentes ojo de pez
 * de las cámaras (Especialmente utilizada para portarretratos).
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class FiltroOjoDePez extends Filtro
{
    // constantes:
    private final static int ESCALA = 20;   // esto define la potencia del filtro
    private final static double DOS_PI = 2 * Math.PI;

    /**
     * Constructor de objetos de la clase FiltroOjoDePez.
     * @param nombre El nombre de este filtro.
     */
    public FiltroOjoDePez(String nombre)
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
        ImagenOF original = new ImagenOF(imagen);

        int[] xa = calcularArregloX(ancho);
        int[] ya = calcularArregloY(alto);
        
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho; x++) {
                imagen.setPixel(x, y, original.getPixel(x + xa[x], y + ya[y]));
            }
        }
    }

    /**
     * Calcula y devuelve un arreglo de desplazamientos horizontales para cada
     * columna de pixeles. Estos pueden aplicarse como el desplazamiento
     * horizontal para cada pixel.
     */
    private int[] calcularArregloX(int ancho)
    {
        int[] arregloX = new int[ancho];
        
        for(int i=0; i < ancho; i++) {
            arregloX[i] = (int)(Math.sin( ((double)i / ancho) * DOS_PI) * ESCALA);
        }
        return arregloX;
    }

    /**
     * Calcula y devuelve un arreglo de desplazamientos verticales para cada
     * fila de pixeles. Estos pueden aplicarse como el desplazamiento
     * vertical para cada pixel.
     */
    private int[] calcularArregloY(int alto)
    {
        int[] arregloY = new int[alto];
        
        for(int i=0; i < alto; i++) {
            arregloY[i] = (int)(Math.sin( ((double)i / alto) * DOS_PI) * ESCALA);
        }
        return arregloY;
    }
}
