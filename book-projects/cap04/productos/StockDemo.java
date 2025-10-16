/**
 * Demuestra las clases GestorDeStock y Producto.
 * La demostración se convierte en funcional si se
 * completan las clases GestorDeStock y Producto.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class StockDemo
{
    // El gestor de stock.
    private GestorDeStock gestor;

    /**
     * Crea un GestorDeStock y lo llena con unos pocos
     * productos de ejemplo.
     */
    public StockDemo()
    {
        gestor = new GestorDeStock();
        gestor.agregaProducto(new Producto(132, "Radio reloj"));
        gestor.agregaProducto(new Producto(37,  "Telefono celular"));
        gestor.agregaProducto(new Producto(23,  "Horno microonda"));
    }
    
    /**
     * Provee una demostración muy simple de como debe ser usado
     * un GestorDeStock. Se muestran los detalles de un producto,
     * el producto es colocado en el stock nuevamente, y también
     * sus detalles son desplegados otra vez.
     */
    public void demo()
    {
        // Muestra los detalles de todos los productos.
        gestor.imprimirDetallesDelProducto();
        // Take delivery of 5 items of one of the products.
        gestor.entrega(132, 5);
        gestor.imprimirDetallesDelProducto();
    }
    
    /**
     * Muestra los detalles de un producto dado. Si es encontrado,
     * se muestran su nombre y la cantidad en stock.
     * @param id La identificación (ID)del producto buscado.
     */
    public void muestraDetalles(int id)
    {
        Producto producto = getProducto(id);
        if(producto != null) {
            System.out.println(producto.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the producto.
     * @param id The ID of the producto being sold.
     */
    public void sellProducto(int id)
    {
        Producto producto = getProducto(id);
        
        if(producto != null) {
            muestraDetalles(id);
            producto.venderUno();
            muestraDetalles(id);
        }
    }
    
    /**
     * Toma del gestor el producto con un id dado.
     * Se imprime un mensaje de error si no hay coincidencia.
     * @param id La identificación (ID) del producto.
     * @return El Producto, o null si no se encuentra.
     */
    public Producto getProducto(int id)
    {
        Producto producto = gestor.encuentraProducto(id);
        if(producto == null) {
            System.out.println("El producto con ID: " + id +
                               " no es reconocido.");
        }
        return producto;
    }

    /**
     * @return El gestor de stock.
     */
    public GestorDeStock getGestor()
    {
        return gestor;
    }
}
