/**
 * Almacena los detalles de los socioss de un club.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Socio
{
    // El nombre del socio.
    private String nombre;
    // El mes en el cual se asoció.
    private int mes;
    // El año en el cual se asoció.
    private int anio;

    /**
     * Constructor de objetos de la clases Socio.
     * @param nombre El nombre del socio.
     * @param mes El mes en el cual ellos se asociaron. (1 ... 12)
     * @param anio El año en el cual ellos se asociaron.
     */
    public Socio(String nombre, int mes, int anio)
        throws IllegalArgumentException
    {
        if(mes < 1 || mes > 12) {
            throw new IllegalArgumentException(
                "Mes " + mes + " fuera de rango. Debe estar en el rango 1 ... 12");
        }
        this.nombre = nombre;
        this.mes    = mes;
        this.anio   = anio;
    }
    
    /**
     * @return El nombre del socio.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @return El mes en el cual el miembro se asoció.
     *         Un valor en el rango 1 ... 12
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * @return El año en el cual el miembro se asoció.
     */
    public int getAnio()
    {
        return anio;
    }

    /**
     * @return Una cadena que representa este socio.
     */
    public String toString()
    {
        return "Nombre: " + nombre +
               " asociado en el mes " +
               mes + " del " + anio;
    }
}
