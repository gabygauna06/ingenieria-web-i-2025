import java.util.Scanner;

/**
 * Una clase que lee l�neas de texto ingresadas por el usuario.
 * La entrada se filtra con getComando para verificar su validez.
 *
 * @author  Michael Kolling and David J. Barnes
 * @author Traducci�n: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class Parser 
{
    // Retiene todas las palabras comando v�lidas.
    private PalabrasComando comandos;
    private Scanner lector;

    public Parser() 
    {
        comandos = new PalabrasComando();
        lector = new Scanner(System.in);
    }

    /**
     * Lee el siguente comando del usuario.
     * El comando devuelto ser� v�lido.
     * @return Un comando v�lido.
     */
    public String getComando() 
    {
        String comando = null;
        do {
           // Muestra un int�rprete de comandos.
            System.out.print("> ");
            
            String palabra = lector.next();
            // Descarta el resto de la l�nea.
            leerLinea();
            if(comandos.esComando(palabra)) {
                comando = palabra;
            }
            else{
                System.out.println("Comando no reconocido: " + palabra);
                System.out.print("Los comandos v�lidos son: ");
                comandos.showTodos();
            }
        } while(comando == null);
    
        return comando;
    }

    /**
     * Muestra una lista de todos los comandos v�lidos.
     */
    public void showComandos()
    {
        comandos.showTodos();
    }

    /**
     * @return Una l�nea de texto del usuario.
     */
    public String leerLinea()
    {
        return lector.nextLine();
    }
}
