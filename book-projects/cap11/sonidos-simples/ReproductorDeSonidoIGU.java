import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.*;

/**
 * Un reproductor simple de sonidos. Para comenzar, cree una instancia
 * de esta clase.
 * 
 * Este reproductor puede reproducir archivos WAV, AIFF y AU con muestreo
 * estándar de 22.050 kHz o 11.025 kHz.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class ReproductorDeSonidoIGU extends JFrame
    implements ChangeListener, ActionListener
{
    private static final String VERSION = "Versión 1.0";
    private static final String DIR_AUDIO = "audio";
    
    private JList listaDeArchivos;
    private JSlider deslizador;
    private JLabel etiquetaInformacion;
    private MotorDeSonido reproductor;

    /**
     * Metodo principal para iniciar el reproductor desde la linea de comandos.
     */
    public static void main(String[] args)
    {
        ReproductorDeSonidoIGU igu = new ReproductorDeSonidoIGU();
    }
    
    /**
     * Crea un ReproductorDeSonido y muestra su IGU en la pantalla.
     */
    public ReproductorDeSonidoIGU()
    {
        super("Reproductor de sonido");
        reproductor = new MotorDeSonido();
        String[] nombreArchivosAudio = encontrarArchivos(DIR_AUDIO, null);
        construirVentana(nombreArchivosAudio);
    }

    /**
     * Reproduce el archivo de sonido seleccionado de la lista de archivos.
     * Si no hay una seleccion en la lista o si el archivo elegido no es de
     * sonido, no se hace nada.
     */
    private void reproducir()
    {
        String nombreArchivo = (String)listaDeArchivos.getSelectedValue();
        if(nombreArchivo == null) {  // sin elegir archivo
            return;
        }
        deslizador.setValue(0);
        boolean exito = reproductor.reproducir(new File(DIR_AUDIO, nombreArchivo));
        if(exito) {
            mostrarInformacion(nombreArchivo + " (" + reproductor.getDuracion() + " segs.)");
        }
        else {
            mostrarInformacion("No se puede reproducir el archivo - formato desconocido");
        }
    }

    /**
     * Muestra informacion acerca del archivo de sonido seleccionado (nombre
     * y duracion).
     * @param mensaje El mensaje a mostrar.
     */
    private void mostrarInformacion(String mensaje)
    {
        etiquetaInformacion.setText(mensaje);
    }
    
    /**
     * Detiene la reproduccion del archivo de sonido (si se esta reproduciendo
     * algun archivo).
     */
    private void detener()
    {
        reproductor.detener();
    }

    /**
     * Detiene la reproduccion del archivo de sonido (si se esta reproduciendo
     * algun archivo).
     */
    private void pausar()
    {
        reproductor.pausar();
    }

    /**
     * Continua la reproduccion suspendida del archivo de sonido.
     */
    private void continuar()
    {
        reproductor.continuar();
    }

    /**
     * Funcion Salir: sale de la aplicacion.
     */
    private void salir()
    {
        System.exit(0);
    }
    
    
    /**
     * Funcion Acerca de: muestra la caja "Acerca de..."
     */
    private void mostrarAcercaDe()
    {
        JOptionPane.showMessageDialog(this, 
                    "Reproductor de sonido\n" + VERSION,
                    "Acerca del Reproductor de sonido", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Carga los nombre de archivo de todos los archivos en el directorio dado.
     * @param nombreDir Nombre del directorio (carpeta).
     * @param sufijo Sufijo del archivo de interes.
     * @return Los nombres de los archivos de sonido.
     */
    private String[] encontrarArchivos(String nombreDir, String sufijo)
    {
        File dir = new File(nombreDir);
        if(dir.isDirectory()) {
            String[] todosLosArchivos = dir.list();
            if(sufijo == null) {
                return todosLosArchivos;
            }
            else {
                List<String> elegido = new ArrayList<String>();
                for(String nombreArchivo : todosLosArchivos) {
                    if(nombreArchivo.endsWith(sufijo)) {
                        elegido.add(nombreArchivo);
                    }
                }
                return elegido.toArray(new String[elegido.size()]);
            }
        }
        else {
            System.out.println("Error: " + nombreDir + " debe ser un directorio");
            return null;
        }
    }

    // ------- Interfaz de ChangeListener (para Slider) -------

    /**
     * Metodo ChangeListener para que cambie el deslizador. Este metodo se
     * llama cuando el valor del deslizador es cambiado por el usuario.
     * @param evt Detalles acerca del evento.
     */
    public void stateChanged(ChangeEvent evt)
    {
        reproductor.posicionar(deslizador.getValue());
    }
    
    // ------- Interfaz de ActionListener (para ComboBox) -------

    /**
     * Metodo ActionListener para los cambios de formato del combo box.
     * Cuando se llama este metodos, el usuario ha hecho una nueva seleccion
     * en el combo box.
     * @param evt Detalles acerca del evento.
     */
    public void actionPerformed(ActionEvent evt) 
    {
        JComboBox cb = (JComboBox)evt.getSource();
        String formato = (String)cb.getSelectedItem();
        if(formato.equals("todos los formatos")) {
            formato = null;
        }
        listaDeArchivos.setListData(encontrarArchivos(DIR_AUDIO, formato));
    }

    // ---- Elementos de swing para construir la ventana y sus componentes ----
    
    /**
     * Crea la IGU completa de la aplicación.
     * @param archivosDeAudio Los nombres de archivo a mostrar.
     */
    private void construirVentana(String[] archivosDeAudio)
    {
        // Lo siguiente asegura que nuestra aplicación termina cuando
        // el usuario cierra la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panelContenedor = (JPanel)getContentPane();
        panelContenedor.setBorder(new EmptyBorder(6, 10, 10, 10));

        construirBarraDeMenu();
        
        // Especifica el gestor de disposición con el espaciado apropiado
        panelContenedor.setLayout(new BorderLayout(8, 8));

        // Crea el lado izquierdo con la combobox y la lista navegable
        JPanel panelIzquierdo = new JPanel();
        {
            panelIzquierdo.setLayout(new BorderLayout(8, 8));

            String[] formatos = { "todos los formatos", ".wav", ".au", ".aif" };
    
            // Crea la combo box.
            JComboBox listaDeFormatos = new JComboBox(formatos);
            listaDeFormatos.addActionListener(this);
            panelIzquierdo.add(listaDeFormatos, BorderLayout.NORTH);
    
            // Crea la lista deslizable para los nombres de archivos
            listaDeArchivos = new JList(archivosDeAudio);
            listaDeArchivos.setForeground(new Color(140,171,226));
            listaDeArchivos.setBackground(new Color(0,0,0));
            listaDeArchivos.setSelectionBackground(new Color(87,49,134));
            listaDeArchivos.setSelectionForeground(new Color(140,171,226));
            JScrollPane panelNavegable = new JScrollPane(listaDeArchivos);
            panelNavegable.setColumnHeaderView(new JLabel("Archivos de Audio"));
            panelIzquierdo.add(panelNavegable, BorderLayout.CENTER);
        }
        panelContenedor.add(panelIzquierdo, BorderLayout.CENTER);

        // Crea el centro con una imagen, etiqueta de texto y un deslizador
       JPanel panelCentral = new JPanel();
        {
            panelCentral.setLayout(new BorderLayout(8, 8));
    
            JLabel image = new JLabel(new ImageIcon("title.jpg"));
            panelCentral.add(image, BorderLayout.NORTH);
            panelCentral.setBackground(Color.BLACK);

            etiquetaInformacion = new JLabel("  ");
            etiquetaInformacion.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetaInformacion.setForeground(new Color(140,171,226));
            panelCentral.add(etiquetaInformacion, BorderLayout.CENTER);

            deslizador = new JSlider(0, 100, 0);
            TitledBorder borde = new TitledBorder("Buscar");
            borde.setTitleColor(Color.white);
            deslizador.setBorder(new CompoundBorder(new EmptyBorder(6, 10, 10, 10), borde));
            deslizador.addChangeListener(this);
            deslizador.setBackground(Color.BLACK);
            deslizador.setMajorTickSpacing(25);
            deslizador.setPaintTicks(true);
            panelCentral.add(deslizador, BorderLayout.SOUTH);
        }
        panelContenedor.add(panelCentral, BorderLayout.EAST);

        // Crea la barra de herramientas con los botones
        JPanel barraHerramientas = new JPanel();
        {
            barraHerramientas.setLayout(new GridLayout(1, 0));
  
            JButton boton = new JButton("Reproducir");
            boton.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { reproducir(); }
                               });
            barraHerramientas.add(boton);
            
            boton = new JButton("Detener");
            boton.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { detener(); }
                               });
            barraHerramientas.add(boton);
    
            boton = new JButton("Pausar");
            boton.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { pausar(); }
                               });
            barraHerramientas.add(boton);
            
            boton = new JButton("Continuar");
            boton.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { continuar(); }
                               });
            barraHerramientas.add(boton);
        }
        
        panelContenedor.add(barraHerramientas, BorderLayout.NORTH);

        // Construcción hecha - se acomodan los componentes y se muestran
        pack();
        
        // centrar la ventana en la pantalla
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        setVisible(true);
    }
    
    /**
     * Crea la barra de menú de la ventana.
     */
    private void construirBarraDeMenu()
    {
        final int MASCARA_ATAJO =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar barraDeMenu = new JMenuBar();
        setJMenuBar(barraDeMenu);
        
        JMenu menu;
        JMenuItem elemento;
        
        // crea el menu Archivo
        menu = new JMenu("Archivo");
        barraDeMenu.add(menu);
        
        elemento = new JMenuItem("Salir");
            elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, MASCARA_ATAJO));
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { salir(); }
                           });
        menu.add(elemento);

        // crea el menu Ayuda
        menu = new JMenu("Ayuda");
        barraDeMenu.add(menu);
        
        elemento = new JMenuItem("Acerca de Reproductor de Sonido...");
            elemento.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { mostrarAcercaDe(); }
                           });
        menu.add(elemento);
    }
}
