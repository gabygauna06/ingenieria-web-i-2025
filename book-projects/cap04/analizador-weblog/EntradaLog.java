/**
 * Almacena los datos de una sola línea de un 
 * archivo de log de un web-server.
 * Los campos individuales de hacen disponibles vía
 * métodos de acceso tales como getHora() y getMinuto().
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class EntradaLog implements Comparable<EntradaLog>
{
    // Donde se almacenan los datos extraídos de una único línea de log
    private int[] valoresDeDatos;
    // Indice en valoresDeDatos donde se almacenan los diferentes campos
    // de una línea de log.
    private static final int ANIO = 0, MES = 1, DIA = 2,
                             HORA = 3, MINUTO = 4;
                      
    /**
     * Descompone una línea de log de tal manera que los campos
     * individuale están disponibles.
     * @param linealog Una única línea del log.
     */
    public EntradaLog(String linealog)
    {
        // El arreglo donde se almacenana los datos de una única línea.
        valoresDeDatos = new int[5];
        // Se descompone la línea.
        SimbolizadorDeLineaLog simbolizador = new SimbolizadorDeLineaLog();
        simbolizador.simbolice(linealog,valoresDeDatos);
    }
    
    /**
     * @return El campo de la hora de la línea de log.
     */
    public int getHora()
    {
        return valoresDeDatos[HORA];
    }

    /**
     * @return El minuto de la línea de log.
     */
    public int getMinuto()
    {
        return valoresDeDatos[MINUTO];
    }
    
    /**
     * Crea una representación de los datos en una cadena.
     * Esta no es necesariamente idéntica al texto de la
     * línea original de la línea de log
     * @return Una cadena que representa los datos de esta entrada.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int valor : valoresDeDatos) {
           // Le agrega un cero inicial en números de un dígito.
            if(valor < 10) {
                buffer.append('0');
            }
            buffer.append(valor);
            buffer.append(' ');
        }
        // Descarta cualquier espacio vacío posterior.
        return buffer.toString().trim();
    }
    
    /**
     * Compara la  combinación de fecha/hora de esta entrada de log
     * con la de otra.
     * @param otraEntrada La otra entrada con la cual se compara.
     * @return Un valor negativo si esta entrada aparece antes que la otra.
     *         Un valor positivo si esta entrada aparece después de la otra.
     *         Cero si las entradas son iguales.
     */
    public int compareTo(EntradaLog otraEntrada)
    {
        if(otraEntrada == this) {
            // Son el mismo objeto.
            return 0;
        }
        else {
            // Compara los campos correspondientes.
            for(int i = 0; i < valoresDeDatos.length; i++) {
                int diferencia = valoresDeDatos[i] - otraEntrada.valoresDeDatos[i];
                if(diferencia != 0) {
                    return diferencia;
                }
            }
            // Ningún nvalor es diferente, por lo tanto las dos entradas 
            // representan idénticos momentos.
            return 0;
        }
    }
}