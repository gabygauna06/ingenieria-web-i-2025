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

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     * La libreta de direcciones se pasa a la IGU para brindar
     * una vista de los datos.
     */
    public DemoLibretaDeDirecciones()
    {
        DatosDelContacto[] contactosDeEjemplo = {
            new DatosDelContacto("david",   "08459 100000", "dirección 1"),
            new DatosDelContacto("miguel", "08459 200000", "dirección 2"),
            new DatosDelContacto("juan",    "08459 300000", "dirección 3"),
            new DatosDelContacto("elena",   "08459 400000", "dirección 4"),
            new DatosDelContacto("ema",    "08459 500000", "dirección 5"),
            new DatosDelContacto("caty",    "08459 600000", "dirección 6"),
            new DatosDelContacto("cris",   "08459 700000", "dirección 7"),
            new DatosDelContacto("ruth",    "08459 800000", "dirección 8"),
        };
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contacto : contactosDeEjemplo) {
            libreta.agregarContacto(contacto);
        }
    }

    /**
     * @return La libreta de direcciones de ejemplo.
     */
    public LibretaDeDirecciones getLibretaDeDirecciones()
    {
        return libreta;
    }
}
