/**
 * Mantiene los detalles de alguien que participa en una subasta.
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Persona
{
    // El nombre de esta persona.
    private final String nombre;

    /**
     * Crea una nueva persona con el nombre dado.
     * @param nombre El nombre de la persona.
     */
    public Persona(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return El nombre de la persona.
     */
    public String getNombre()
    {
        return nombre;
    }
}
