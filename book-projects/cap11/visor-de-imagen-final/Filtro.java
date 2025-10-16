/**
 * Filtro es una superclase abstracta para todos los filtros de esta
 * aplicación. Los filtros pueden aplicarse a una ImagenOF invocando
 * la aplicación del método.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public abstract class Filtro
{
    private String nombre;

    /**
     * Crea un filtro cuevo con el nombre dado.
     * @param nombre El nombre del filtro.
     */
    public Filtro(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el nombre de este filtro.
     * 
     * @return  El nombre de este filtro.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Aplica este filtro a una imagen.
     * 
     * @param  imagen  La imagen a modificar por este filtro.
     */
    public abstract void aplicar(ImagenOF imagen);
}
