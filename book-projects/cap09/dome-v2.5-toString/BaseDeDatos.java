import java.util.ArrayList;

/**
 * La clase BaseDeDatos proporciona facilidades para almacenar objetos
 * CD y DVD. Se puede imprimir en la terminal de texto, un listado de todos
 * los CD y DVD.
 * 
 * Esta version no graba los datos en el disco y no provee ninguna funci�n
 * de búsqueda.
 * 
 * @author Michael Kolling and David J. Barnes
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class BaseDeDatos
{
    private ArrayList<Elemento> elementos;

    /**
     * Construye una BaseDeDatos vac�a.
     */
    public BaseDeDatos()
    {
        elementos = new ArrayList<Elemento>();
    }

    /**
     * Agrega un elemento a la base de datos.
     * @param elElemento El elemento que se agregar� a la base de datos.
     */
    public void agregarElemento(Elemento elElemento)
    {
        elementos.add(elElemento);
    }

    /**
     * Imprime en la terminal de texto un listado de todos los CDs y videos
     * que actualmente est�n almacenados en la base de datos.
     */
    public void listar()
    {
        for(Elemento elemento : elementos) {
            System.out.println(elemento.toString());
            System.out.println();   // l�nea vac�a entre los elementos
        }
    }
}
