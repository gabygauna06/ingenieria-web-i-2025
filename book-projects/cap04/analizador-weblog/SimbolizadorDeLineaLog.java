import java.util.Scanner;

/**
 * Descompone una línea de un archivo de log de un servidor web en
 * sus campos separados.
 * Actualmente se supone que el archivo de log contiene datos enteros 
 * simples con información sobre de fechas y horas
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class SimbolizadorDeLineaLog
{
    /**
     * Construct a LogLineAnalyzer
     */
    public SimbolizadorDeLineaLog()
    {
    }

    /**
     * Simboliza una línea de log. Coloca sus valores enteros
     * en un arreglo. El número de componentes en la línea
     * debe ser suficiente para llenar el arreglo.
     *
     * @param linealog La línea a ser simbolizada.
     * @param lineaDatos en donde se almacenan los valores.
     */
    public void simbolice(String linealog, int[] lineaDatos)
    {
        try {
            // Recorre la liena de log para buscar enteros..
            Scanner simbolizador = new Scanner(linealog);
            for(int i = 0; i < lineaDatos.length; i++) {
                lineaDatos[i] = simbolizador.nextInt();
            }
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Número insuficiente de items de datos en la línea log: " + linealog);
            throw e;
        }
    }
}
