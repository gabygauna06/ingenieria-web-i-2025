/**
 * Lee los datos de un servidor web y analiza
 * los modelos de acceso de cada hora.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class AnalizadorLog
{
    // Arreglo para calcular la cantidad de accesos por hora.
    private int[] contadoresPorHora;
    // Usa un LectorDeArchivoLog para acceder a los datos.
    private LectorDeArchivoLog lector;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public AnalizadorLog()
    { 
        // Crea un objeto arreglo para calcular la cantidad de 
        // accesos por hora.
        contadoresPorHora = new int[24];
        // Crea el lector para obtener los datos.
        lector = new LectorDeArchivoLog();
    }

    /**
     * Analiza los accesos por hora a partir de los datos del archivo log.
     */
    public void analizarPorHora()
    {
        while(lector.tieneMasEntradas()) {
            EntradaLog entrada = lector.siguienteEntrada();
            int hora = entrada.getHora();
            contadoresPorHora[hora]++;
        }
    }

    /**
     * Imprime la cantidad de accesos por hora.
     * Debe ser rrellenado previamente mediante una
     * llamada previa a analizarPorHora.
     */
    public void imprimirContadoresPorHora()
    {
        System.out.println("Hora: Cantidad");
        for(int hora = 0; hora < contadoresPorHora.length; hora++) {
            System.out.println(hora + ": " + contadoresPorHora[hora]);
        }
    }
    
    /**
     * Imprime las líneas de datos leídas por el LectorDeArchivoLog
     */
    public void imprimeDatos()
    {
        lector.imprimeDatos();
    }
}
