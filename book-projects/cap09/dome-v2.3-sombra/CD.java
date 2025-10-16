/**
 * La clase CD representa un objecto CD. Se almacena
 * informacion sobre el CD que puede ser consultada.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class CD extends Elemento
{
    private String interprete;
    private int numeroDeTemas;

    /**
     * Inicializa el CD.
     * @param elTitulo El titulo del CD.
     * @param elInterprete El interprete del CD.
     * @param temas El numero de temas del CD.
     * @param tiempo El tiempo que dura el CD.
     */
    public CD(String elTitulo, String elInterprete, int temas, int tiempo)
    {
        super(elTitulo, tiempo);
        interprete = elInterprete;
        numeroDeTemas = temas;
    }

    /**
     * @return El interprete de este CD.
     */
    public String getArtista()
    {
        return interprete;
    }

    /**
     * @return El numero de temas de este CD.
     */
    public int getNumeroDeTemas()
    {
        return numeroDeTemas;
    }

    /**
     * Imprime en la terminal de texto los detalles de este CD.
     */
    public void imprimir()
    {
        System.out.println("    " + interprete);
        System.out.println("    temas: " + numeroDeTemas);
    }
}
