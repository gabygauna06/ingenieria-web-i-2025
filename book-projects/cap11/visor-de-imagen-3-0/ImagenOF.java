import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * ImagenOF es una clase que define una imagen en formato OF
 * (Objetos Primero - Objects First).
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2.0
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
}
