import java.util.Collection;
import java.util.HashSet;
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
 * número de telefono.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class LibretaDeDirecciones
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
     * Busca un nombre o un número de teléfono y devuelve
     * los correspondientes datos de ese contacto.
     * @param clave El nombre o el número a buscar.
     * @return Los datos del contacto correspondiente a la clave.
     */
    public DatosDelContacto getContacto(String clave)
    {
        return libreta.get(clave);
    }

    /**
     * Devuelve si la clave actual está o no en uso.
     * @param clave El nombre o el teléfono a buscar.
     * @return true si la clave esta en uso, false en caso contrario.
     */
    public boolean claveEnUso(String clave)
    {
        return libreta.containsKey(clave);
    }

    /**
     * Agrega un nuevo contacto a la libreta de direcciones.
     * @param contacto Los datos de contacto asociados con una persona.
     * @throws IllegalArgumentException Si el contacto es null.
     */
    public void agregarContacto(DatosDelContacto contacto)
    {
        if(contacto == null) {
            throw new IllegalArgumentException("clave Null en agregarContacto.");
        }
        libreta.put(contacto.getNombre(), contacto);
        libreta.put(contacto.getTelefono(), contacto);
        numeroDeEntradas++;
        assert tamanioConsistente() : "El tamaño de la libreta es inconsistente en agregarContacto.";
    }
    
    /**
     * Cambia los datos del contacto almacenados previamente bajo
     * la clave dada.
     * @param claveVieja Una de las claves que no se uso para almacenar los
     *                   datos del contacto.
     * @param contacto Los datos del contacto que reemplazaran a los
     *                 existentes.
     * @throws IllegalArgumentException Si el contacto o la clave es null.
     */
    public void modificarContacto(String claveVieja,
                              DatosDelContacto contacto)
    {
        if(contacto == null) {
            throw new IllegalArgumentException("Se pasó contacto vacÃ­o a modificarContacto.");
        }
        if(claveVieja == null){
            throw new IllegalArgumentException("Se pasó clave vacÃ­a a modificarContacto.");
        }
        if(claveEnUso(claveVieja)){
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
     * @throws IllegalArgumentException Si la clave es null.
     */
    public void eliminarContacto(String clave)
    {
        if(clave == null){
            throw new IllegalArgumentException("Se pasó una clave vacía a eliminarContacto.");
        }
        if(claveEnUso(clave)) {
            DatosDelContacto contacto = libreta.get(clave);
            libreta.remove(contacto.getNombre());
            libreta.remove(contacto.getTelefono());
            numeroDeEntradas--;
        }
        assert !claveEnUso(clave);
        assert tamanioConsistente() : "El tamaño de la libreta es inconsistente en eliminarContacto.";
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
    
    /**
     * Verifica que el campo numeroDeEntradas sea consistente con
     * el número de entradas almacenadas en la libreta.
     * @return 'true' si el campo es consistente, 'false' en caso contrario.
     */
    private boolean tamanioConsistente()
    {
        Collection<DatosDelContacto> todasLasEntradas = libreta.values();
        // Elimina contactos duplicados.
        Set<DatosDelContacto> entradaUnica = new HashSet<DatosDelContacto>(todasLasEntradas);
        int cuentaActual = entradaUnica.size();
        return numeroDeEntradas == cuentaActual;
    }
}
