import java.util.HashSet;
import java.util.Scanner;

/**
 * LectorDeEntrada lee el texto escrito en el terminal de texto estandar.
 * El texto tipeado es dividido en palabras, y se provee un set de palabras.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    1.0
 */
public class LectorDeEntrada
{
    private Scanner lector;

    /**
     * Crea un nuevo LectorDeEntrada que lee texto desde el terminal de texto.
     */
    public LectorDeEntrada()
    {
        lector = new Scanner(System.in);
    }

    /**
     * Lee una linea de texto desde la entrada estandar (el terminal de texto)
     * y retorna como un conjunto de palabras.
     *
     * @return  Un conjunto de cademas, en el que cada String es una palabra 
     *          que escribi� el usuario
     */
    
    public HashSet<String> getEntrada() 
    {
        System.out.print("> ");                // imprime e� prompt
        String linea = lector.nextLine().trim().toLowerCase();

        String[] arregloDePalabras = linea.split(" ");  // separa por espacios

        // agrega palabras del arreglo en el hashset 
        HashSet<String> palabras = new HashSet<String>();
        for(String palabra : arregloDePalabras) {
            palabras.add(palabra);
        }
        return palabras;
    }
}
