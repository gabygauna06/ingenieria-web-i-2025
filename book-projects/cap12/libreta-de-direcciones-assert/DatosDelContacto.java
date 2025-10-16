/**
 * Nombre, direcci�n y tel�fono del contacto.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class DatosDelContacto implements Comparable<DatosDelContacto>
{
    private String nombre;
    private String telefono;
    private String direccion;

    /**
     * Establece los datos del contacto. A todos los datos se les
     * eliminan los posibles espacios en blanco al final.
     * @param nombre El nombre.
     * @param telefono El n�mero de tel�fono.
     * @param direccion La direcci�n.
     * @throws IllegalStateException Si el nombre y el tel�fono est�n vac�os.
     */
    public DatosDelContacto(String nombre, String telefono, String direccion)
    {
        // Usa cadenas vac�as si alguno de los argumentos es null.
        if(nombre == null) {
            nombre = "";
        }
        if(telefono == null) {
            telefono = "";
        }
        if(direccion == null) {
            direccion = "";
        }

        this.nombre    = nombre.trim();
        this.telefono  = telefono.trim();
        this.direccion = direccion.trim();

        if(this.nombre.length() == 0 && this.telefono.length() == 0) {
            throw new IllegalStateException(
                      "El nombre y el tel�fono no deben estar vac�os.");
        }
    }
    
    /**
     * @return El nombre.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return El n�mero de tel�fono.
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @return La direcci�n.
     */
    public String getDireccion()
    {
        return direccion;
    }
    
    /**
     * Verifica la igualdad de contenidos entre dos objetos.
     * @param otro El objeto a comparar con este.
     * @return true si el argumento del objeto es un conjunto de datos
     *              del contacto que coinciden sus atributos.
     */
    public boolean equals(Object otro)
    {
        if(otro instanceof DatosDelContacto) {
            DatosDelContacto otroContacto = (DatosDelContacto) otro;
            return nombre.equals(otroContacto.getNombre()) &&
                    telefono.equals(otroContacto.getTelefono()) &&
                     direccion.equals(otroContacto.getDireccion());
        }
        else {
            return false;
        }
    }

    /**
     * Compara el contacto contra otro, con el objetivo de ordenar.
     * Los campos para ordenar son nombre, tel�fono y direcci�n.
     * @param otroContacto El contacto contra cual comparar.
     * @return un entero negativo si se encuentra antes del parametro,
     *            cero si son iguales y un entero positivo si se encuentra
     *            despu�s del segundo.
     */
    public int compareTo(DatosDelContacto otroContacto)
    {
        int comparacion = nombre.compareTo(otroContacto.getNombre());
        if(comparacion != 0){
            return comparacion;
        }
        comparacion = telefono.compareTo(otroContacto.getTelefono());
        if(comparacion != 0){
            return comparacion;
        }
        return direccion.compareTo(otroContacto.getDireccion());
    }

    /**
     * @return Un texto de multiples lineas conteniendo el nombre,
     * el telefono y la direccion.
     */
    public String toString()
    {
        return nombre + "\n" + telefono + "\n" + direccion;
    }
    
    /**
     * Calcula un codigo de dispersion utilizando las reglas dadas
     * en "Java Efectivo", de Joshua Bloch.
     * @return Un codigo de dispersion para DatosDelContacto.
     */
    public int hashCode()
    {
        int codigo = 17;
        codigo = 37 * codigo + nombre.hashCode();
        codigo = 37 * codigo + telefono.hashCode();
        codigo = 37 * codigo + direccion.hashCode();
        return codigo;
    }
}
