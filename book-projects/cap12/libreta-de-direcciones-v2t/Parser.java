import java.util.Scanner;

/**
 * Una clase que lee líneas de texto ingresadas por el usuario.
 * La entrada se filtra con getComando para verificar su validez.
 *
 * @author  Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Parser 
{
    // Retiene todas las palabras comando válidas.
    private PalabrasComando comandos;
    private Scanner lector;

    public Parser() 
    {
        comandos = new PalabrasComando();
        lector = new Scanner(System.in);
    }

    /**
     * Lee el siguente comando del usuario.
     * El comando devuelte será válido.
     * @return Un comando válido.
     */
    public String getComando() 
    {
        String comando = null;
        do {
           // Muestra un intérprete de comandos.
            System.out.print("> ");
            
            String palabra = lector.next();
            // Descarta el resto de la línea.
            leerLinea();
            if(comandos.esComando(palabra)) {
                comando = palabra;
            }
            else{
                System.out.println("Comando no reconocido: " + palabra);
                System.out.print("Los comandos válidos son: ");
                comandos.showTodos();
            }
        } while(comando == null);
    
        return comando;
    }

    /**
     * Muestra una lista de todos los comandos válidos.
     */
    public void showComandos()
    {
        comandos.showTodos();
    }

    /**
     * @return Una línea de texto del usuario.
     */
    public String leerLinea()
    {
        return lector.nextLine();
    }
}
