import java.util.HashMap;

/**
 * Esta clase es parte de la apliciacion "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Esta clase define todos los comandos v�lidos del juego mediante un 
 * arreglo de cadenas que contiene las palabras que se usar�n como
 * comandos
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class PalabrasComando
{
	// Un mapa de palabras comando y la PalabraComando
	// asociada
    private HashMap<String, PalabraComando> comandosValidos;

    /**
     * Constructor - inicializa las palabras comando
     */
    public PalabrasComando()
    {
        comandosValidos = new HashMap<String, PalabraComando>();
        for(PalabraComando comando : PalabraComando.values()) {
            if(comando != PalabraComando.DESCONOCIDO) {
            	comandosValidos.put(comando.toString(), comando);
            }
        }
    }

    /**
     * Encuentra la PalabraComando asociada con le palabra comando.
     * @param palabraComando la palabra a buscar.
     * @return La PalabraComando asociada a la palabra comando, o DESCONOCIDO
     *         si no es una palabra comando v�lida.
     */
    public PalabraComando getPalabraComando(String palabraComando)
    {
        PalabraComando comando = comandosValidos.get(palabraComando);
        if(comando != null) {
            return comando;
        }
        else {
            return PalabraComando.DESCONOCIDO;
        }
    }
    
    /**
     * Verifica si una cadena es una palabra comando v�lida 
     * @return true si la cadena es una palabra comando v�lida
     * false si no lo es.
     */
    public boolean esComando(String unaCadena)
    {
        return comandosValidos.containsKey(unaCadena);
    }

    /**
     * Imprime todos los comandos v�lidos al System.out.
     */
    public void mostrarTodo() 
    {
        for(String comando : comandosValidos.keySet()) {
            System.out.print(comando + "  ");
        }
        System.out.println();
    }
}