

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class p.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class p
{
    private Cita cita3;
    private Dia dia1;
    private Semana s;

    /**
     * Default constructor for test class p
     */
    public p()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cita3 = new Cita("Dormir", 15);
        dia1 = new Dia(3);
        s = new Semana(10);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void PCita()
    {
        Cita cita1 = new Cita("Dormir", 15);
        assertEquals("Dormir", cita1.getDescripcion());
    }
}

