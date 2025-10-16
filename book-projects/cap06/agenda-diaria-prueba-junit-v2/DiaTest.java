/**
 * La clase de prueba DiaTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class DiaTest extends junit.framework.TestCase
{
    private Dia dia1;
    private Dia dia2;
    private Cita cita1;
    private Cita cita2;
    private Cita cita3;

    
    
    
    
    

  
    
  
    /**
     * Constructor por defecto de la clase DiaTest
     */
    public DiaTest()
    {
    }

    /**
     * Establece el fixture para la prueba
     * Se invoca antes de la ejecuci�n de cada m�todo.
     */
    protected void setUp()
    {
        dia1 = new Dia(5);
        dia2 = new Dia(1);
        cita1 = new Cita("a", 56);
    }

    /**
     * Destruye el fixture para la prueba.
     *
     *  Se invoca despu�s de la ejecuci�n de cada m�todo.
     */
    protected void tearDown()
    {
    }

    /**
     * Testea la funcionalidad b�sica anotando tres citas al principio,
     * final y en medio del d�a
     */
    public void testAnotarTresCitas()
    {
        Dia dia1 = new Dia(1);
        Cita cita1 = new Cita("Conferencia de Java", 1);
        Cita cita2 = new Cita("Clase de Java", 1);
        Cita cita3 = new Cita("Ver a John", 1);
        assertEquals(true, dia1.anotarCita(9, cita1));
        assertEquals(true, dia1.anotarCita(13, cita2));
        assertEquals(true, dia1.anotarCita(17, cita3));
    }

    /**
     * Verifica que no est� permitido anotar dos citas en el mismo horario
     */
    public void testDobleCita()
    {
		Dia dia1 = new Dia(2);
		Cita cita1 = new Cita("Dormir", 8);
		assertEquals(false, dia1.anotarCita(9, cita1));
	}

	public void testTres()
	{
		assertEquals(true, dia1.anotarCita(10, cita3));
	}

    public void testCitaFueraHorario()
    {
        Dia dia2 = new Dia(2);
        Cita cita4 = new Cita("Dormir", 8);
        assertEquals(true, dia2.anotarCita(22, cita4));
    }

    public void testPruebaJUnit()
    {
        assertEquals(true, dia1.anotarCita(2, cita1));
    }
}





