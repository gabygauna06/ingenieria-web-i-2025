import java.util.List;
import java.util.Random;

/**
 * Un modelo sencillo de conejo.
 * Los conejos nacen, se mueven, comen y mueren.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Conejo extends Animal
{
    // Características compartidas por todos los conejos (campos estáticos).

    // La edad en que un conejo comienza a reproducirse
    private static final int EDAD_DE_REPRODUCCION = 5;
    // La edad que puede vivir un conejo.
    private static final int EDAD_MAX = 50;
    // La probabilidad de reproducción de un conejo.
    private static final double PROBABILIDAD_DE_REPRODUCCION = 0.15;
    // El número máximo de nacimientos.
    private static final int MAXIMO_TAMANIO_DE_CAMADA = 5;
    // Un número aleatorio para controlar la reproducción.
    private static final Random rand = new Random();
    
    // Características individuales (campos de instancia).

    /**
     * Crea un nuevo conejo. Se puede crear un conejo con edad
     * cero (un nuevo nacimiento) o con edad por azar.
     * 
     * @param edadPorAzar Si es true, el conejo tendrá una edad por azar.
     */
    public Conejo(boolean edadPorAzar)
    {
        super();
        if(edadPorAzar) {
            setEdad(rand.nextInt(EDAD_MAX));
        }
    }
    
    
    /**
     * Aumenta la edad.
     * Podría dar por resultado la muerte del conejo.
     */
    private void incrementarEdad()
    {
        setEdad(getEdad() + 1);
        if(getEdad() > EDAD_MAX) {
            setMuerto();
        }
    }
    
    /**
     * Genera un número que representa el número de nacimientos,
     * si es que el conejo se puede reproducir.
     * @return El número de nacimientos (puede ser cero).
     */
    private int reproducir()
    {
        int nacimientos = 0;
        if(sePuedeReproducir() && rand.nextDouble() <= PROBABILIDAD_DE_REPRODUCCION) {
            nacimientos = rand.nextInt(MAXIMO_TAMANIO_DE_CAMADA) + 1;
        }
        return nacimientos;
    }
    
    /**
     * @return Un texto que representa al conejo.
     */
    public String toString()
    {
        return "Conejo, edad " + getEdad();
    }

    /**
     * El conejo se puede reproducir si alcanzó la edad de reproducción.
     */
    private boolean sePuedeReproducir()
    {
        return getEdad() >= EDAD_DE_REPRODUCCION;
    }
}
