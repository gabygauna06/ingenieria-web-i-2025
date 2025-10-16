import java.awt.*;
import javax.swing.*;

/**
 * Ilustra el estilo de diseño DisenoCaja.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class EjemploDisenoCaja
{
    private JFrame ventana;

    public static void main(String[] args) {
        EjemploDisenoCaja e = new EjemploDisenoCaja();
        
    }

   /**
     * Constructor de los objectos de la clase EjemploDisenoCaja
     */
    public EjemploDisenoCaja()
    {
        construirVentana();
    }

    /**
     * Ubica cinco componentes en las regiones disponibles.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Ejemplo de Diseño Caja");
        
        Container panelContenedor = ventana.getContentPane();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(new JButton("primero"));
        panelContenedor.add(new JButton("segundo"));
        panelContenedor.add(new JButton("el tercer texto es muy largo"));
        panelContenedor.add(new JButton("cuarto"));
        panelContenedor.add(new JButton("quinto"));
        
        ventana.pack();
        ventana.setVisible(true);
    }
}
