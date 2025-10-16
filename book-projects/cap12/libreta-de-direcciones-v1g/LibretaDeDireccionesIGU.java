import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * Provee una vista IGU a la LibretaDeDirecciones.
 * Los diferentes paneles proveen acceso a los datos de la libreta.
 *
 *      Uno para buscar en la libreta.
 *
 *      Uno para permitir la carga de datos de un contacto.
 *      El boton agregar inserta los datos en la libreta.
 *
 *      Uno para mostrar todas las entradas en la libreta.
 *
 * @author David J. Barnes and Michael Kolling.
 * @author Traduccin: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class LibretaDeDireccionesIGU extends JFrame
{
    // Preferencias de tama�o para esta ventana.
    private static final int ANCHO_PREFERIDO = 500;
    private static final int ALTO_PREFERIDO = 500;
    private static final Dimension TAMANO_PREFERIDO =
                            new Dimension(ANCHO_PREFERIDO,ALTO_PREFERIDO);
    // La libreta de direcciones a mostrar y modificar.
    private LibretaDeDirecciones libreta;
    
    /**
     * Crea la ventana con sus paneles.
     * @param libreta La libreta de direcciones a manipular.
     */
    public LibretaDeDireccionesIGU(LibretaDeDirecciones libreta)
    {
        this.libreta = libreta;
        setTitle("Libreta de Direcciones");
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev)
            {
                setVisible(false);
            }
        });

        final Container panelContenedor = getContentPane();
        JTabbedPane areaTabulada = new JTabbedPane();
        areaTabulada.add("Buscar datos", setupAreaBusqueda());
        areaTabulada.add("Ingresar contacto",  setupEntradaDatos());
        areaTabulada.add("Listar entradas",   setupAreaListar());
        panelContenedor.add(areaTabulada);

        setSize(TAMANO_PREFERIDO);
    }
    
    /**
     * Muestra la ventana si ha sido cerrada.
     */
    public void showVentana()
    {
        setVisible(true);
    }

    /**
     * @return El tama�o preferido para esta ventana.
     */
    public Dimension getPreferredSize()
    {
        return TAMANO_PREFERIDO;
    }

    /**
     * Configura el panel para la carga de datos.
     * @return El panel terminado.
     */
    private Container setupEntradaDatos()
    {
        // Configura el nombre del area del nombre del contacto.
        Box etiquetaDelAreaNombre = Box.createHorizontalBox();
        etiquetaDelAreaNombre.add(new JLabel("Nombre", JLabel.LEFT));
        etiquetaDelAreaNombre.add(Box.createGlue());
        final JTextField nombreDelCampo = new JTextField(50);
        Box areaNombre = Box.createVerticalBox();
        areaNombre.add(etiquetaDelAreaNombre);
        areaNombre.add(nombreDelCampo);

        // Configura el area para el n�mero de t�lefono.
        Box etiquetaDelAreaTelefono = Box.createHorizontalBox();
        etiquetaDelAreaTelefono.add(new JLabel("Telefono", JLabel.LEFT));
        etiquetaDelAreaTelefono.add(Box.createGlue());
        final JTextField campoTelefono = new JTextField(50);
        Box areaTelefono = Box.createVerticalBox();
        areaTelefono.add(etiquetaDelAreaTelefono);
        areaTelefono.add(campoTelefono);
        
        // Configura el �rea para la direcci�n.
        Box etiquetaDelAreaDireccion = Box.createHorizontalBox();
        etiquetaDelAreaDireccion.add(new JLabel("Direccion", JLabel.LEFT));
        etiquetaDelAreaDireccion.add(Box.createGlue());
        Box areaDireccion = Box.createVerticalBox();
        final JTextArea direccion = new JTextArea(10, 50);
        areaDireccion.add(etiquetaDelAreaDireccion);
        areaDireccion.add(direccion);

        // Disposici�n de los campos de entrada de datos en el panel.
        Box camposDeUnaLinea = Box.createVerticalBox();
        camposDeUnaLinea.add(areaNombre);
        camposDeUnaLinea.add(areaTelefono);
        JPanel panelDeDetalles = new JPanel();
        panelDeDetalles.setLayout(new BorderLayout());
        panelDeDetalles.add(camposDeUnaLinea, BorderLayout.NORTH);
        panelDeDetalles.add(areaDireccion, BorderLayout.CENTER);

        // Configura los botones.
        JPanel areaDeBotones = new JPanel();
        JButton agregar = new JButton("Agregar");
        JButton borrar = new JButton("Borrar");

        // Realiza las acciones necesarias para agregar el nuevo contacto.
        agregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                libreta.agregarContacto(
                    new DatosDelContacto(nombreDelCampo.getText(),
                                       campoTelefono.getText(),
                                       direccion.getText()));
            }
        });

        // Borra las areas de entrada de datos.
        borrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                nombreDelCampo.setText("");
                campoTelefono.setText("");
                direccion.setText("");
            }
        });
        areaDeBotones.add(agregar);
        areaDeBotones.add(borrar);

        // Ubica los areas de detalles por encima del area de botones.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panelDeDetalles, BorderLayout.CENTER);
        panel.add(areaDeBotones, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Configura el panel para la busqueda de entradas.
     * @return El panel terminado.
     */
    private Container setupAreaBusqueda()
    {
        // Configura el area para el ingreso del texto a buscar.
        Box etiquetaDelAreaBuscar = Box.createHorizontalBox();
        etiquetaDelAreaBuscar.add(new JLabel("Buscar", JLabel.LEFT));
        etiquetaDelAreaBuscar.add(Box.createGlue());
        final JTextField campoBuscar = new JTextField(50);
        Box areaBuscar = Box.createHorizontalBox();
        areaBuscar.add(etiquetaDelAreaBuscar);
        areaBuscar.add(campoBuscar);
        
        // Configura el area donde se mostraran los resultados.
        final JTextArea listaDeResultados = new JTextArea(10,50);
        listaDeResultados.setEditable(false);
        JScrollPane areaDeslizable =
                new JScrollPane(listaDeResultados,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Cualquier cambio en el campo de nombre produce una nueva
        // busqueda en la libreta de direcciones.
        campoBuscar.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent ev)
            {
                volverABuscar();
            }
            
            public void insertUpdate(DocumentEvent ev)
            {
                volverABuscar();
            }
            
            public void removeUpdate(DocumentEvent ev)
            {
                volverABuscar();
            }
            
            /**
             * Busca en la libreta de direcciones y muestra los resultados
             * a menos que el texto a buscar este vacio, caso en el que
             * se borra el area de resultados.
             */
            private void volverABuscar()
            {
                String textoABuscar = campoBuscar.getText();
                StringBuffer buffer = new StringBuffer();
                if(textoABuscar.length() > 0) {
                    DatosDelContacto[] resultados = libreta.buscar(textoABuscar);
                    for(int i = 0; i < resultados.length; i++) {
                        buffer.append(resultados[i].toString());
                        buffer.append('\n');
                        buffer.append('\n');
                    }
                }
                listaDeResultados.setText(buffer.toString());
            }
        });

        JPanel areaDeLista = new JPanel();
        areaDeLista.setLayout(new BorderLayout());
        areaDeLista.add(areaBuscar, BorderLayout.NORTH);
        areaDeLista.add(areaDeslizable, BorderLayout.CENTER);

        return areaDeLista;
    }

    /**
     * Configura el panel para listar las entradas.
     * @return El panel terminado.
     */
    private Container setupAreaListar()
    {
        // Configura el area donde se mostraran los contactos.
        final JTextArea contactos = new JTextArea(10, 50);
        contactos.setEditable(false);
        JScrollPane areaDeslizable =
                new JScrollPane(contactos,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Configura los botones.
        JPanel areaDeBotones = new JPanel();
        JButton listar = new JButton("Listar");
        JButton borrar = new JButton("Borrar");
        
        // Lista todas las entradas.
        listar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                contactos.setText(libreta.listarContactos());
            }
        });

        // Borra el area de detalles.
        borrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                contactos.setText("");
            }
        });
        areaDeBotones.add(listar);
        areaDeBotones.add(borrar);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(areaDeslizable, BorderLayout.CENTER);
        panel.add(areaDeBotones, BorderLayout.SOUTH);

        return panel;
    }
}
