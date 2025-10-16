import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Lienzo es una clase para permitir el dibujo de gráficos simples sobre un canvas.
 * Esta es una modificación de la clase Canvas de propósitos generales, desarrollada
 * especialmente para el ejemplo de "formas" en BlueJ.
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 *
 * @version 2006.03.30
 * Traducción Carlos A. Bartó
 */
public class Canvas
{
    // Nota: La implementación de esta clase (específicamente el manejo de la
    // identidad y los colores de la forma) es levemente más compleja que lo 
    // necesario. Esto se ha hecho con el propósito de mantener limpias y simples
    // la interface y los campos de las instancias de los objetos forma en este
    // proyecto educativo.

    private static Canvas canvasSingleton;

    /**
     * Método Factory para obtener el objeto singleton canvas.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("Demo de Formas BlueJ", 300, 300, 
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- instance part -----

    private JFrame marco;
    private CristalCanvas canvas;
    private Graphics2D grafico;
    private Color colorFondo;
    private Image imagenCanvas;
    private List<Object> objetos;
    private HashMap<Object, DescripcionForma> formas;
    
    /**
     * Crear un Canvas.
     * @param titulo   el titulo a aparecer en el marco del canvas
     * @param ancho    el ancho deseado para el canvas
     * @param altura   la altura deseada para el canvas
     * @param colorFdo el color deseado del fondo del canvas
     */
    private Canvas(String titulo, int ancho, int altura, Color colorFdo)
    {
        marco  = new JFrame();
        canvas = new CristalCanvas();
        marco.setContentPane(canvas);
        marco.setTitle(titulo);
        canvas.setPreferredSize(new Dimension(ancho, altura));
        colorFondo = colorFdo;
        marco.pack();
        objetos = new ArrayList<Object>();
        formas  = new HashMap<Object, DescripcionForma>();
    }

    /**
     * Establecer la visibilidad del canvas y traer el canvas al frente de
     * la pantalla cuando se haga visible. Este método también puede ser usado
     * para traer un canvas preexistente al frente de otras ventanas.
     * El valor del @param visible boolean representa la visibilidad deseada del
     * canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(grafico == null) {
            // primera vez: instancia la imagen de alcance de pantalla y la
            // rellena con el color de fondo.
            Dimension tamano = canvas.getSize();
            imagenCanvas = canvas.createImage(tamano.width, tamano.height);
            grafico = (Graphics2D)imagenCanvas.getGraphics();
            grafico.setColor(colorFondo);
            grafico.fillRect(0, 0, tamano.width, tamano.height);
            grafico.setColor(Color.black);
        }
        marco.setVisible(visible);
    }

    /**
     * Dibujar una forma dada sobre el canvas.
     * @param  referenciaObjeto  un objeto para definir la identidad para esta forma
     * @param  color             el color de la forma
     * @param  forma             el objet forma a ser dibujado en el canvas
     */
     // Nota: esta es una manera levemente retro de mantener los objetos forma.
     // Esta cuidadosamente deiseñada para mantener visibles las interfaces
     // Note: this is a slightly backwards way of maintaining the forma en este
     // proyecto limpio y simple de propósito educativo.
    public void dibujar(Object referenciaObjeto, String color, Shape forma)
    {
        objetos.remove(referenciaObjeto);   // solo en caso que ya estuviera allí
        objetos.add(referenciaObjeto);      // agregar al final
        formas.put(referenciaObjeto, new DescripcionForma(forma, color));
        redibujar();
    }
 
    /**
     * Borrar de la pantalla una forma dada.
     * @param  referenciaObjeto  el objeto forma object a ser borrado
     */
    public void borrar(Object referenciaObjeto)
    {
        objetos.remove(referenciaObjeto);   // solo en caso de que ya estuviera allí
        formas.remove(referenciaObjeto);
        redibujar();
    }

    /**
     * Establecer el color de fondo del canvas.
     * @param  nuevoColor  el color nuevo para el fondo del canvas. 
     */
    public void setForegroundColor(String cadenaColor)
    {
        if(cadenaColor.equals("red")) {
            grafico.setColor(Color.red);
        }
        else if(cadenaColor.equals("black")) {
            grafico.setColor(Color.black);
        }
        else if(cadenaColor.equals("blue")) {
            grafico.setColor(Color.blue);
        }
        else if(cadenaColor.equals("yellow")) {
            grafico.setColor(Color.yellow);
        }
        else if(cadenaColor.equals("green")) {
            grafico.setColor(Color.green);
        }
        else if(cadenaColor.equals("magenta")) {
            grafico.setColor(Color.magenta);
        }
        else if(cadenaColor.equals("white")) {
            grafico.setColor(Color.white);
        }
        else {
            grafico.setColor(Color.black);
        }
    }

    /**
     * Esperar un número específico de milisegundos antes de terminar.
     * Esto provee una forma fácil de especificar una pequeña demora que
     * puede usarse cuando se producen animaciones.
     * @param  milisegundos  tel numero de milisegundos 
     */
    public void esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (Exception e)
        {
            // ignorar la excepcion por el momento
        }
    }

    /**
     * Redibujar todas las formas actualmente sobre el canvas.
     */
    private void redibujar()
    {
        borrar();
        for(Object forma : objetos) {
            formas.get(forma).dibujar(grafico);
        }
        canvas.repaint();
    }
       
    /**
     * Borrar el canvas completo (No repinta).
     */
    private void borrar()
    {
        Color original = grafico.getColor();
        grafico.setColor(colorFondo);
        Dimension tamano = canvas.getSize();
        grafico.fill(new Rectangle(0, 0, tamano.width, tamano.height));
        grafico.setColor(original);
    }


    /************************************************************************
     * Clase interior CristalCanvas - el componente actual contenido en el
     * marco del canvas. Este es esencialmente un JPanel con la capacidad 
     * añadida de refrescar la imagen dibujada sobre el.
     */
    private class CristalCanvas extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(imagenCanvas, 0, 0, null);
        }
    }
    
  
     /************************************************************************
     * Clase interior DescripcionForma 
     */
    private class DescripcionForma
    {
        private Shape  forma;
        private String cadenaColor;

        public DescripcionForma(Shape forma, String color)
        {
            this.forma  = forma;
            cadenaColor = color;
        }

        public void dibujar(Graphics2D grafico)
        {
            setForegroundColor(cadenaColor);
            grafico.fill(forma);
        }
    }

}
