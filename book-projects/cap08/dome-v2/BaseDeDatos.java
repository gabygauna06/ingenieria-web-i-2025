import java.util.ArrayList;

/**
 * La clase BaseDeDatos proporciona facilidades para almacenar objetos
 * de elementos de entretenimiento. Se puede imprimir en la terminal
 * de texto, un listado de todos los elementos.
 * 
 * Esta versión no graba los datos en el disco y no provee ninguna función
 * de búsqueda.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class BaseDeDatos
{
    private ArrayList<Elemento> elementos;

    /**
     * Construye una BaseDeDatos vacía.
     */
    public BaseDeDatos()
    {
        elementos = new ArrayList<Elemento>();
    }

    /**
     * Agrega un elemento a la base de datos.
     * @param elElemento El elemento que se agregará a la base de datos.
     */
    public void agregarElemento(Elemento elElemento)
    {
        elementos.add(elElemento);
    }

    /**
     * Imprime en la terminal de texto un listado de todos los elementos
     * que actualmente están almacenados en la base de datos.
     */
    public void listar()
    {
        for(Elemento item : elementos) {
            item.imprimir();
            System.out.println();   // línea vacía entre los elementos
        }
    }
}
