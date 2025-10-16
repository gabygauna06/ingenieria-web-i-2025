import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

/**
 * Un PanelDeImagen es un componente de Swing que puede mostrar una ImagenOF.
 * Está construído como una subclase de JComponent con la funcionalidad
 * adicional de establecer una ImagenOF que se mostrará en la superficie
 * de este componente.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class PanelDeImagen extends JComponent
{
    // El ancho y alto actual de este panel
    private int ancho, alto;

    // Un buffer de imagen interio que se utiliza para pintar. Para el panel
    // actual, este buffer se copiará luego a la pantalla.
    private ImagenOF panelImagen;

    /**
     * Crea un PanelDeImagen nuevo vacío.
     */
    public PanelDeImagen()
    {
        ancho = 360;    // tamaño arbitrario para el panel vacío
        alto = 240;
        panelImagen = null;
    }

    /**
     * Establece la imagen que este panel debe mostrar.
     * 
     * @param imagen  La imagen que se mostrará.
     */
    public void setImagen(ImagenOF imagen)
    {
        if(imagen != null) {
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            panelImagen = imagen;
            repaint();
        }
    }
    
    /**
     * Borra la imagen en este panel.
     */
    public void borrarImagen()
    {
        if(panelImagen != null) {
            Graphics graficoImagen = panelImagen.getGraphics();
            graficoImagen.setColor(Color.LIGHT_GRAY);
            graficoImagen.fillRect(0, 0, ancho, alto);
            repaint();
        }
    }
    
    // Los siguientes metodos son redefiniciones de los metodos
    // heredados de las superclases.
    
    /**
     * Decirle al gestor de disposicion cuan grane deseamos que sea.
     * (Este metodo es llamado por los gestores de disposicion para
     * ubicar los componentes).
     * 
     * @return La dimension preferida para este componente.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(ancho, alto);
    }
    
    /**
     * Este componente necesita volver a ser mostrado. Se copia la imagen
     * interna en la pantalla. (Este metodo es llamado por el dibujador de
     * pantalla de Swing cada vez que quiere mostrar este componente).
     * 
     * @param g El contexto grafico que puede usarse para dibujar en este componente.
     */
    public void paintComponent(Graphics g)
    {
        Dimension tamano = getSize();
        g.clearRect(0, 0, tamano.width, tamano.height);
        if(panelImagen != null) {
            g.drawImage(panelImagen, 0, 0, null);
        }
    }
}
