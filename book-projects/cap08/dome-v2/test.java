

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class test
{
    private BaseDeDatos baseDeDa1;
    private CD cD1;
    private DVD dVD1;
    private CD cD2;

    /**
     * Default constructor for test class test
     */
    public test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        baseDeDa1 = new BaseDeDatos();
        cD1 = new CD("cd1", "a1", 10, 35);
        dVD1 = new DVD("dvd1", "jjj", 90);
        cD2 = new CD("cd2", "t", 12, 45);
        baseDeDa1.agregarElemento(cD1);
        baseDeDa1.agregarElemento(dVD1);
        baseDeDa1.agregarElemento(cD2);
        baseDeDa1.listar();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
