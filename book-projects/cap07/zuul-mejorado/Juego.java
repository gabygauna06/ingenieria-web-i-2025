/**
 *  Es la clase principal del programa "World of Zuul". 
 *  "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *  Los usuarios pueden caminar en algun escenario, eso es todo. Puede 
 *  extenderse para hacerlo bastante mas interesante.
 *  
 *  Para jugar a este juego, crear una instancia de esta clase y llamar
 *  al metodo "jugar".
 * 
 *  Esta clase crea e inicializa a todas las otras: crea todas las habitaciones,
 *  crea el analizador e incia el juego. Ademas evalua y ejecuta los comandos
 *  que el analizador devuelve.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Juego 
{
    private Analizador analizador;
    private Habitacion habitacionActual;
        
    /**
     * Crea el juego e inicializa el mapa interno.
     */
    public Juego() 
    {
        crearHabitaciones();
        analizador = new Analizador();
    }

    /**
     * Crea todas las habitaciones y relaciona todas sus salidas.
     */
    private void crearHabitaciones()
    {
        Habitacion exterior, teatro, bar, laboratorio, oficina;
      
        // crea las habitaciones
        exterior = new Habitacion("el exterior de la entrada principal a la universidad");
        teatro = new Habitacion("en el anfiteatro");
        bar = new Habitacion("en el bar del campus");
        laboratorio = new Habitacion("en el laboratorio de computacion");
        oficina = new Habitacion("en la oficina del director de computacion");
        
        // inicializa las salidas de las habitaciones
        exterior.establecerSalida("este", teatro);
        exterior.establecerSalida("sur", laboratorio);
        exterior.establecerSalida("oeste", bar);

        teatro.establecerSalida("oeste", exterior);

        bar.establecerSalida("este", exterior);

        laboratorio.establecerSalida("norte", exterior);
        laboratorio.establecerSalida("este", oficina);

        oficina.establecerSalida("oeste", laboratorio);

        habitacionActual = exterior;  // el juego arranca desde afuera
    }

    /**
     * Rutina principal para jugar. Ciclo que se ejecuta hasta que se 
     * termine de jugar
     */
    public void jugar() 
    {            
        imprimirBienvenida();

        // Entra en el ciclo principal. Ac� leemos repetidamente
        // los comandos y se los ejecuta hasta que termine el juego.
                
        boolean finalizado = false;
        while (! finalizado) {
            Comando comando = analizador.getComando();
            finalizado = procesarComando(comando);
        }
        System.out.println("Gracias por jugar. Hasta pronto.");
    }
    
    /**
     * Imprime el mensaje de apertura para el jugador
     */
    private void imprimirBienvenida()
    {
        System.out.println();
        System.out.println("Bienvenido a World of Zuul!");
        System.out.println("World of Zuul es un nuevo e increiblemente aburrido" +
        		"juego de aventuras.");
        System.out.println("Escriba 'ayuda' cuando la necesite.");
        System.out.println();
        System.out.println("Usted esta en " + habitacionActual.getDescripcionLarga());
    }

    /**
     * Dado un comando, procesar (esto es: ejecutar) el comando.
     * @param comando El comando a ser procesado.
     * @return true si el comando finaliza el juego, false caso contrario
     */
    private boolean procesarComando(Comando comando) 
    {
        boolean quiereSalir = false;

        if(comando.esDesconocido()) {
            System.out.println("No entiendo lo que quieres decir...");
            return false;
        }

        String palabraComando = comando.getPalabraComando();
        if (palabraComando.equals("ayuda"))
            imprimirAyuda();
        else if (palabraComando.equals("ir"))
            irAHabitacion(comando);
        else if (palabraComando.equals("salir"))
            quiereSalir = salir(comando);

        return quiereSalir;
    }


    // implementacion de los comandos:

    /**
     * Imprime informacion de ayuda.
     * Aqu� imprimimos alguos mensajes est�pidos y cr�pticos y una
     * lista de las palabras comando.
     */
    private void imprimirAyuda() 
    {
        System.out.println("Estas perdido. Estas solo. Deambulas");
        System.out.println("alrededor de la universidad.");
        System.out.println();
        System.out.println("Tus palabras comando son:");
        analizador.mostrarComandos();
    }

    /** 
     * Tratar de ir en otra direcci�n. Si existe una salida,
     * entra en la nueva habitaci�n, en caso contrario imprime
     * un mensaje de error.
     */
    private void irAHabitacion(Comando comando) 
    {
        if(!comando.tieneSegundaPalabra()) {
            // si no hay segunda palabra no sabemos a donde ir...
            System.out.println("�A d�nde quiere ir?");
            return;
        }

        String direccion = comando.getSegundaPalabra();

        // Tratar de salir de la habitaci�n actual
        Habitacion siguienteHabitacion = habitacionActual.getSalida(direccion);

        if (siguienteHabitacion == null) {
            System.out.println("No existe esa salida!");
        }
        else {
            habitacionActual = siguienteHabitacion;
            System.out.println(habitacionActual.getDescripcionLarga());
        }
    }


    /** 
     * Se ingres� "salir". Verificar el resto de los comandos
     * para saber si realmente queremos salir del juego.
     * @return true, si el comando finaliza el juego, false en caso contrario.
     */
    private boolean salir(Comando comando) 
    {
        if(comando.tieneSegundaPalabra()) {
            System.out.println("salir de d�nde?");
            return false;
        }
        else {
            return true;  //se�al de que queremos salir del juego
        }
    }
}