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
public class Conejo
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
    
    // Edad del conejo.
    private int edad;
    // Si el conejo está vivo o no.
    private boolean vive;
    // La posición del conejo.
    private Ubicacion ubicacion;

    /**
     * Crea un nuevo conejo. Se puede crear un conejo con edad
     * cero (un nuevo nacimiento) o con edad por azar.
     * 
     * @param edadPorAzar Si es true, el conejo tendrá una edad por azar.
     */
    public Conejo(boolean edadPorAzar)
    {
        edad = 0;
        vive = true;
        if(edadPorAzar) {
            edad = rand.nextInt(EDAD_MAX);
        }
    }
    
    /**
     * Esto es lo que hace el conejo la mayor parte del tiempo, corre por
     * todas partes. Algunas veces se reproducirá o morirá de viejo.
     * @param campoActualizado El campo al que se traslada.
     * @param nuevosConejos Una lista en la que se agregan los nuevos
     *                      conejos que nacen.
     */
    public void correr(Campo campoActualizado, List<Conejo> nuevosConejos)
    {
        incrementarEdad();
        if(vive) {
            int nacimientos = reproducir();
            for(int n = 0; n < nacimientos; n++) {
                Conejo nuevoConejo = new Conejo(false);
                nuevosConejos.add(nuevoConejo);
                Ubicacion ubi = campoActualizado.direccionAdyacentePorAzar(ubicacion);
                nuevoConejo.setUbicacion(ubi);
                campoActualizado.ubicar(nuevoConejo, ubi);
            }
            Ubicacion nuevaUbicacion = campoActualizado.direccionAdyacenteLibre(ubicacion);
            // Sólo se traslada al campo actualizado si la ubicación esta libre.
            if(nuevaUbicacion != null) {
                setUbicacion(nuevaUbicacion);
                campoActualizado.ubicar(this, nuevaUbicacion);
            }
            else {
                // no se puede mover ni estar, superpoblación, todas las
                // direcciones están ocupadas
                vive = false;
            }
        }
    }
    
    /**
     * Aumenta la edad.
     * Podría dar por resultado la muerte del conejo.
     */
    private void incrementarEdad()
    {
        edad++;
        if(edad > EDAD_MAX) {
            vive = false;
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
     * El conejo se puede reproducir si alcanzó la edad de reproducción.
     * @return true si el conejo se puede reproducir, false en otro caso.
     */
    private boolean sePuedeReproducir()
    {
        return edad >= EDAD_DE_REPRODUCCION;
    }
    
    /**
     * Se verifica si el conejo está vivo o muerto.
     * @return true si el conejo sigue vivo.
     */
    public boolean estaVivo()
    {
        return vive;
    }

    /**
     * Avisa al conejo que ahora está muerto :(
     */
    public void setComido()
    {
        vive = false;
    }
    
    /**
     * Establecer la ubicación del animal.
     * @param fila La coordenada vertical de la ubicacion.
     * @param columna La coordenada horizontal de la ubicacion.
     */
    public void setUbicacion(int fila, int columna)
    {
        this.ubicacion = new Ubicacion(fila, columna);
    }

    /**
     * Establecer la ubicación del conejo.
     * @param ubicacion La ubicación del conejo.
     */
    public void setUbicacion(Ubicacion ubicacion)
    {
        this.ubicacion = ubicacion;
    }
}
