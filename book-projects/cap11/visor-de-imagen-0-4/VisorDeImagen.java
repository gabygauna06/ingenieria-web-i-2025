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
 * @version 0.4
 */
public class VisorDeImagen
{
    private JFrame ventana;
    private PanelDeImagen panelDeImagen;
    
    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public VisorDeImagen()
    {
        construirVentana();
    }


    // ---- implementación de las funciones del menu ----
    
    /**
     * Función Abrir: abre un selector de archivos para elegir un
     * nuevo archivo de imagen.
     */
    private void archivoAbrir()
    {
        ImagenOF imagen = AdministradorDeArchivos.getImagen();
        panelDeImagen.setImagen(imagen);
        ventana.pack();
    }
    
    /**
     * Función Salir: sale de la aplicación.
     */
    private void salir()
    {
        System.exit(0);
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
        
        panelDeImagen = new PanelDeImagen();
        panelContenedor.add(panelDeImagen);

        // Construcción hecha - se acomodan los componentes y se muestran
        ventana.pack();
        ventana.setVisible(true);
    }
    
    /**
     * Crea la barra de menú de la ventana.
     * @param ventana  La ventana a la cual se debe agregar la barra de menú.
     */
    private void construirBarraDeMenu(JFrame ventana)
    {
        final int MASCARA_ATAJO =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar barraDeMenu = new JMenuBar();
        ventana.setJMenuBar(barraDeMenu);
        
        // crea el menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        barraDeMenu.add(menuArchivo);
        
        JMenuItem elementoAbrir = new JMenuItem("Abrir");
            elementoAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, MASCARA_ATAJO));
            elementoAbrir.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { archivoAbrir(); }
                           });
        menuArchivo.add(elementoAbrir);

        JMenuItem elementoSalir = new JMenuItem("Salir");
            elementoSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, MASCARA_ATAJO));
            elementoSalir.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { salir(); }
                           });
        menuArchivo.add(elementoSalir);

    }
}
