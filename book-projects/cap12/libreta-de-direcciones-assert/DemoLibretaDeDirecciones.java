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
    // Una lista de contactos de ejemplo.
    private DatosDelContacto[] contactosDeMuestra;
    // Una libreta de direccions con datos de muestra.
    private LibretaDeDirecciones libreta;
    // Una copia de uno de los datos de un contacto.
    private DatosDelContacto contactoExistente;
    // Un contacto adicional.
    private DatosDelContacto contactoAdicional;

    /**
     * Configura algunos datos de ejemplo.
     */
    public DemoLibretaDeDirecciones()
    {
        // Una muestra de datos de contactos para almacenar en la libreta.
        contactosDeMuestra = new DatosDelContacto[] {
            new DatosDelContacto("david",  "08459 100000", "dirección 1"),
            new DatosDelContacto("miguel", "08459 200000", "dirección 2"),
            new DatosDelContacto("juan",   "08459 300000", "dirección 3"),
            new DatosDelContacto("elena",  "08459 400000", "dirección 4"),
            new DatosDelContacto("ema",    "08459 500000", "dirección 5"),
            new DatosDelContacto("caty",   "08459 600000", "dirección 6"),
            new DatosDelContacto("cris",   "08459 700000", "dirección 7"),
            new DatosDelContacto("ruth",   "08459 800000", "dirección 8"),
        };
        libreta = new LibretaDeDirecciones();
        // Toma una copia de los datos de un contacto.
        DatosDelContacto primero = contactosDeMuestra[0];
        contactoExistente = new DatosDelContacto(primero.getNombre(), primero.getTelefono(),
                                     primero.getDireccion());
        // Crea un contacto adicional que no se encuentra en la libreta.
        contactoAdicional = new DatosDelContacto("ivan", "08459 900000", "dirección 9");
    }

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     */
    public void setup()
    {
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contacto : contactosDeMuestra) {
            libreta.agregarContacto(contacto);
        }
    }
    
    /**
     * Una prueba simple de agregarContacto para ver si falla la aserción.
     */
    public void probarAgregar()
    {
        setup();
        libreta.agregarContacto(contactoAdicional);
    }
    
    /**
     * Una prueba simple de eliminarContacto para ver si falla la aserción.
     */
    public void probarBorrar()
    {
        setup();
        libreta.eliminarContacto(contactoExistente.getNombre());
    }
    
    /**
     * Una prueba simple de modificarContacto para ver si falla la aserción.
     */
    public void probarModificar()
    {
        setup();
        DatosDelContacto contactoRevisado = crearContactoRevisado();
            
        libreta.modificarContacto(contactoExistente.getNombre(),
                           contactoRevisado);
    }
    
    /**
     * Agrega por segunda vez una entrada con nombre y
     * telefono duplicados.
     * Esto deberia disparar un AssertionError.
     */
    public void probarErrorDeAgregado()
    {
        setup();
        libreta.agregarContacto(crearContactoRevisado());
    }

    /**
     * @return La libreta de direcciones de ejemplo.
     */
    public LibretaDeDirecciones getLibretaDeDirecciones()
    {
        return libreta;
    }

    /**
     * @return Los datos de un contacto que estaba originalmente
     *         en la libreta de direcciones.
     */
    public DatosDelContacto getContactoExistente()
    {
        return contactoExistente;
    }

    /**
     * @return Los datos de un contacto adicional, originalmente
     *         no estaba en la libreta de direcciones.
     */
    public DatosDelContacto getContactoAdicional()
    {
        return contactoAdicional;
    }
    
    /**
     * Crea un contacto en base a un contacto existente.
     */
    private DatosDelContacto crearContactoRevisado()
    {
        return new DatosDelContacto(contactoExistente.getNombre(),
                                  contactoExistente.getTelefono(),
                                  contactoExistente.getDireccion() + "X");
    }
}
