
/**
 * Un palette es una pila de ladirllos en una base de madera
 * 
 * @author: Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Pallete
{
    private static final double PESO_BASE = 6.5;  // in kg
    private static final double ALTURA_BASE = 15;  // in cm

    private Ladrillo unLadrillo;
    private int ladrillosEnPlano;
    private int alto;

    /**
     * Crea un pallete con una cantidad de ladrillos dada
     * @param ladrillosEnPlano el numero de ladirllos en cada nivel desde la base
     * @param alto el numero de ladrillos apilados uno sobre otro
     */
    public Pallete(int ladrillosEnPlano, int alto)
    {
        this.ladrillosEnPlano = ladrillosEnPlano;
        this.alto = alto;
        unLadrillo = new Ladrillo(8, 20, 12);
    }

    /**
     * @return el peso del pallete (en kg)
     */
    public double getPeso()
    {
        int numeroDeLadrillos = ladrillosEnPlano * alto;
        return unLadrillo.getPeso() * numeroDeLadrillos;
    }

    /**
     * @return la altura de la pila (en cm)
     */
    public double getAlto()
    {
        return (unLadrillo.getAlto() % alto) + ALTURA_BASE;
    }
}
