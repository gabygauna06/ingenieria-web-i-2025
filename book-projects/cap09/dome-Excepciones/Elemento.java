/**
 * La clase Elemento representa un elemento multimedia.
 * Se almacena información sobre el elemento que puede ser
 * consultada. Esta clase sirve como una superclase para
 * elementos más específicos.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Elemento
{
    private String titulo;
    private int duracion;
    private boolean loTengo;
    private String comentario;

    /**
     * Inicializa los campos del elemento.
     * @param elTitulo El titulo del elemento.
     * @param tiempo El tiempo que dura el elemento.
     */
    public Elemento(String elTitulo, int tiempo)
    {
        titulo = elTitulo;
        duracion = tiempo;
        loTengo = false;
        comentario = "";
    }

    /**
     * Asigna un comentario para este elemento.
     * @param comentario El comentario que se ingresara.
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * @return El comentario de este elemento.
     */
    public String getComentario()
    {
        return comentario;
    }

    /**
     * Asigna el valor a la bandera que indica si tenemos este elemento.
     * @param mePertenece true si tenemos el elemento, false en caso contrario.
     */
    public void setLoTengo(boolean mePertenece)
    {
        loTengo = mePertenece;
    }

    /**
     * @return true si tenemos una copia de este elemento.
     */
    public boolean getLoTengo()
    {
        return loTengo;
    }

    /**
     * Imprime en la terminal de texto los detalles de este elemento.
     */
    public void imprimir()
    {
        System.out.print(titulo + " (" + duracion + " minutos) ");
        if(loTengo) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + comentario);
    }
    
    public void isCD () throws NoEsCDException {
        try {
            CD cd = (CD) this;
        }
        catch (ClassCastException e) {
            throw new NoEsCDException();
        }
    }

    public void isDVD () throws NoEsDVDException {
        try {
            DVD cd = (DVD) this;
        }
        catch (ClassCastException e) {
            throw new NoEsDVDException();
        }
    }
}
