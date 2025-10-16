import java.awt.*;
import javax.swing.*;

/**
 * Ilustra el estilo de diseño DisenoGrilla.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class EjemploDisenoGrilla
{
    private JFrame ventana;
    public static void main(String[] args) {
        EjemploDisenoGrilla e = new EjemploDisenoGrilla();
        
    }


    /**
     * Constructor de los objectos de la clase EjemploDisenoCaja
     */
    public EjemploDisenoGrilla()
    {
        construirVentana();
    }

    /**
     * Crea una grilla 3x2 para ubicar dentro cinco elementos.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Ejemplo de Diseño Grilla");
        
        Container panelContenedor = ventana.getContentPane();
        panelContenedor.setLayout(new GridLayout(3, 2));
        panelContenedor.add(new JButton("primero"));
        panelContenedor.add(new JButton("segundo"));
        panelContenedor.add(new JButton("el tercer texto es muy largo"));
        panelContenedor.add(new JButton("cuarto"));
        panelContenedor.add(new JButton("quinto"));
        
        ventana.pack();
        ventana.setVisible(true);
    }
}
