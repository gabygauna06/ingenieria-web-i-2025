import java.awt.*;
import javax.swing.*;

/**
 * Ilustra el estilo de diseño con DisenoBorde
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class EjemploDisenoBorde
{
    private JFrame ventana;

    public static void main(String[] args) {
        EjemploDisenoBorde e = new EjemploDisenoBorde();
        e.construirVentana();
        
    }


    /**
     * Constructor de los objectos de la clase EjemploDisenoBorde
     */
    public EjemploDisenoBorde()
    {
        construirVentana();
    }

    /**
     * Ubica cinco componentes en las regiones disponibles.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Ejemplo de Diseño Borde");
        
        Container panelContenedor = ventana.getContentPane();
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(new JButton("norte"), BorderLayout.NORTH);
        panelContenedor.add(new JButton("sur"), BorderLayout.SOUTH);
        panelContenedor.add(new JButton("centro"), BorderLayout.CENTER);
        panelContenedor.add(new JButton("oeste"), BorderLayout.WEST);
        panelContenedor.add(new JButton("este"), BorderLayout.EAST);
        
        ventana.pack();
        ventana.setVisible(true);
    }
}
