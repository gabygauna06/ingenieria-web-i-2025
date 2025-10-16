/**
 * La clase CD representa un objecto CD. Se almacena
 * información sobre el CD que puede ser consultada.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class CD
{
    private String titulo;
    private String interprete;
    private int numeroDeTemas;
    private int duracion;
    private boolean loTengo;
    private String comentario;

    /**
     * Inicializa el CD.
     * @param elTitulo El titulo del CD.
     * @param elInterprete El interprete del CD.
     * @param temas El numero de temas del CD.
     * @param tiempo El tiempo que dura el CD.
     */
    public CD(String elTitulo, String elInterprete, int temas, int tiempo)
    {
        titulo = elTitulo;
        interprete = elInterprete;
        numeroDeTemas = temas;
        duracion = tiempo;
        loTengo = false;
        comentario = "";
    }

    /**
     * Asigna un comentario para este CD.
     * @param comentario El comentario que se ingresara.
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * @return El comentario de este CD.
     */
    public String getComentario()
    {
        return comentario;
    }

    /**
     * Asigna el valor a la bandera que indica si tenemos este CD.
     * @param mePertenece true si tenemos el CD, false en caso contrario.
     */
    public void setLoTengo(boolean mePertenece)
    {
        loTengo = mePertenece;
    }

    /**
     * @return true si tenemos una copia de este CD.
     */
    public boolean getLoTengo()
    {
        return loTengo;
    }

    /**
     * Imprime en la terminal de texto los detalles de este CD.
     */
    public void imprimir()
    {
        System.out.print("CD: " + titulo + " (" + duracion + " minutos)");
        if(loTengo) {
            System.out.println("*");
        }
	else {
            System.out.println();
        }
        System.out.println("    " + interprete);
        System.out.println("    temas: " + numeroDeTemas);
        System.out.println("    " + comentario);
    }
}
