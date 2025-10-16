/**
 * La clase DVD representa un objecto DVD. Se almacena informaci�n 
 * sobre el DVD que puede ser consultada. Se asume que s�lo se 
 * registrar�n DVDs de pel�culas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traduccion: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class DVD extends Elemento 
{
    private String director;

    /**
     * Constructor de objectos de la clase DVD
     * @param elTitulo El titulo del DVD.
     * @param elDirector El director del DVD.
     * @param tiempo El tiempo de duracion del DVD.
     */
    public DVD(String elTitulo, String elDirector, int tiempo)
    {
        super(elTitulo, tiempo);
        director = elDirector;
    }

    /**
     * @return El director de este DVD.
     */
    public String getDirector()
    {
        return director;
    }

    /**
     * Pasa a String los detalles de este CD.
     */
    public String toString()
    {
        String linea = "DVD:" + super.toString(); 
        return linea + "    director: " + director;
    }
}
