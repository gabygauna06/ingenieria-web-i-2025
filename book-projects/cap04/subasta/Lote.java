/**
 * Una clase para modelar un item (o conjunto de items) 
 * en una subasta: un lote
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Lote
{
    // Un número de identificación único.
    private final int numero;
    // Una descripcion del lote.
    private String descripcion;
    // La oferta actual más alta para este lote.
    private Oferta ofertaMaxima;

    /**
     * Construye un lote, estableciendo su número y descripcion.
     * @param numero El numero del lote.
     * @param descripcion Una descripcion de este lote.
     */
    public Lote(int numero, String descripcion)
    {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    /**
     * Intento de ofertar por este lote. Una oferta exitosa
     * debe tener un valor mayor a cualquiera otra existente.
     * @param oferta Una oferta nueva.
     * @return true si tiene exito, false en otro caso.
     */
    public boolean ofertarPara(Oferta oferta)
    {
        if((ofertaMaxima == null) ||
               (oferta.getValor() > ofertaMaxima.getValor())) {
            // Esta oferta es la mejor hasta el momento.
            ofertaMaxima = oferta;
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * @return Una cadena representacion de los detalles de este lote.
     */
    public String aString()
    {
        String detalles = numero + ": " + descripcion;
        if(ofertaMaxima != null) {
            detalles += "    Oferta: " + 
                       ofertaMaxima.getValor();
        }
        else {
            detalles += "    (No hay oferta)";
        }
        return detalles;
    }

    /**
     * @return El número de lote.
     */
    public int getNumero()
    {
        return numero;
    }

    /**
     * @return La descripcion del lote.
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @return La mayor oferta para este lote.
     *         Podría ser null si no hubiera una oferta.
     */
    public Oferta getOfertaMaxima()
    {
        return ofertaMaxima;
    }
}
