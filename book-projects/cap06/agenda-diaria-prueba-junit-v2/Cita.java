/**
 * Graba detalles de una cita diaria.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Cita
{
    // El motivo de la cita.
    private String descripcion;
    // la duración de la cita en horas.
    private int duracion;

    /**
     * Crea una cita con una duracion determinada.
     * @param descripcion El motivo de la cita.
     * @param duracion La duración de la cita en horas
     */
    public Cita(String descripcion, int duracion)
    {
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    /**
     * @return El motivo de la cita.
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    
    /**
     * @return La duración de la cita (en horas)
     */
    public int getDuracion()
    {
        return duracion;
    }
}
