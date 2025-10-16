import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Una clase para mantener un numero arbitrario de contactos.
 * La datos de los contactos se ordenan por nombre y por
 * numero de telefono.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class LibretaDeDirecciones implements Serializable
{
    // Espacio para almacenar un numero arbitrario de contactos.
    private TreeMap<String, DatosDelContacto> libreta;
    private int numeroDeEntradas;

    /**
     * Inicializa la libreta de direcciones.
     */
    public LibretaDeDirecciones()
    {
        libreta = new TreeMap<String, DatosDelContacto>();
        numeroDeEntradas = 0;
    }
    
    /**
     * Busca un nombre o un numero de telefono y devuelve
     * los correspondientes datos de ese contacto.
     * @param clave El nombre o el número a buscar.
     * @return Los datos del contacto correspondiente a la clave.
     */
    public DatosDelContacto getContacto(String clave)
    {
        return libreta.get(clave);
    }

    /**
     * Devuelve si la clave actual esta o no en uso.
     * @param clave El nombre o el telefono a buscar.
     * @return true si la clave esta en uso, false en caso contrario.
     */
    public boolean claveEnUso(String clave)
    {
        return libreta.containsKey(clave);
    }

    /**
     * Agrega un nuevo contacto a la libreta de direcciones.
     * @param contacto Los datos de contacto asociados con una persona.
     */
    public void agregarContacto(DatosDelContacto contacto)
    {
        if(contacto != null) {
            libreta.put(contacto.getNombre(), contacto);
            libreta.put(contacto.getTelefono(), contacto);
            numeroDeEntradas++;
        }
    }
    
    /**
     * Cambia los datos del contacto almacenados previamente bajo
     * la clave dada.
     * @param claveVieja Una de las claves que no se uso para almacenar los
     *                   datos del contacto.
     * @param contacto Los datos del contacto que reemplazaran a los
     *                 existentes.
     */
    public void modificarContacto(String claveVieja, DatosDelContacto contacto)
    {
        if(claveEnUso(claveVieja) && contacto != null) {
            eliminarContacto(claveVieja);
            agregarContacto(contacto);
        }
    }
    
    /**
     * Busca todos los datos de los contactos almacenados bajo
     * una clave que comienza con un prefijo determinado.
     * @param prefijo El prefijo a buscar entre las claves.
     * @return Un arreglo con los contactos que se encontraron.
     */
    public DatosDelContacto[] buscar(String prefijo)
    {
        // Construye una lista para las coincidencias.
        List<DatosDelContacto> coincidencias = new LinkedList<DatosDelContacto>();
        if(prefijo != null) {
            // Busca las claves iguales o mayores que el prefijo dato.
            SortedMap<String, DatosDelContacto> cola = libreta.tailMap(prefijo);
            Iterator<String> it = cola.keySet().iterator();
            // Termina cuando no hay coincidencia.
            boolean finDeBusqueda = false;
            while(!finDeBusqueda && it.hasNext()) {
                String clave = it.next();
                if(clave.startsWith(prefijo)) {
                    coincidencias.add(libreta.get(clave));
                }
                else {
                    finDeBusqueda = true;
                }
            }
        }
        DatosDelContacto[] resultados = new DatosDelContacto[coincidencias.size()];
        coincidencias.toArray(resultados);
        return resultados;
    }

    /**
     * @return El numero de entradas que hay actualmente en la libreta.
     */
    public int getNumeroDeEntradas()
    {
        return numeroDeEntradas;
    }

    /**
     * Elimina de la libreta, la entrada que tiene la clave dada.
     * La clave debe ser una en uso.
     * @param clave Una de las claves de entrada a eliminar.
     */
    public void eliminarContacto(String clave)
    {
        if(claveEnUso(clave)) {
            DatosDelContacto details = libreta.get(clave);
            libreta.remove(details.getNombre());
            libreta.remove(details.getTelefono());
            numeroDeEntradas--;
        }
    }

    /**
     * @return Los datos de todos los contactos, en el orden que
     *         los almacena la clase DatosDelContacto.
     */
    public String listarContactos()
    {
        // Dado que cada entrada se almacena mediante dos claves,
        // es necesario construir un conjunto de DatosDelContacto que
        // elimina los contactos duplicados.
        StringBuffer todasLasEntradas = new StringBuffer();
        Set<DatosDelContacto> contactosOrdenados = new TreeSet<DatosDelContacto>(libreta.values());
        for(DatosDelContacto contacto : contactosOrdenados) {
            todasLasEntradas.append(contacto);
            todasLasEntradas.append('\n');
            todasLasEntradas.append('\n');
        }
        return todasLasEntradas.toString();
    }
}
