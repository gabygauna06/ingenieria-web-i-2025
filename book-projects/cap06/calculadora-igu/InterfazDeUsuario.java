import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Una Interfaz gráfica de usuario para la calculadora. No se realizan 
 * cálculos aquí. Esta clase es resonsable solo de poner el visor en 
 * pantalla. Utiliza el "MotoroDeCalculadora" para realizar el trabajo real
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class InterfazDeUsuario
    implements ActionListener
{
    private MotorDeCalculadora calc;
    private boolean mostrandoAutor;

    private JFrame frame;
    private JTextField visor;
    private JLabel status;

    /**
     * Crea una interfaz de usuario
     * @param motor el motor de calculadora.
     */
    public InterfazDeUsuario(MotorDeCalculadora motor)
    {
        calc = motor;
        mostrandoAutor = true;
        hacerCuadro();
        frame.setVisible(true);
    }

    /**
     * Establece la visibilidad de la interfaz
     * @param visible true si la interfaz debe hacerse visible, false en
     *        caso contrario.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    /**
     * Crea el marco para la interfaz de Usuario
     */
    private void hacerCuadro()
    {
        frame = new JFrame(calc.getTitulo());
        
        JPanel contenedor = (JPanel)frame.getContentPane();
        contenedor.setLayout(new BorderLayout(8, 8));
        contenedor.setBorder(new EmptyBorder( 10, 10, 10, 10));

        visor = new JTextField();
        contenedor.add(visor, BorderLayout.NORTH);

        JPanel panelDeBotones = new JPanel(new GridLayout(4, 4));
            agregarBoton(panelDeBotones, "7");
            agregarBoton(panelDeBotones, "8");
            agregarBoton(panelDeBotones, "9");
            agregarBoton(panelDeBotones, "C");
            
            agregarBoton(panelDeBotones, "4");
            agregarBoton(panelDeBotones, "5");
            agregarBoton(panelDeBotones, "6");
            agregarBoton(panelDeBotones, "?");
            
            agregarBoton(panelDeBotones, "1");
            agregarBoton(panelDeBotones, "2");
            agregarBoton(panelDeBotones, "3");
            panelDeBotones.add(new JLabel(" "));
            
            agregarBoton(panelDeBotones, "0");
            agregarBoton(panelDeBotones, "+");
            agregarBoton(panelDeBotones, "-");
            agregarBoton(panelDeBotones, "=");
            
        contenedor.add(panelDeBotones, BorderLayout.CENTER);

        status = new JLabel(calc.getAutor());
        contenedor.add(status, BorderLayout.SOUTH);

        frame.pack();
    }

    /**
     * Agrega un botón al panel de control
     * @param panel El panel que donde se va a agregar el botón
     * @param textoDelBoton El texto del botón
     */
    private void agregarBoton(Container panel, String textoDelBoton)
    {
        JButton boton = new JButton(textoDelBoton);
        boton.addActionListener(this);
        panel.add(boton);
    }

    /**
     * Una acción de la interfaz fue ejecutada.
     * Encontrar que fue y manejarla
     * @param evento El evento que ocurrió.
     */
    public void actionPerformed(ActionEvent evento)
    {
        String command = evento.getActionCommand();

        if(command.equals("0") ||
           command.equals("1") ||
           command.equals("2") ||
           command.equals("3") ||
           command.equals("4") ||
           command.equals("5") ||
           command.equals("6") ||
           command.equals("7") ||
           command.equals("8") ||
           command.equals("9")) {
            int number = Integer.parseInt(command);
            calc.numeroPresionado(number);
        }
        else if(command.equals("+")) {
            calc.mas();
        }
        else if(command.equals("-")) {
            calc.menos();
        }
        else if(command.equals("=")) {
            calc.igual();
        }
        else if(command.equals("C")) {
            calc.limpiar();
        }
        else if(command.equals("?")) {
            mostrarInformacion();
        }
        // else comando desconocido

        actualizarVisor();
    }

    /**
     * Actualizar la interfaz visor para mostrar el valor actual
     * del la calculadora
     */
    private void actualizarVisor()
    {
        visor.setText("" + calc.getValorEnVisor());
    }

    /**
     * Cambiar el area de status del visor de informacion de la 
     * calculadora alternando información del autor y la versión
     */
    private void mostrarInformacion()
    {
        if(mostrandoAutor)
            status.setText(calc.getVersion());
        else
            status.setText(calc.getAutor());

        mostrandoAutor = !mostrandoAutor;
    }
}
