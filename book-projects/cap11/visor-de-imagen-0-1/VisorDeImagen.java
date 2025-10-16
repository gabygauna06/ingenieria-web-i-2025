import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * VisorDeImagen es la clase principal del la aplicación de visualización
 * de imágenes. Construye y muestra la IGU de la aplicación e inicializa
 * todos los demás componentes.
 * 
 * Para iniciar la aplicación, cree un objeto de esta clase.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 0.1
 */
public class VisorDeImagen
{
    private JFrame ventana;

    public static void main(String[] args) {
        VisorDeImagen p = new VisorDeImagen();
        
    }

    
    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public VisorDeImagen()
    {
        construirVentana();
    }
    
    // ---- Elementos de swing para construir la ventana y sus componentes ----
    
    /**
     * Crea la ventana Swing y su contenido.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Visor de Imagenes");        
        Container panelContenedor = ventana.getContentPane();
        
        JLabel etiqueta = new JLabel("Soy una etiqueta.");
        panelContenedor.add(etiqueta);

        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }
}
