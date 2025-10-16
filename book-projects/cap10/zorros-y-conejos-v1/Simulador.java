import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.awt.Color;

/**
 * Un modelo sencillo de simulación predador-presa con zorros y conejos
 * dentro de un campo cerrado.
 * 
 * @author David J. Barnes and Michael Kolling
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Simulador
{
    // Se definen las constantes que representan la información de
    // configuración para la simulación.
    // Ancho por defecto de la malla.
    private static final int ANCHO_POR_DEFECTO = 50;
    // Largo por defecto de la malla.
    private static final int LARGO_POR_DEFECTO = 50;
    // La probabilidad que se cree un zorro en cualquier posición de la malla.
    private static final double PROBABILIDAD_DE_CREACION_DEL_ZORRO = 0.02;
    // La probabilidad que se cree un conejo en cualquier posición de la malla.
    private static final double PROBABILIDAD_DE_CREACION_DEL_CONEJO = 0.08;    

    // Listas de los animales en el campo. Se mantienen listas separadas
    // para facilitar su manejo.
    private List<Conejo> conejos;
    private List<Zorro> zorros;
    // El estado actual del campo.
    private Campo campo;
    // Un segundo campo que se usa para construir el siguiente escenario
    // de la simulación.
    private Campo campoActualizado;
    // El paso actual de la simulación.
    private int paso;
    // Una vista gráfica de la simulación.
    private VisorDelSimulador visor;
    
    /**
     * Crea un campo de simulación del tamaño por defecto.
     */
    public Simulador()
    {
        this(LARGO_POR_DEFECTO, ANCHO_POR_DEFECTO);
    }
    
    /**
     * Crea un campo de simulación de un determinado tamaño.
     * @param largo El largo del campo. Debe ser mayor que cero.
     * @param ancho El ancho del campo. Debe ser mayor que cero.
     */
    public Simulador(int largo, int ancho)
    {
        if(ancho <= 0 || largo <= 0) {
            System.out.println("Las dimensiones deben ser mayores que cero.");
            System.out.println("Uso de valores por defecto.");
            largo = LARGO_POR_DEFECTO;
            ancho = ANCHO_POR_DEFECTO;
        }
        conejos = new ArrayList<Conejo>();
        zorros = new ArrayList<Zorro>();
        campo = new Campo(largo, ancho);
        campoActualizado = new Campo(largo, ancho);

        // Crea un visor del estado de cada ubicacin en el campo.
        visor = new VisorDelSimulador(largo, ancho);
        visor.setColor(Conejo.class, Color.orange);
        visor.setColor(Zorro.class, Color.blue);
        
        // Establece un punto de inicio válido.
        inicializar();
    }
    
    /**
     * Ejecuta la simulación por un período razonablemente largo a partir
     * del estado actual, ej. 500 pasos.
     */
    public void ejecutarSimulacionLarga()
    {
        simular(500);
    }
    
    /**
     * Ejecuta la simulación un número determinado de pasos a partir
     * del estado actual.
     * Se detiene antes del número dado de pasos si deja de ser viable.
     * @param numeroDePasos El número de pasos a realizar.
     */
    public void simular(int numeroDePasos)
    {
        for(int paso = 1; paso <= numeroDePasos && visor.esViable(campo); paso++) {
            simularUnPaso();
        }
    }
    
    /**
     * Ejecuta un solo paso de la simulación a partir del estado actual.
     * Recorre el campo completo actualizando el estado de cada zorro
     * y cada conejo.
     */
    public void simularUnPaso()
    {
        paso++;

        // Proporciona espacio para los conejos recién nacidos.
        List<Conejo> conejosNuevos = new ArrayList<Conejo>();        
        // Deja que todos los conejos actúen.
        for(Iterator<Conejo> it = conejos.iterator(); it.hasNext(); ) {
            Conejo conejo = it.next();
            conejo.correr(campoActualizado, conejosNuevos);
            if(!conejo.estaVivo()) {
                it.remove();
            }
        }
        // Agrega los conejos recién nacidos a la lista de conejos.
        conejos.addAll(conejosNuevos);
        
        // Proporciona espacio para los zorros recién nacidos.
        List<Zorro> zorrosNuevos = new ArrayList<Zorro>();        
        // Deja que todos los zorros actúen.
        for(Iterator<Zorro> it = zorros.iterator(); it.hasNext(); ) {
            Zorro zorro = it.next();
            zorro.cazar(campo, campoActualizado, zorrosNuevos);
            if(!zorro.estaVivo()) {
                it.remove();
            }
        }
        // Agrega los zorros recién nacidos a la lista de zorros.
        zorros.addAll(zorrosNuevos);
        // Intercambia el campo y el campoActualizado al final del paso.
        Campo temp = campo;
        campo = campoActualizado;
        campoActualizado = temp;
        campoActualizado.limpiar(); 

        // Visualiza el nuevo campo en la pantalla.
        visor.mostrarEstado(paso, campo);
    }
        
    /**
     * Incializa la simulación en un punto de inicio.
     */
    public void inicializar()
    {
        paso = 0;
        conejos.clear();
        zorros.clear();
        campo.limpiar();
        campoActualizado.limpiar();
        poblar(campo);
        
        // Muestra el estado inicial en el visor.
        visor.mostrarEstado(paso, campo);
    }
    
    /**
     * Puebla un campo con zorros y conejos.
     * @param campo El campo que se poblará.
     */
    private void poblar(Campo campo)
    {
        Random rand = new Random();
        campo.limpiar();
        for(int fila = 0; fila < campo.getLargo(); fila++) {
            for(int columna = 0; columna < campo.getAncho(); columna++) {
                if(rand.nextDouble() <= PROBABILIDAD_DE_CREACION_DEL_ZORRO) {
                    Zorro zorro = new Zorro(true);
                    zorro.setUbicacion(fila, columna);
                    zorros.add(zorro);
                    campo.ubicar(zorro, fila, columna);
                }
                else if(rand.nextDouble() <= PROBABILIDAD_DE_CREACION_DEL_CONEJO) {
                    Conejo conejo = new Conejo(true);
                    conejo.setUbicacion(fila, columna);
                    conejos.add(conejo);
                    campo.ubicar(conejo, fila, columna);
                }
                // de lo contrario, la ubicación queda vacía.
            }
        }
        Collections.shuffle(conejos);
        Collections.shuffle(zorros);
    }
}
