/**
 * Un lineamiento de pruebas para la clase LibretaDeDirecciones.
 * No se prueban todos los m�todos.
 * 
 * @author  David J. Barnes and Michael Kolling
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class PruebaLibretaDeDirecciones extends junit.framework.TestCase
{
    // Contactos de muestra.
    private DatosDelContacto[] contactosDeEjemplo;
    // Una libreta que contiene datos de ejemplo.
    private LibretaDeDirecciones libreta;
    // Una copia de los datos de uno de los contactos.
    private DatosDelContacto contactoExistente;
    // Un contacto adicional.
    private DatosDelContacto contactoAdicional;
    // Datos revisados para un contacto existente.
    private DatosDelContacto contactoRevisado;

    /**
     * Configura una LibretaDeDirecciones con datos de ejemplo.
     */
    public PruebaLibretaDeDirecciones()
    {
        // Datos de contactos de ejemplo para almacenar en la libreta.
        contactosDeEjemplo = new DatosDelContacto[] {
            new DatosDelContacto("david", "08459 100000", "direcci�n 1"),
            new DatosDelContacto("migel", "08459 200000", "direcci�n 2"),
            new DatosDelContacto("juan",  "08459 300000", "direcci�n 3"),
            new DatosDelContacto("elena", "08459 400000", "direcci�n 4"),
            new DatosDelContacto("ema",   "08459 500000", "direcci�n 5"),
            new DatosDelContacto("caty",  "08459 600000", "direcci�n 6"),
            new DatosDelContacto("cris",  "08459 700000", "direcci�n 7"),
            new DatosDelContacto("ruth",  "08459 800000", "direcci�n 8"),
        };
    }

    /**
     * Establece los pasos de las pruebas.
     *
     * Se la llama antes de cada m�todo de prueba.
     */
    protected void setUp()
    {
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contacto : contactosDeEjemplo) {
            libreta.agregarContacto(contacto);
        }
        // Toma una copia de los datos de uno de los contactos.
        DatosDelContacto primero = contactosDeEjemplo[0];
        contactoExistente = new DatosDelContacto(primero.getNombre(), primero.getTelefono(),
                                     primero.getDireccion());
        // Crea un contacto adicional si todavia no est� en la libreta de direcciones.
        contactoAdicional = new DatosDelContacto("ivan", "08459 900000", "direcci�n 9");
        // Cambia la direcci�n de un contacto existente.
        contactoRevisado = new DatosDelContacto(contactoExistente.getNombre(),
                                            contactoExistente.getTelefono(),
                                            contactoExistente.getDireccion() + "X");

    }

    /**
     * Termina los pasos de las pruebas.
     *
     * Se la llama despues de cada m�todo de prueba.
     * Called after every test case method.
     */
    protected void tearDown()
    {
        libreta = null;
        contactoExistente = null;
        contactoAdicional = null;
        contactoRevisado = null;
    }

    /**
     * Verifica que la cuenta coincida con el numero de entradas
     * de muestra. Luego remueve uno y verifica que el numero de muestra
     * coincida con el numero de entradas. Luego agrega un contacto y
     * verifica que se haya incrementado el valor.
     */
    public void testGetNumeroDeEntradas()
    {
        assertEquals(contactosDeEjemplo.length, libreta.getNumeroDeEntradas());
        libreta.eliminarContacto(contactoExistente.getNombre());
        assertEquals(contactosDeEjemplo.length - 1, libreta.getNumeroDeEntradas());
        libreta.agregarContacto(contactoAdicional);
        assertEquals(contactosDeEjemplo.length, libreta.getNumeroDeEntradas());
    }

    /**
     * Verifica que el contacto existente pueda encontrarse y que
     * un no existene no pueda ser encontrado.
     */
    public void testGetContactos()
    {
        assertEquals(contactoExistente, libreta.getContacto(contactoExistente.getNombre()));
        assertNull(libreta.getContacto(contactoAdicional.getNombre()));
    }

    /**
     * Verifica que el nombre y el numero de telefono de un contacto
     * existente estan registrados como claves existentes.
     */
    public void testClavesEnUso()
    {
        assertEquals(true, libreta.claveEnUso(contactoExistente.getNombre()));
        assertEquals(true, libreta.claveEnUso(contactoExistente.getTelefono()));
    }

    /**
     * Verifica que se puede agregar un nuevo contacto.
     */
    public void testAgregarContacto()
    {
        assertEquals(false, libreta.claveEnUso("ivan"));
        libreta.agregarContacto(contactoAdicional);
        assertEquals(true, libreta.claveEnUso("ivan"));
        assertEquals(contactosDeEjemplo.length + 1, libreta.getNumeroDeEntradas());
    }

    /**
     * Verifica que se puede agregar un contacto adicional y
     * luego resumirlo.
     */
    public void testBorrarContacto()
    {
        libreta.agregarContacto(contactoAdicional);
        assertEquals(true, libreta.claveEnUso("ivan"));
        libreta.eliminarContacto("ian");
        assertEquals(false, libreta.claveEnUso("ian"));
    }

    /**
     * Verifica que los datos de un contacto existente puedan modificarse.
     */
    public void testCambiarContacto()
    {
        assertEquals(contactoExistente, libreta.getContacto(contactoExistente.getNombre()));
        libreta.modificarContacto(contactoExistente.getNombre(), contactoRevisado);
        assertEquals(contactoRevisado, libreta.getContacto(contactoRevisado.getNombre()));
    }

    /**
     * Verifica que la busqueda de un contacto encuentra una entrada.
     * Luego, verifique que falle la busqueda de un contacto no
     * existente. Luego, agrega un nuevo contacto y verifica que se
     * lo puede encontrar.
     */
    public void testBuscar()
    {
        assertEquals(libreta.buscar(contactoExistente.getNombre()).length, 1);
        assertEquals(libreta.buscar(contactoAdicional.getNombre()).length, 0);
        libreta.agregarContacto(contactoAdicional);
        assertEquals(libreta.buscar(contactoAdicional.getNombre()).length, 1);
    }
    
    /**
     * Lanza un error de asercion agregando detalles revisado
     * mediante agregarContacto en lugar de modificarContacto.
     */
    public void testAgregarContactoError()
    {
        assertEquals(contactoExistente, libreta.getContacto(contactoExistente.getNombre()));
        libreta.agregarContacto(contactoRevisado);
        assertEquals(contactoExistente, libreta.getContacto(contactoExistente.getNombre()));
        assertEquals(contactoRevisado,  libreta.getContacto(contactoRevisado.getNombre()));
    }

	public void testTastUno()
	{
	}

	public void testPrueba()
	{
	}
}










