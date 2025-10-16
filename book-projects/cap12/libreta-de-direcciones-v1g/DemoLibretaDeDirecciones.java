/**
 * Provee una demostración simple de la clase LibretaDeDirecciones.
 * Se agregan datos de ejemplo a la libreta y se provee una IGU.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class DemoLibretaDeDirecciones
{
    private LibretaDeDirecciones libreta;
    private LibretaDeDireccionesIGU interactuar;

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     * La libreta de direcciones se pasa a la IGU para brindar
     * una vista de los datos.
     */
    public DemoLibretaDeDirecciones()
    {
        DatosDelContacto[] contactosDeEjemplo = {
            new DatosDelContacto("David",   "08459 100000", "dirección 1"),
            new DatosDelContacto("Miguel", "08459 200000", "dirección 2"),
            new DatosDelContacto("Juan",    "08459 300000", "dirección 3"),
            new DatosDelContacto("Elena",   "08459 400000", "dirección 4"),
            new DatosDelContacto("Ema",    "08459 500000", "dirección 5"),
            new DatosDelContacto("Caty",    "08459 600000", "dirección 6"),
            new DatosDelContacto("Cris",   "08459 700000", "dirección7"),
            new DatosDelContacto("Ruth",    "08459 800000", "dirección 8"),
        };
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contactos : contactosDeEjemplo) {
            libreta.agregarContacto(contactos);
        }

        // Provee una IGU a la libreta de direcciones.
        interactuar = new LibretaDeDireccionesIGU(libreta);
    }

    /**
     * Permite al usuario interactuar con la libreta de direcciones.
     */
    public void showInterfaz()
    {
        interactuar.setVisible(true);
    }

    /**
     * @return La libreta de direccioens de ejemplo.
     */
    public LibretaDeDirecciones getLibretaDeDirecciones()
    {
        return libreta;
    }
}
