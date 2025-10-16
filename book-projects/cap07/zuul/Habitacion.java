import java.util.Set;
import java.util.HashMap;

/**
 * Clase Habitacion - Una habitacion en un juego de aventuras
 *
 * Esta clase es parte de la apliciacion "World of Zuul". 
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
    private String descripcion;
    private HashMap<String, Habitacion> salidas;        // almacena las salidas de esta habitaci�n

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
        salidas = new HashMap<String, Habitacion>();
    }

    /**
     * Define las salidas de esta habitaci�n.
     * @param direccion La direccion de la salida
     * @param vecina  La habitacion a la cual esta salida conduce.
     */
    public void establecerSalida(String direccion, Habitacion vecina) 
    {
        salidas.put(direccion, vecina);
    }

    /**
     * @return La descripcion corta de esta habitaci�n
     * (la que se defini� en el constructor).
     */
    public String getDescripcionCorta()
    {
        return descripcion;
    }

    /**
     * Devuelve una descripcion de la habitacion en la forma:
     *     Usted esta en la cocina
     *     Salidas: norte oeste
     * @return Una descripcion larga de esta habitaci�n
     */
    public String getDescripcionLarga()
    {
        return "Usted est� en  " + descripcion + ".\n" + getStringDeSalidas();
    }

    /**
     * Devuelve una cadena describiendo las salidas de la habitaci�n, por ejemplo
     * "
     * Return a string describing the room's salidas, for example
     * "Salidas: norte oeste".
     * @return Detalles de las salidas de la habitaci�n
     */
    private String getStringDeSalidas()
    {
        String cadena = "Salidas:";
        Set<String> claves = salidas.keySet();
        for(String salida : claves) {
            cadena += " " + salida;
        }
        return cadena;
    }

    /**
     * Devuelve la habitaci�n a la que se llega si vamos desde esta habitaci�n
     * en la direcci�n "direccion". Si no hay habitaciones en esa direcci�n,
     * devuelve null.
     * @param direccion La direcci�n de salida
     * @return La habitaci�n en la direcci�n se�alada
     */
    public Habitacion getSalida(String direccion) 
    {
        return salidas.get(direccion);
    }
}

