import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import java.io.File;

/**
 * VisorDeImagen es la clase principal del la aplicación de visualización
 * de imágenes. Construye y muestra la IGU de la aplicación.
 * 
 * Para iniciar la aplicación, cree un objeto de esta clase.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class VisorDeImagen
{
    // campos estáticos:
    private static final String VERSION = "Version 1.0";
    private static JFileChooser selectorArchivo = new JFileChooser(System.getProperty("user.dir"));

    // campos:
    private JFrame ventana;
    private PanelDeImagen panelDeImagen;
    private JLabel etiquetaNombreArchivo;
    private JLabel etiquetaEstado;
    private ImagenOF imagenActual;
    
    public static void main(String[] args) {
        VisorDeImagen p = new VisorDeImagen();
        
    }

    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public VisorDeImagen()
    {
        imagenActual = null;
        construirVentana();
    }


    // ---- implementación de las funciones del menu ----
    
    /**
     * Función Abrir: abre un selector de archivos para elegir un
     * nuevo archivo de imagen.
     */
    private void archivoAbrir()
    {
        int valorRetorno = selectorArchivo.showOpenDialog(ventana);

        if(valorRetorno != JFileChooser.APPROVE_OPTION) {
            return;  // cancelado
        }
        File archivoElegido = selectorArchivo.getSelectedFile();
        imagenActual = AdministradorDeArchivos.cargarImagen(archivoElegido);

        if(imagenActual == null) {   // el archivo de imagen no es un formato válido
            JOptionPane.showMessageDialog(ventana,
                    "El archivo no se reconoce como un formato válido de imagen.",
                    "Error en la Carga de la Imagen",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        panelDeImagen.setImagen(imagenActual);
        mostrarNombreArchivo(archivoElegido.getPath());
        mostrarEstado("Archivo cargado.");
        ventana.pack();
    }
    
    /**
     * Función Cerrar: cierra la imagen actual.
     */
    private void cerrar()
    {
        imagenActual = null;
        panelDeImagen.borrarImagen();
        mostrarNombreArchivo(null);
    }
    
    /**
     * Función Salir: sale de la aplicación.
     */
    private void salir()
    {
        System.exit(0);
    }
    
    
    /**
     * Función 'Oscuro': oscurece la imagen.
     */
    private void aplicarOscuro()
    {
        if(imagenActual != null) {
            imagenActual.oscuro();
            ventana.repaint();
            mostrarEstado("Filtro aplicado: Oscuro");
        }
        else {
            mostrarEstado("No hay una ninguna imagen cargada.");
        }
    }
    
    /**
     * Función 'Claro': aclara la imagen.
     */
    private void aplicarClaro()
    {
        if(imagenActual != null) {
            imagenActual.claro();
            ventana.repaint();
            mostrarEstado("Filtro aplicado: Claro");
        }
        else {
            mostrarEstado("No hay una ninguna imagen cargada.");
        }
    }
    
    /**
     * Funcion 'Umbral': aplica un filtro umbral.
     */
    private void umbral()
    {
        if(imagenActual != null) {
            imagenActual.umbral();
            ventana.repaint();
            mostrarEstado("Filtro aplicado: Umbral");
        }
        else {
            mostrarEstado("No hay una ninguna imagen cargada.");
        }
    }
    
    /**
     * Función "Acerca de": muestra información acerca del VisorDeImagenes
     */
    private void mostrarAcercaDe()
    {
        JOptionPane.showMessageDialog(ventana, 
                    "VisorDeImagenes\n" + VERSION,
                    "Acerca de VisorDeImagenes", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    // ---- métodos de soporte ----

    /**
     * Muestra una nombre de archivo en la etiqueta apropiada.
     * Show the file name of the current image in the fils display label.
     * 'null' se utilizará como parámetero si no se tiene cargada una imagen.
     * 
     * @param nombreArchivo El nombre de archivo a mostrar.
     */
    private void mostrarNombreArchivo(String nombreArchivo)
    {
        if(nombreArchivo == null) {
            etiquetaNombreArchivo.setText("No hay archivo para mostrar.");
        }
        else {
            etiquetaNombreArchivo.setText("Archivo: " + nombreArchivo);
        }
    }
    
    /**
     * Muestra un mensaje de estado en la barra de estado de la ventana.
     * @param texto El mensaje de estado a mostrar.
     */
    private void mostrarEstado(String texto)
    {
        etiquetaEstado.setText(texto);
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
        
        // Especifica el gestor de disposición con el espaciado apropiado
        panelContenedor.setLayout(new BorderLayout(6, 6));
        
        etiquetaNombreArchivo = new JLabel();
        panelContenedor.add(etiquetaNombreArchivo, BorderLayout.NORTH);

        panelDeImagen = new PanelDeImagen();
        panelContenedor.add(panelDeImagen, BorderLayout.CENTER);

        etiquetaEstado = new JLabel(VERSION);
        panelContenedor.add(etiquetaEstado, BorderLayout.SOUTH);
        
        // Construcción hecha - se acomodan los componentes y se muestran
        mostrarNombreArchivo(null);
        ventana.pack();
        
        // centrar la ventana en la pantalla
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation(d.width/2 - ventana.getWidth()/2, d.height/2 - ventana.getHeight()/2);
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
        
        JMenu menu;
        JMenuItem elemento;
        
        // crea el menú Archivo
        menu = new JMenu("Archivo");
        barraDeMenu.add(menu);
        
        elemento = new JMenuItem("Abrir");
            elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, MASCARA_ATAJO));
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { archivoAbrir(); }
                           });
        menu.add(elemento);

        elemento = new JMenuItem("Cerrar");
            elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, MASCARA_ATAJO));
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { cerrar(); }
                           });
        menu.add(elemento);
        menu.addSeparator();
        
        elemento = new JMenuItem("Salir");
            elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, MASCARA_ATAJO));
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { salir(); }
                           });
        menu.add(elemento);


        
        // crea el menu Filtro
        menu = new JMenu("Filtro");
        barraDeMenu.add(menu);
        
        elemento = new JMenuItem("Oscuro");
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { aplicarOscuro(); }
                           });
        menu.add(elemento);

        elemento = new JMenuItem("Claro");
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { aplicarClaro(); }
                           });
        menu.add(elemento);

        elemento = new JMenuItem("Umbral");
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { umbral(); }
                           });
        menu.add(elemento);

        // crea el menú Ayuda
        menu = new JMenu("Ayuda");
        barraDeMenu.add(menu);
        
        elemento = new JMenuItem("Acerca de Visor de Imágenes...");
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { mostrarAcercaDe(); }
                           });
        menu.add(elemento);

    }
}
