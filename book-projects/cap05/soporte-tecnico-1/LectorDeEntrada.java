import java.util.Scanner;

/**
 * LectorDeEntrada lee el texto escrito en el terminal de texto estandar.
 * El texto tipeado es dividido en palabras, y se provee un set de palabras.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1
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
     *Lee una linea de texto desde la entrada estandar (el terminal de texto)
     * y retorna una cadena.
     *
     * @return  La candea tipeada por el usuario.
     */
    public String getEntrada()
    {
        System.out.print("> ");         // imprime el prompt
        String linea = lector.nextLine();

        return linea;
    }
}
