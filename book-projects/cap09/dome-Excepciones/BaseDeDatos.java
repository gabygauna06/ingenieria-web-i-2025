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
        try {
            elElemento.equals(elElemento);
            elementos.add(elElemento);
        }
        catch (Exception e) { }
    }

    /**
     * Imprime en la terminal de texto un listado de todos los CDs y videos
     * que actualmente están almacenados en la base de datos.
     */
    public void listar()
    {
        for(Elemento item : elementos) {
            item.imprimir();
            System.out.println();   // línea vacía entre los elementos
        }
    }

    /**
     * Imprime en la terminal de texto un listado de todos los CDs y videos
     * que actualmente están almacenados en la base de datos.
     */
    public void listarCD()
    {
        for(Elemento item : elementos) {
            try {
                CD cd = (CD) item;
                System.out.println("++>");
                cd.imprimir();
                System.out.println();   // línea vacía entre los elementos
            }
            catch (ClassCastException e) { } 
        }
    }

    public void listarDVD()
    {
        for(Elemento item : elementos) {
            try {
                DVD cd = (DVD) item;
                System.out.println("==>");
                cd.imprimir();
                System.out.println();   // línea vacía entre los elementos
            }
            catch (ClassCastException e) { } 
        }
    }
    
    public void verificarCD()
    {
        for(Elemento item : elementos) {
            try {
                item.isCD();
                System.out.println("Es CD");
            }
            catch (NoEsCDException e) {
                System.out.println(e);
            }
        }
    }
    public void verificarDVD()
    {
        for(Elemento item : elementos) {
            try {
                item.isDVD();
                System.out.println("Es DVD");
            }
            catch (NoEsDVDException e) {
                System.out.println(e);
            }
        }
    }
}


 