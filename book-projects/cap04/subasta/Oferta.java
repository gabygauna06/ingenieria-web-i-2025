/**
 * Una clase que modela una oferta en una subasta.
 * Contiene una referencia a la persona ofertando
 * y el monto de la oferta.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Oferta
{
    // La persona que hace la oferta.
    private final Persona oferente;
    // El valor de la oferta. Este puede ser un número grande
    // razon por la que se usa el tipo long.
    private final long valor;

    /**
     * Crea una oferta.
     * @param oferente Quien está ofertando por el lote.
     * @param valor El valor de la oferta.
     */
    public Oferta(Persona oferente, long valor)
    {
        this.oferente = oferente;
        this.valor = valor;
    }

    /**
     * @return El oferente.
     */
    public Persona getOferente()
    {
        return oferente;
    }

    /**
     * @return El valor de la oferta.
     */
    public long getValor()
    {
        return valor;
    }
}
