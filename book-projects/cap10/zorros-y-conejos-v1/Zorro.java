import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Un modelo sencillo de zorro.
 * Los zorros nacen, se mueven, comen conejos y mueren.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Zorro
{
    // Características compartidas por todos los zorros (campos estáticos).
    
    // La edad en que un zorro comienza a reproducirse
    private static final int EDAD_DE_REPRODUCCION = 10;
    // La edad que puede vivir un zorro.
    private static final int EDAD_MAX = 150;
    // La probabilidad de reproducción de un zorro.
    private static final double PROBABILIDAD_DE_REPRODUCCION = 0.09;
    // El número máximo de nacimientos.
    private static final int MAXIMO_TAMANIO_DE_CAMADA = 3;
    // El valor alimentario de un conejo. Este es el número de pasos
    // que un zorro puede dar antes de necesitar comer otro conejo.
    private static final int VALOR_COMIDA_CONEJO = 4;
    // Un número aleatorio para controlar la reproducción.
    private static final Random rand = new Random();
    
    // Características individuales (campos de instancia).

    // La edad del zorro.
    private int edad;
    // Si el zorro está vivo o no.
    private boolean vive;
    // La posición del conejo.
    private Ubicacion ubicacion;
    // Nivel de comida del zorro, que se incrementa al comer conejos.
    private int nivelDeComida;

    /**
     * Crea un nuevo zorro. Se puede crear un zorro con edad
     * cero (un nuevo nacimiento y no tiene hambre) o con edad por azar.
     * 
     * @param edadPorAzar If true, the fox will have random edad and hunger level.
     */
    public Zorro(boolean edadPorAzar)
    {
        edad = 0;
        vive = true;
        if(edadPorAzar) {
            edad = rand.nextInt(EDAD_MAX);
            nivelDeComida = rand.nextInt(VALOR_COMIDA_CONEJO);
        }
        else {
            // Dejar edad en cero
            nivelDeComida = VALOR_COMIDA_CONEJO;
        }
    }
    
    /**
     * Esto es lo que hace el zorro la mayor parte del tiempo: caza
     * conejos. En el proceso, puede reproducirse, morir de hambre
     * o morir de viejo.
     * @param campoActual El campo actualmente ocupado.
     * @param campoActualizado El campo al que se traslada.
     * @param zorrosNuevos Una lista en la que se agregan los nuevos
     *                  zorros que nacen.
     */
    public void cazar(Campo campoActual, Campo campoActualizado, List<Zorro> zorrosNuevos)
    {
        incrementarEdad();
        incrementarHambre();
        if(vive) {
            // Nacieron nuevos zorros en direcciones adyacentes.
            int nacimientos = reproducir();
            for(int n = 0; n < nacimientos; n++) {
                Zorro nuevoZorro = new Zorro(false);
                zorrosNuevos.add(nuevoZorro);
                Ubicacion ubi = campoActualizado.direccionAdyacentePorAzar(ubicacion);
                nuevoZorro.setUbicacion(ubi);
                campoActualizado.ubicar(nuevoZorro, ubi);
            }
            // Se mueve hacia la fuente de comida, si es que la encuentra.
            Ubicacion nuevaUbicacion = buscarComida(campoActual, ubicacion);
            if(nuevaUbicacion == null) {  // no se encontró comida - se mueve aleatoriamente
                nuevaUbicacion = campoActualizado.direccionAdyacenteLibre(ubicacion);
            }
            if(nuevaUbicacion != null) {
                setUbicacion(nuevaUbicacion);
                campoActualizado.ubicar(this, nuevaUbicacion);
            }
            else {
                // no puede moverse ni estar, superpoblación, todas las
                // direcciones están ocupadas
                vive = false;
            }
        }
    }
    
    /**
     * Aumenta la edad.
     * Podría dar por resultado la muerte del zorro.
     */
    private void incrementarEdad()
    {
        edad++;
        if(edad > EDAD_MAX) {
            vive = false;
        }
    }
    
    /**
     * Hacer más hambriento a este zorro.
     * Podría dar por resultado la muerte del zorro.
     */
    private void incrementarHambre()
    {
        nivelDeComida--;
        if(nivelDeComida <= 0) {
            vive = false;
        }
    }
    
    /**
     * Decirle al zorro que busque conejos adyacentes a su ubicacion actual.
     * Sólo come el primer conejo que encuentra vivo.
     * @param campo El campo en el que debe buscar.
     * @param ubicacion El lugar del campo en el que está ubicado.
     * @return El lugar donde encontró comida o null si no encontró.
     */
    private Ubicacion buscarComida(Campo campo, Ubicacion ubicacion)
    {
        Iterator<Ubicacion> direccionesAdyacentes =
            campo.direccionesAdyacentes(ubicacion);
        while(direccionesAdyacentes.hasNext()) {
            Ubicacion lugar = direccionesAdyacentes.next();
            Object animal = campo.getObjectoEn(lugar);
            if(animal instanceof Conejo) {
                Conejo conejo = (Conejo) animal;
                if(conejo.estaVivo()) { 
                    conejo.setComido();
                    nivelDeComida = VALOR_COMIDA_CONEJO;
                    return lugar;
                }
            }
        }
        return null;
    }
        
    /**
     * Genera un número que representa el número de nacimientos,
     * si es que el zorro se puede reproducir.
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
     * @return true si el zorro se puede reproducir, false en otro caso.
     */
    private boolean sePuedeReproducir()
    {
        return edad >= EDAD_DE_REPRODUCCION;
    }
    
    /**
     * Se verifica si el zorro está vivo o muerto.
     * @return true si el zorro sigue vivo.
     */
    public boolean estaVivo()
    {
        return vive;
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
     * Establecer la ubicación del zorro.
     * @param ubicacion La ubicación del zorro.
     */
    public void setUbicacion(Ubicacion ubicacion)
    {
        this.ubicacion = ubicacion;
    }
}
