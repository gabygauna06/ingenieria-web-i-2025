import java.util.ArrayList;

/**
 * Un modelo simplificado de una subasta.
 * La subasta mantiene una lista de lotes de longitud arbitraria.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Subasta
{
    // La lista de lotes en esta subasta.
    private ArrayList<Lote> lotes;
    // El número que se le dará al próximo lote que ingrese
    // a esta subasta.
    private int numeroDeLoteSiguiente;

    /**
     * Crea una nueva subasta.
     */
    public Subasta()
    {
        lotes = new ArrayList<Lote>();
        numeroDeLoteSiguiente = 1;
    }

    /**
     * Ingresa un nuevo lote en la subasta.
     * @param descripcion Una descripcion del lote.
     */
    public void ingresarLote(String descripcion)
    {
        lotes.add(new Lote(numeroDeLoteSiguiente, descripcion));
        numeroDeLoteSiguiente++;
    }

    /**
     * Muestra la lista completa de lotes de esta subasta.
     */
    public void mostrarLotes()
    {
        for(Lote lote : lotes) {
            System.out.println(lote.toString()); // Codigo interno
        }
    }
    
    /**
     * Ofertar para un lote.
     * Emite un mensaje que indica si una oferta es exitosa o no.
     * @param numeroDeLote EL numero de lote al que oferta.
     * @param oferente La persona que hace la oferta.
     * @param valor  El valor de la oferta.
     */
    public void ofertarPara(int numeroDeLote, Persona oferente, long valor)
    {
        Lote loteElegido = getLote(numeroDeLote);
        if(loteElegido != null) {
            boolean exito = loteElegido.ofertarPara(new Oferta(oferente, valor));
            if(exito) {
                System.out.println("La oferta para lote número " +
                                   numeroDeLote + " resultó exitosa.");
            }
            else {
                // Informa cual es la mayor oferta.
                Oferta ofertaMaxima = loteElegido.getOfertaMaxima();
                System.out.println("El lote número: " + numeroDeLote +
                                   " ya tiene una oferta de: " +
                                   ofertaMaxima.getValor());
            }
        }
    }

    /**
     * Devuelve el lote de un determinado número.
     * Devuelve null si no existe un lote con ese número.
     * @param numeroDeLote El número de lote a retornar.
     */
    public Lote getLote(int numeroDeLote)
    {
        if((numeroDeLote >= 1) && (numeroDeLote < numeroDeLoteSiguiente)) {
            // El número parece ser razonable.
            Lote loteElegido = lotes.get(numeroDeLote - 1);
            // Incluye un control confidencial para asegurar que el lote es
            // el correcto.
            if(loteElegido.getNumero() != numeroDeLote) {
                System.out.println("Error interno: se retorno el lote número " +
                                   loteElegido.getNumero() +
                                   " en logar del número " +
                                   numeroDeLote);
            }
            return loteElegido;
        }
        else {
            System.out.println("El lote número: " + numeroDeLote +
                               " no existe.");
            return null;
        }
    }
}
