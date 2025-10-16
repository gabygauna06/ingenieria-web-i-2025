import java.util.ArrayList;

/**
 * Gestiona el stock en un negocio.
 * El stock es descripto por cero o más productos.
 * 
 * @author (su nombre) 
 * @version (un número de versióna o una fecha)
 */
public class GestorDeStock
{
    // Una lista de los productos.
    private ArrayList<Producto> stock;

    /**
     * Inicializa el gestor de stock.
     */
    public GestorDeStock()
    {
        stock = new ArrayList<Producto>();
    }

    /**
     * Agrega un product a la lista.
     * @param item El item a ser agregado.
     */
    public void agregaProducto(Producto item)
    {
        stock.add(item);
    }
    
    /**
     * Recibe la entrega de un producto particular.
     * Incrementa la cantidad de un producto en el monto dado.
     * @param id El identificador (ID) del producto.
     * @param monto El monto por el cual se incrementa la cantidad.
     */
    public void entrega(int id, int monto)
    {
    }
    
    /**
     * Trata de encontrar en el stock un producto con un ID dado.
     * @return El producto identificado, o null si no hay alguno
     *         con el ID dado.
     */
    public Producto encuentraProducto(int id)
    {
        return null;
    }
    
    /**
     * Ubica un producto con el ID dado, y retorna la cantidad
     * de items que hay en stock. Si el ID no es encontrado,
     * retorna cero.
     * @param id El identificador (ID) del producto.
     * @return La cantidad en stock del producto dado.
     */
    public int cantidadEnStock(int id)
    {
        return 0;
    }

    /**
     * Imprime detalles de todos los productos.
     */
    public void imprimirDetallesDelProducto()
    {
    }
}
