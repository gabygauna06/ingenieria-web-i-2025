/**
 * Modela algunos detalles de un producto vendido
 * por una compañía.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Producto
{
    // Un número identificatorio para este producto.
    private int id;
    // El nombre de este producto.
    private String nombre;
    // la cantidad de este producto en stock.
    private int cantidad;

    /**
     * Constructor para objetos de la clase Producto.
     * La cantidad inicial de stock es cero.
     * @param id El número de identificación del product.
     * @param nombre El nombre del producto.
     */
    public Producto(int id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
        cantidad = 0;
    }

    /**
     * @return El id del producto.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return El nombre del producto.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return La cantidad en stock.
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * @return El id, nombre y cantidad en stock.
     */
    public String toString()
    {
        return id + ": " +
               nombre +
               " nivel de stock: " + cantidad;
    }

    /**
     * Aumenta el stock en el monto dado de este product.
     * La cantidad actual es incrementada en el monto dado.
     * @param monto The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void incrementarCantidad(int monto)
    {
        if(monto > 0) {
            cantidad += monto;
        }
        else {
            System.out.println("Intento de aumento del stock de " +
                               nombre +
                               " en un monto no-positive: " +
                               monto);
        }
    }

    /**
     * Vender uno de estos productos.
     * Se reporta un error si se descubre que no hay stock.
     */
    public void venderUno()
    {
        if(cantidad > 0) {
            cantidad--;
        }
        else {
            System.out.println(
                "Intento de venta de un item fuera sin stock: " + nombre);
        }
    }
}
