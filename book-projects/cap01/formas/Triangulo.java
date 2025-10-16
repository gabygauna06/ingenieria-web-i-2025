import java.awt.*;

/**
 * Un Tri�ngulo que puede ser manipulado y que se dibuja a si mismo en un canvas.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * Traducci�n Carlos A. Bart�
 */

public class Triangulo
{
    private int altura;
    private int ancho;
    private int xPosicion;
    private int yPosicion;
    private String color;
    private boolean esVisible;

    /**
     * Crear un nuevo tri�ngulo con la posici�n y el color por defecto. 
     */
    public Triangulo(int base, int alto, String c)
    {
        altura    = alto;
        ancho     = base;
        xPosicion = 50;
        yPosicion = 15;
        color     = c;
        esVisible = false;
    }

    public Triangulo()
    {
        altura    = 30;
        ancho     = 40;
        xPosicion = 50;
        yPosicion = 15;
        color     = "green";
        esVisible = false;
    }

    /**
     * Hacer visible �ste tri�ngulo. Si ya estaba visible, no hacer nada.
     */
    public void hacerVisible()
    {
        esVisible = true;
        dibujar();
    }
    
    /**
     * Hacer invisible �ste tri�ngulo. Si ya estaba invisible, no hacer nada.
     */
    public void hacerInvisible()
    {
        borrar();
        esVisible = false;
    }
    
    /**
     * Mover el tri�ngulo unos pocos pixeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mover el tri�ngulo unos pocos pixeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mover el tri�ngulo unos pocos pixeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mover el tri�ngulo unos pocos pixeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mover el tri�ngulo horizontalmente una 'distancia' en pixeles.
     */
    public void moverHorizontal(int distancia)
    {
        borrar();
        xPosicion += distancia;
        dibujar();
    }

    /**
     * Mover el tri�ngulo verticalmente una 'distancia' en pixeles.
     */
    public void moverVertical(int distancia)
    {
        borrar();
        yPosicion += distancia;
        dibujar();
    }

    /**
     * Mover lenta y horizontalmente el tri�ngulo por una 'distancia' en pixeles.
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
     * Mover lenta y verticalmente el tri�ngulo por una 'distancia' en pixeles.
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
     * Cambiar el tama�o a un nuevo tama�o (en pixeles). El tama�o debe ser >= 0.
     */
    public void cambiarTamano(int nuevaAltura, int nuevoAncho)
    {
        borrar();
        altura = nuevaAltura;
        ancho  = nuevoAncho;
        dibujar();
    }

    /**
     * Cambiar el color. Colors validos son: "red", "yellow", "blue", "green",
     * "magenta" y "black".
     */
    public void cambiarColor(String nuevoColor)
    {
        color = nuevoColor;
        dibujar();
    }

    /**
     * Dibujar el tri�ngulo en la pantalla con las actuales especificaciones.
     */
    private void dibujar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosicion, xPosicion + (ancho/2), xPosicion - (ancho/2) };
            int[] ypoints = { yPosicion, yPosicion + altura, yPosicion + altura };
            canvas.dibujar(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.esperar(10);
        }
    }

    public String getColor () {
        return color;
    }
    
    /**
     * Erase the triangle on screen.
     */
    private void borrar()
    {
        if(esVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.borrar(this);
        }
    }
}

