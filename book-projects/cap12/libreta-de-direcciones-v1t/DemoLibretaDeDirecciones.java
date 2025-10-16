/**
 * Provee una demostraci�n simple de la clase LibretaDeDirecciones.
 * Se agregan datos de ejemplo a la libreta y se provee una interfaz
 * de texto.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class DemoLibretaDeDirecciones
{
    private LibretaDeDirecciones libreta;
    private LibretaDeDireccionesInterfazTexto interactuar;

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     * La libreta de direcciones se pasa a la IGU para brindar
     * una vista de los datos.
     */
    public DemoLibretaDeDirecciones()
    {
        DatosDelContacto[] contactosDeEjemplo = {
            new DatosDelContacto("David",  "08459 100000", "direcci�n 1"),
            new DatosDelContacto("Miguel", "08459 200000", "direcci�n 2"),
            new DatosDelContacto("Juan",   "08459 300000", "direcci�n 3"),
            new DatosDelContacto("Elena",  "08459 400000", "direcci�n 4"),
            new DatosDelContacto("Ema",    "08459 500000", "direcci�n 5"),
            new DatosDelContacto("Caty",   "08459 600000", "direcci�n 6"),
            new DatosDelContacto("Cris",   "08459 700000", "direcci�n 7"),
            new DatosDelContacto("Ruth",   "08459 800000", "direcci�n 8"),
        };
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto details : contactosDeEjemplo) {
            libreta.agregarContacto(details);
        }

        // Provee una interfaz de texto a la libreta de direcciones.
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
     * @return La libreta de direccioens de ejemplo.
     */
    public LibretaDeDirecciones getLibretaDeDirecciones()
    {
        return libreta;
    }
}
