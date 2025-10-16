/**
 * Clase Habitacion - Una habitaci�n en un juego de aventuras
 *
 * Esta clase es parte de la apliciaci�n "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Un objeto "Habitacion" representa una ubicaci�n en el juego. Las
 * habitaciones tienen salidas que conducen a otras habitaciones, indicadas
 * como norte, sur, este y oeste. Para cada direcci�n, una habitaci�n 
 * mantiene una referencia a la habitaci�n vecina, o null si no existe una
 * en es direcci�n.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Habitacion 
{
    public String descripcion;
    public Habitacion salidaNorte;
    public Habitacion salidaSur;
    public Habitacion salidaEste;
    public Habitacion salidaOeste;

    /**
     * Crea una habitaci�n descrita por "descripcion". 
     * Inicialmente, la habitaci�on no tiene salidas, "descripcion"
     * es algo asi como "una cocina" o "un patio".
     * 
     * @param descripcion La descripcion de la habitacion.
     */
    public Habitacion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    /**
     * Define las salidas de esta habitaci�n. Cada direcci�n conduce a
     * otra habitaci�n o bien es null (es decir, no hay salida).
     * @param norte La salida norte.
     * @param este La salida este.
     * @param sur La salida sur.
     * @param oeste La salida oeste.
     */
    public void establecerSalida(Habitacion norte, Habitacion este,
    							 Habitacion sur, Habitacion oeste) 
    {
        if(norte != null)
            salidaNorte = norte;
        if(este != null)
            salidaEste = este;
        if(sur != null)
            salidaSur = sur;
        if(oeste != null)
            salidaOeste = oeste;
    }

    /**
     * @return La descripcion de la habitacion.
     */
    public String getDescripcion()
    {
        return descripcion;
    }

}
