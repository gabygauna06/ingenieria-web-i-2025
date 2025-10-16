import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * VisorDeImagen es la clase principal del la aplicación de visualización
 * de imágenes. Construye y muestra la IGU de la aplicación.
 * 
 * Para iniciar la aplicación, cree un objeto de esta clase.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 0.2
 */
public class VisorDeImagen
    implements ActionListener
{
    private JFrame ventana;
    
    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public VisorDeImagen()
    {
        construirVentana();
    }

    /**
     * Recibe la notificación de una acción.
     * @param evento Detalles de la acción.
     */
    public void actionPerformed(ActionEvent evento) 
    { 
        System.out.println("Elemento: " + evento.getActionCommand());
    }

    
    // ---- Elementos de swing para construir la ventana y sus componentes ----
    
    /**
     * Crea la ventana Swing y su contenido.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Visor de Imagenes");
        construirBarraDeMenu(ventana);
        
        Container panelContenedor = ventana.getContentPane();
        
        JLabel etiqueta = new JLabel("Soy una etiqueta.");
        panelContenedor.add(etiqueta);

        // Construcción hecha - se acomodan los componentes y se muestran
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }
    
    /**
     * Crea la barra de menú de la ventana.
     * @param ventana  La ventana a la cual se debe agregar la barra de menú.
     */
    private void construirBarraDeMenu(JFrame ventana)
    {
        JMenuBar barraDeMenu = new JMenuBar();
        ventana.setJMenuBar(barraDeMenu);
        
        // crea el menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        barraDeMenu.add(menuArchivo);
        
        JMenuItem elementoAbrir = new JMenuItem("Abrir");
        elementoAbrir.addActionListener(this);
        menuArchivo.add(elementoAbrir);

        JMenuItem elementoSalir = new JMenuItem("Salir");
        elementoSalir.addActionListener(this);
        menuArchivo.add(elementoSalir);
    }
}
