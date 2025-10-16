import java.util.ArrayList;

/**
 * La clase BaseDeDatos proporciona facilidades para almacenar objetos
 * CD y DVD. Se puede imprimir en la terminal de texto, un listado de todos
 * los CD y DVD.
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
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    /**
     * Construye una BaseDeDatos vacía.
     */
    public BaseDeDatos()
    {
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
    }

    /**
     * Agrega un CD a la base de datos.
     * @param elCD El CD que se agregará a la base de datos.
     */
    public void agregarCD(CD elCD)
    {
        cds.add(elCD);
    }

    /**
     * Agrega un DVD a la base de datos.
     * @param elDVD El DVD que se agregará a la base de datos.
     */
    public void agregarDVD(DVD elDVD)
    {
        dvds.add(elDVD);
    }

    /**
     * Imprime en la terminal de texto un listado de todos los CD y DVD
     * que actualmente estan almacenados en la base de datos.
     */
    public void listar()
    {
        // Imprime la lista de CD
        for(CD cd : cds) {
            cd.imprimir();
            System.out.println();
            
        }

        // Imprime la lista de DVD
        for(DVD dvd : dvds) {
            dvd.imprimir();
            System.out.println();   // línea vacía entre los elementos
        }
    }
}
