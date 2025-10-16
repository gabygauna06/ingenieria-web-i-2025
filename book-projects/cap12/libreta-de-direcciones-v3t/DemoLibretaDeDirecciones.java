/**
 * Provee una demostración simple de la clase LibretaDeDirecciones.
 * Se agregan datos de ejemplo a la libreta y se provee una interfaz
 * de texto.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class DemoLibretaDeDirecciones
{
    private LibretaDeDirecciones libreta;
    private LibretaDeDireccionesInterfazTexto interactuar;

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     * La libreta de direcciones se pasa a la interfaz de texto
     * para brindar una vista de los datos.
     */
    public DemoLibretaDeDirecciones()
    {
        DatosDelContacto[] contactosDeEjemplo = {
            new DatosDelContacto("david",   "08459 100000", "address 1"),
            new DatosDelContacto("michael", "08459 200000", "address 2"),
            new DatosDelContacto("john",    "08459 300000", "address 3"),
            new DatosDelContacto("helen",   "08459 400000", "address 4"),
            new DatosDelContacto("emma",    "08459 500000", "address 5"),
            new DatosDelContacto("kate",    "08459 600000", "address 6"),
            new DatosDelContacto("chris",   "08459 700000", "address 7"),
            new DatosDelContacto("ruth",    "08459 800000", "address 8"),
        };
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contacto : contactosDeEjemplo) {
            libreta.agregarContacto(contacto);
        }
        interactuar = new LibretaDeDireccionesInterfazTexto(libreta);
    }

    /**
     * Permite al usuario interactuar con la libreta de direcciones.
     */
    public void showInterfaz()
    {
        interactuar.ejecutar();
    }

    /**
     * @return La libreta de direcciones de ejemplo.
     */
    public LibretaDeDirecciones getLibretaDeDirecciones()
    {
        return libreta;
    }
}
