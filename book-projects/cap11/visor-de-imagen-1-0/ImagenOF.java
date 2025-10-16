import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * ImagenOF es una clase que define una imagen en formato OF
 * (Objetos Primero - Objects First).
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.1
 */
public class ImagenOF extends BufferedImage
{
    /**
     * Crea una ImagenOF copiada de una BufferedImage.
     * @param imagen La imagen a copiar.
     */
    public ImagenOF(BufferedImage imagen)
    {
         super(imagen.getColorModel(), imagen.copyData(null), 
               imagen.isAlphaPremultiplied(), null);
    }

    /**
     * Crea una ImagenOF con tamaño especificado y contenido sin especificar.
     * @param ancho  El ancho de la imagen.
     * @param alto   El alto de la imagen.
     */
    public ImagenOF(int ancho, int alto)
    {
        super(ancho, alto, TYPE_INT_RGB);
    }

    /**
     * Dá un color especificado a un pixel dado. El color se
     * representa como un valor (r,g,b).
     * @param x La posición x del pixel.
     * @param y La posición y del pixel.
     * @param color El color del pixel.
     */
    public void setPixel(int x, int y, Color color)
    {
        int pixel = color.getRGB();
        setRGB(x, y, pixel);
    }
    
    /**
     * Toma el valor de color de un pixel en una posición especificada.
     * @param x La posición x del pixel.
     * @param y La posición y del pixel.
     * @return El color del pixel en la posición dada.
     */
    public Color getPixel(int x, int y)
    {
        int pixel = getRGB(x, y);
        return new Color(pixel);
    }

    /**
     * Hace la imagen un poco más oscura.
     */
    public void oscuro()
    {
        int alto = getHeight();
        int ancho = getWidth();
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho; x++) {
                setPixel(x, y, getPixel(x, y).darker());
            }
        }
    }

    /**
     * Hace la imagen un poco más clara.
     */
    public void claro()
    {
        int alto = getHeight();
        int ancho = getWidth();
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho; x++) {
                setPixel(x, y, getPixel(x, y).brighter());
            }
        }
    }

    /**
     * Aplica una operacion umbral de tres niveles.
     * Esto es: redibuja la imagen con tres colores:
     *          blanco, gris y negro.
     */
    public void umbral()
    {
        int alto = getHeight();
        int ancho = getWidth();
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < ancho; x++) {
                Color pixel = getPixel(x, y);
                int brillo = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                if(brillo <= 85) {
                    setPixel(x, y, Color.BLACK);
                }
                else if(brillo <= 170) {
                    setPixel(x, y, Color.GRAY);
                }
                else {
                    setPixel(x, y, Color.WHITE);
                }
            }
        }
    }
}
