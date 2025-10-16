/**
 * Captura una clave que no coincide con una entrada
 * de la libreta de direcciones.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class NoCoincideContactoException extends Exception
{
    // La clave que no tiene coincidencias.
    private String clave;

    /**
     * Almacena los datos erroneos.
     * @param clave La clave que no coincide.
     */
    public NoCoincideContactoException(String clave)
    {
        this.clave = clave;
    }

    /**
     * @return La clave en erronea.
     */
    public String getClave()
    {
        return clave;
    }
    
    /**
     * @return Una cadena de diagnostico que contiene la clave erronea.
     */
    public String toString()
    {
        return "No se encontraron datos que coincidan con: " + clave ;
    }
}
