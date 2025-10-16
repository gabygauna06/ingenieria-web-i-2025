/**
 * Ladrillo modela un simple ladrillo
 * 
 * @author: Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Ladrillo
{
    // Constante.
    private static final int PESO_POR_CM3 = 2;  // peso por centimetro cubico en kg

    private int alto;
    private int ancho;
    private int profundo;

    /**
     * Crea un Ladrillo dadas sus dimensiones en centimetros.
     * @param alto altura del ladrillo.
     * @param ancho ancho del ladrillo.
     * @param profundo profundidad del ladrillo.
     */
    public Ladrillo(int alto, int ancho, int profundo)
    {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        nombre = null;
    }

    /**
     * @return la superfice total de este ladrillo en cenimetros cuadrados.
     */
    public double getSuperficieTotal()
    {
        double lado1 = ancho * alto;
        double lado2 = ancho * profundo;
        double lado3 = profundo * alto;
        double total = (lado1 + lado2 + lado3) * 2;

        return total;
    }

    /**
     * @return el peso del ladrillo en kgs
     */
    public double getPeso()
    {
        return (getVolumen() * PESO_POR_CM3) / 1000;
    }

    /**
     * @return el volumen del ladrillo en centimetros cubicos
     */
    public int getVolumen()
    {
        return ancho * alto * profundo;
    }

    /**
     * @return la altura del ladirllo en centimetros
     */
    public double getAlto()
    {
        return alto;
    }
    
}
