import java.awt.*;

/**
 * Un Cuadrado que puede ser manipulado y que se dibuja a si mismo en un canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * Traducción Carlos A. Bartó
 */

public class Cuadrado
{
    private int tamano;
    private int xPosicion;
    private int yPosicion;
    private String color;
    private boolean esVisible;

    /**
     * Crear un nuevo cuadrado con la posición y el color por defecto 
     */
    public Cuadrado()
    {
        tamano = 30;
        xPosicion = 60;
        yPosicion = 50;
        color = "red";
        esVisible = false;
    }

    /**
     * Hacer visible éste cuadrado. Si ya estaba visible, no hacer nada.
     */
    public void hacerVisible()
    {
        esVisible = true;
        dibujar();
    }
    
    /**
     * Hacer invisible éste cuadrado. Si ya estaba invisible, no hacer nada.
     */
    public void hacerInvisible()
    {
        borrar();
        esVisible = false;
    }
    
    /**
     * Mover el cuadrado unos pocos pixeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mover el cuadrado unos pocos pixeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mover el cuadrado unos pocos pixeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mover el cuadrado unos pocos pixeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mover el cuadrado horizontalmente por una 'distancia' en pixeles.
     */
    public void moverHorizontal(int distancia)
    {
        borrar();
        xPosicion += distancia;
        dibujar();
    }

    /**
     * Mover el cuadrado verticalmente por una 'distancia' en pixeles.
     */
    public void moverVertical(int distancia)
    {
        borrar();
        yPosicion += distancia;
        dibujar();
    }

    /**
     * Mover lenta y horizontalmente el cuadrado por una 'distancia' en pixeles.
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
     * Mover lenta y verticalmente el cuadrado por una 'distancia' en pixeles.
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
     * Cambiar el tamaño a un nuevo tamaño (en pixeles). Tamaño debe ser >= 0.
     */
    public void cambiarTamano(int nuevoTamano)
    {
        borrar();
        tamano = nuevoTamano;
        dibujar();
    }

    /**
     * Cambiar el color. Colores Válidos son: "red", "yellow", "blue", "green",
     * "magenta" y "black".
     */
    public void cambiarColor(String nuevoColor)
    {
        color = nuevoColor;
        dibujar();
    }

    /**
     * Dibujar el Cuadrado en la pantalla con las actuales especificaciones.
     */
    private void dibujar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.dibujar(this, color,
                        new Rectangle(xPosicion, yPosicion, tamano, tamano));
            canvas.esperar(10);
        }
    }

    /**
     * Borrar el Cuadrado en la pantalla.
     */
    private void borrar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.borrar(this);
        }
    }
}
