/**
 * La clase DVD representa un objecto DVD. Se almacena información 
 * sobre el DVD que puede ser consultada. Se asume que sólo se 
 * registrarán DVDs de películas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
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
     * Imprime en la terminal de texto los detalles de este DVD.
     */
    public void imprimir()
    {
        System.out.println("    director: " + director);
    }
}
