/**
 * Representacion de todos las palabras comando validas para el juego.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum PalabraComando
{
    // Un valor para cada palabra comando junto con la 
	// cadena a utilizar por la interfaz de usuario
     IR("ir"), SALIR("salir"), AYUDA("ayuda"), DESCONOCIDO("?");
    
    // La cadena comando
    private String cadenaComando;
    
    /**
     * Inicializa con la correspondiente palabra comando.
     * @param cadenaComando La cadena comando
     */
    PalabraComando(String cadenaComando)
    {
        this.cadenaComando = cadenaComando;
    }
    
    /**
     * @return la palabra comando como cadena
     */
    public String toString()
    {
        return cadenaComando;
    }
}
