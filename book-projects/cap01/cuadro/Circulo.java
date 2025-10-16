import java.awt.*;
import java.awt.geom.*;

/**
 * Un círculo que puede ser manipulado y que se dibuja a si mismo en un canvas. 
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * Traducción Carlos A. Bartó
 */

public class Circulo
{
    private int diametro;
    private int xPosicion;
    private int yPosicion;
    private String color;
    private boolean esVisible;
    
    /**
     * Crear un nuevo círculo en la posición y el color por defecto. 
     */
    public Circulo()
    {
        diametro = 30;
        xPosicion = 20;
        yPosicion = 60;
        color = "blue";
        esVisible = false;
    }

    /**
     * Hacer visible a este círculo. Si ya estaba visible no hace nada.
     */
    public void hacerVisible()
    {
        esVisible = true;
        dibujar();
    }
    
    /**
     * Hacer invisible a este círculo. Si ya estaba invisible no hace nada.
     */
    public void hacerInvisible()
    {
        borrar();
        esVisible = false;
    }
    
    /**
     * Mover el círculo unos pocos pixeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mover el círculo unos pocos pixeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mover el círculo unos pocos pixeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mover el círculo unos pocos pixeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mover el círculo horizontalmente una 'distancia' en pixeles.
     */
    public void moverHorizontal(int distancia)
    {
        borrar();
        xPosicion += distancia;
        dibujar();
    }

    /**
     * Mover el círculo verticalmente una 'distancia' en pixeles.
     */
    public void moverVertical(int distancia)
    {
        borrar();
        yPosicion += distancia;
        dibujar();
    }

    /**
     * Mover lenta y horizontalmente el círculo una 'distancia' en pixeles.
     */
    public void moverLentoHorizontal(int distancia)
    {
        int delta;

        if(distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distancia; i++)
        {
            xPosicion += delta;
            dibujar();
        }
    }

    /**
     * Mover lenta y verticalmente el círculo una 'distancia' en pixeles..
     */
    public void moverLentoVertical(int distancia)
    {
        int delta;

        if(distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distancia; i++)
        {
            yPosicion += delta;
            dibujar();
        }
    }

    /**
     * Cambiar el tamaño a uno nuevo (en pixeles). El tamaño debe ser >= 0.
     */
    public void cambiarTamano(int nuevoDiametro)
    {
        borrar();
        diametro = nuevoDiametro;
        dibujar();
    }

    /**
     * Cambiar el color. Colores válidos son: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void cambiarColor(String nuevoColor)
    {
        color = nuevoColor;
        dibujar();
    }

    /**
     * Dibujar el círculo en la pantalla con las actuales especificacione
     */
    private void dibujar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.dibujar(this, color, new Ellipse2D.Double(xPosicion, yPosicion, 
                                                          diametro, diametro));
            canvas.esperar(10);
        }
    }

    /**
     * Borrar el círculo en la pantalla.
     */
    private void borrar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.borrar(this);
        }
    }
}
