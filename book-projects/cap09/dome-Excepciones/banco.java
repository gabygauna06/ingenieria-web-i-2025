

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class banco.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class banco
{
    private CD cD1;
    private CD cD2;
    private DVD dVD1;
    private DVD dVD2;

    /**
     * Default constructor for test class banco
     */
    public banco()
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
        cD1 = new CD("Mania", "Ramones", 30, 60);
        cD2 = new CD("Once", "Nightwish", 10, 45);
        dVD1 = new DVD("Shrek", "TTT", 90);
        dVD2 = new DVD("Clockwork Orange", "Stanley Kubrick", 120);
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
}
