import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * VisorDeImagen es la clase principal del la aplicación de visualización
 * de imágenes. Construye y muestra la IGU de la aplicación.
 * 
 * Para iniciar la aplicación, cree un objeto de esta clase.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 3.1
 */
public class VisorDeImagen
{
    // campos estáticos:
    private static final String VERSION = "Versión 3.1";
    private static JFileChooser selectorArchivo = new JFileChooser(System.getProperty("user.dir"));

    // campos:
    private JFrame ventana;
    private PanelDeImagen panelDeImagen;
    private JLabel etiquetaNombreArchivo;
    private JLabel etiquetaEstado;
    private JButton botonAchicar;
    private JButton botonAgrandar;
    private ImagenOF imagenActual;
    
    private List<Filtro> filtros;

    public static void main(String[] args) {
        VisorDeImagen e = new VisorDeImagen();
        
    }



    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public VisorDeImagen()
    {
        imagenActual = null;
        filtros = crearFiltros();
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
        setBotonesHabilitados(true);
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
        setBotonesHabilitados(false);
    }

    /**
     * Función Guardar como: guarda la imagen actual en un archivo.
     */
    private void guardarComo()
    {
        if(imagenActual != null) {
            int valorRetorno = selectorArchivo.showSaveDialog(ventana);
    
            if(valorRetorno != JFileChooser.APPROVE_OPTION) {
                return;  // cancelado
            }
            File archivoElegido = selectorArchivo.getSelectedFile();
            AdministradorDeArchivos.guardarImagen(imagenActual, archivoElegido);
            
            mostrarNombreArchivo(archivoElegido.getPath());
        }
    }

    /**
     * Función Salir: sale de la aplicación.
     */
    private void salir()
    {
        System.exit(0);
    }

    /**
     * Aplica un filtro dado a la imagen actual.
     * @param filtro El filtro a aplicar.
     */
    private void aplicarFiltro(Filtro filtro)
    {
        if(imagenActual != null) {
            filtro.aplicar(imagenActual);
            ventana.repaint();
            mostrarEstado("Aplicado: " + filtro.getNombre());
        }
        else {
            mostrarEstado("No hay ninguna imagen cargada.");
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

    /**
     * Agranda la imagen actual.
     */
    private void agrandar()
    {
        if(imagenActual != null) {
            // crea una imagen del doble de tamaño
            int ancho = imagenActual.getWidth();
            int alto = imagenActual.getHeight();
            ImagenOF nuevaImagen = new ImagenOF(ancho * 2, alto * 2);

            // copia los datos de pixel en la nueva imagen
            for(int y = 0; y < alto; y++) {
                for(int x = 0; x < ancho; x++) {
                    Color color = imagenActual.getPixel(x, y);
                    nuevaImagen.setPixel(x * 2, y * 2, color);
                    nuevaImagen.setPixel(x * 2 + 1, y * 2, color);
                    nuevaImagen.setPixel(x * 2, y * 2 + 1, color);
                    nuevaImagen.setPixel(x * 2+1, y * 2 + 1, color);
                }
            }
            
            imagenActual = nuevaImagen;
            panelDeImagen.setImagen(imagenActual);
            ventana.pack();
        }
    }
    

    /**
     * Achica la imagen actual.
     */
    private void achicar()
    {
        if(imagenActual != null) {
            // crea una imagen de la mitad del tamaño
            int ancho = imagenActual.getWidth() / 2;
            int alto = imagenActual.getHeight() / 2;
            ImagenOF nuevaImagen = new ImagenOF(ancho, alto);

            // copia los datos de pixel en la nueva imagen
            for(int y = 0; y < alto; y++) {
                for(int x = 0; x < ancho; x++) {
                    nuevaImagen.setPixel(x, y, imagenActual.getPixel(x * 2, y * 2));
                }
            }
            
            imagenActual = nuevaImagen;
            panelDeImagen.setImagen(imagenActual);
            ventana.pack();
        }
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
    
    
    /**
     * Habilita o deshabilita todos los botones de la
     * barra de herramientas
     * 
     * @param estado  'true' para habilitar los botones,
     *                'false' para deshabilitarlos.
     */
    private void setBotonesHabilitados(boolean estado)
    {
        botonAchicar.setEnabled(estado);
        botonAgrandar.setEnabled(estado);
    }
    
    /**
     * Crea y devuelve una lista con todos los filtros conocidos.
     * @return La lista de filtros.
     */
    private List<Filtro> crearFiltros()
    {
        List<Filtro> listaDeFiltros = new ArrayList<Filtro>();
        listaDeFiltros.add(new FiltroOscuro("Oscuro"));
        listaDeFiltros.add(new FiltroClaro("Claro"));
        listaDeFiltros.add(new FiltroUmbral("Umbral"));
        listaDeFiltros.add(new FiltroInvertir("Invertir"));
        listaDeFiltros.add(new FiltroSobreIluminar("Sobreiluminar"));
        listaDeFiltros.add(new FiltroSuavizar("Suavizar"));
        listaDeFiltros.add(new FiltroPixelizar("Pixelizar"));
        listaDeFiltros.add(new FiltroEspejo("Espejo"));
        listaDeFiltros.add(new FiltroEscalaGris("Escala de gris"));
        listaDeFiltros.add(new FiltroBorde("Deteccion de borde"));
        listaDeFiltros.add(new FiltroOjoDePez("Ojo de Pez"));
       
        return listaDeFiltros;
    }
    
    // ---- Elementos de swing para construir la ventana y sus componentes ----
    
    /**
     * Crea la ventana Swing y su contenido.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Visor de Imagenes");
        JPanel panelContenedor = (JPanel)ventana.getContentPane();
        panelContenedor.setBorder(new EmptyBorder(6, 6, 6, 6));

        construirBarraDeMenu(ventana);
        
        // Especifica el gestor de disposición con el espaciado apropiado
        panelContenedor.setLayout(new BorderLayout(6, 6));
        
        // Crea un panel de imagen en el centro
        panelDeImagen = new PanelDeImagen();
        panelDeImagen.setBorder(new EtchedBorder());
        panelContenedor.add(panelDeImagen, BorderLayout.CENTER);

        // Crea dos etiquetas arriba y abajo para el nombre del archivo
        // y el mensaje de estado
        etiquetaNombreArchivo = new JLabel();
        panelContenedor.add(etiquetaNombreArchivo, BorderLayout.NORTH);

        etiquetaEstado = new JLabel(VERSION);
        panelContenedor.add(etiquetaEstado, BorderLayout.SOUTH);
        
        // Crea una barra de herramientas con los botones
        JPanel barraDeHerramientas = new JPanel();
        barraDeHerramientas.setLayout(new GridLayout(0, 1));
        
        botonAchicar = new JButton("Achicar");
        botonAchicar.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { achicar(); }
                           });
        barraDeHerramientas.add(botonAchicar);
        
        botonAgrandar = new JButton("Agrandar");
        botonAgrandar.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { agrandar(); }
                           });
        barraDeHerramientas.add(botonAgrandar);

        // Agrega la barra en un panel con un FlowLayout para espaciar
        JPanel panelFlow = new JPanel();
        panelFlow.add(barraDeHerramientas);
        
        panelContenedor.add(panelFlow, BorderLayout.WEST);
        
        // Construcción hecha - se acomodan los componentes y se muestran
        mostrarNombreArchivo(null);
        setBotonesHabilitados(false);
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
        
        elemento = new JMenuItem("Abrir...");
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

        elemento = new JMenuItem("Guardar como...");
            elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, MASCARA_ATAJO));
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { guardarComo(); }
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
        
        for(final Filtro filtro : filtros) {
            elemento = new JMenuItem(filtro.getNombre());
            elemento.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) { 
                                    aplicarFiltro(filtro);
                                }
                           });
             menu.add(elemento);
         }

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
