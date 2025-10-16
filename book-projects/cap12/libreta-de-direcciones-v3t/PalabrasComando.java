/**
 * Esta clase retiene una enumeración de todas las palabras
 * comando conocidas por el programa.
 *
 * @author  Michael Kolling and David J. Barnes
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class PalabrasComando
{
    // un arreglo constante que retiene los comandos validos
    private static final String comandosValidos[] = {
        "agregar", "tomar", "buscar", "listar", "ayuda", "salir",
    };

    /**
     * Constructor para PalabrasComando
     */
    public PalabrasComando()
    {
    }

    /**
     * Verifica si un String dado es un comando valido.
     * @param unString El texto a verificar.
     * @return 'true' si es valido, 'false' si no lo es.
     */
    public boolean esComando(String unString)
    {
        if(unString != null){
            for(int i = 0; i < comandosValidos.length; i++) {
                if(comandosValidos[i].equals(unString))
                    return true;
            }
        }
        // Si llegamos hasta aqui, la palabra no se encontro entre los comandos
        return false;
    }

    /**
     * Muestra los comandos validos en System.out.
     */
    public void showTodos() 
    {
        for(String comando : comandosValidos) {
            System.out.print(comando + "  ");
        }
        System.out.println();
    }
}
