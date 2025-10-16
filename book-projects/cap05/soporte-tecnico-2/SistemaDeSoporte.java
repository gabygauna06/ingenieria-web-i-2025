
/**
 * Esta clase implementa un sistema de soporte t�cnico. Es la clase de
 * mayor nivel del proyecto. El sistema de soporte se comunica mediante
 * la terminal de texto con entradas y salidas en ella.
 * 
 * La clase usa un objeto de clase LectorDeEntrada para leer las entradas
 * del usuario y un objecto de clase Contestador para generar las 
 * respuestas. Contiene un ciclo que repetidamente lee las entradas y
 * genera las respuestas hasta que el usuario decide salir.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.2
 */
public class SistemaDeSoporte
{
    private LectorDeEntrada lector;
    private Contestador contestador;
    
    /**
     * Crea un sistema de soporte t�cnico.
     */
    public SistemaDeSoporte()
    {
        lector = new LectorDeEntrada();
        contestador = new Contestador();
    }

    /**
     * Inicia el sistema de soporte t�cnico. Imprimir� un mensaje de bienvenida
     * y establece un di�logo con el usuario hasta que el usuario lo finalice.
     */
    public void inicio()
    {
        boolean terminado = false;

        imprimirBienvenida();

        while(!terminado) {
            String entrada = lector.getEntrada().trim().toLowerCase();
            
            if(entrada.startsWith("bye")) {
            	
                terminado = true;
            }
            else {
                String respuesta = contestador.generarRespuesta();
                System.out.println(respuesta);
            }
        }
        imprimirDespedida();
    }

    /**
     * Imprime un mensaje de Bienvenida en la pantalla
     */
    private void imprimirBienvenida()
    {
    	System.out.println("Bienvenido al Sistema de Soporte T�cnico de DodgySoft.");
        System.out.println();
        System.out.println("Por favor, cu�ntenos de su problema.");
        System.out.println("Lo asistiremos con cualquier problema que tenga.");
        System.out.println("Para salir del sistema escriba 'bye'.");
    }

    /**
     * Imprime un mensaje de Despedida en la pantalla
     */
    private void imprimirDespedida()
    {
    	System.out.println("Un gusto hablar con usted. Bye...");
    }
}
