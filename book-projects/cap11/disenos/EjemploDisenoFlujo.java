import java.awt.*;
import javax.swing.*;

/**
 * Ilustra el estilo de diseño DisenoFlujo.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class EjemploDisenoFlujo
{
    private JFrame ventana;

    public static void main(String[] args) {
        EjemploDisenoFlujo e = new EjemploDisenoFlujo();
        
    }

    /**
     * Constructor de los objectos de la clase EjemploDisenoCaja
     */
    public EjemploDisenoFlujo()
    {
        construirVentana();
    }

    /**
     * Ubica cinco componentes en las regiones disponibles.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Ejemplo de Diseño Flujo");
        
        Container contentPane = ventana.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("primero"));
        contentPane.add(new JButton("segundo"));
        contentPane.add(new JButton("el tercer texto es muy largo"));
        contentPane.add(new JButton("cuarto"));
        contentPane.add(new JButton("quinto"));
        
        ventana.pack();
        ventana.setVisible(true);
    }
}
