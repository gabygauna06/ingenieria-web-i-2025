import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Una clase para leer información desde un archivo en un servidor web.
 * Actualmente el archivo de log se asume que simplemete solo contiene
 * información sobre fechas y horas en el siguiente formato:
 *
 *    anio mes dia hora minuto
 *    
 * Las entradas de log estan en orden ascendiente por fecha.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class LectorDeArchivoLog
{
    // El formato de los datos en el archivo de log.
    private String formato;
    // Arreglo donde se almacenan los contenidos del archivo
    // de objetos con el formato EntradaLog
    private ArrayList<EntradaLog> entradas;
    // Un iterador sobre las entradas.
    private Iterator<EntradaLog> iteradorDeDatos;
    
    /**
     * Crea un LectorDeArchivoLog para suministrar datos desde un archivo por defecto.
     */
    public LectorDeArchivoLog()
    {
        this("weblog.txt");
    }
    
    /**
     * Crea un LectorDeArchivoLog que suministrará datos desde
     * un archivo de log particular.
     * @param nombreArchivo El archivo de datos de log.
     */
    public LectorDeArchivoLog(String nombreArchivo)
    {
        // El formato para los datos.
        formato = "Año Mes(1-12) Día Hora Minuto";       
        // Donde almacenar los datos.
        entradas = new ArrayList<EntradaLog>();
        
        // Intento de lectura del conjunto de datos completo desde el archivo.
        boolean lecturaDatos;
        try{
            // Ubicación del archivo respecto de el actual ambiente.
            URL archivoURL = getClass().getClassLoader().getResource(nombreArchivo);
            if(archivoURL == null) {
                throw new FileNotFoundException(nombreArchivo);
            }
            Scanner archivolog = new Scanner(new File(archivoURL.toURI()));
            // Lee líneas de datos hasta el fin de archivo.
            while(archivolog.hasNextLine()) {
                String linealog = archivolog.nextLine();
                // Separar la entrada y agragrela a la lista de entradas. 
                EntradaLog entrada = new EntradaLog(linealog);
                entradas.add(entrada);
            }
            archivolog.close();
            lecturaDatos = true;
        }
        catch(FileNotFoundException e) {
            System.out.println("Problema encontrado: " + e);
            lecturaDatos = false;
        }
        catch(URISyntaxException e) {
            System.out.println("Problem encountered: " + e);
            lecturaDatos = false;
        }
        // Si no se puede leer el archivo de log se simulan los datos. 
        if(!lecturaDatos) {
            System.out.println("Falló la lectura del archivo de datos: " +
                               nombreArchivo);
            System.out.println("En vez de ello se usan datos simulados.");
            crearDatosSimulados(entradas);
        }
        // Ordena las entradas en orden ascendente.
        Collections.sort(entradas);
        reestablece();
    }
    
    /**
     * Tiene el lector más datos para suministrar?
     * @return true si hay más datos disponibles,
     *         de otra manera false.
     */
    public boolean tieneMasEntradas()
    {
        return iteradorDeDatos.hasNext();
    }
    
    /**
     * Analiza la próxima línea del archivo de log y 
     * la hace disponiblevia un objeto de EntradaLog.
     * 
     * @return Una EntradaLog que contiene los datos desde
     *         la siguiente línea de log.
     */
    public EntradaLog siguienteEntrada()
    {
        return iteradorDeDatos.next();
    }
    
    /**
     * @return Una cadena explicando el formato de los datos
     *         en el archivo de log.
     */
    public String getFormato()
    {
        return formato;
    }
    
    /**
     * Establece un iterador nuevo para proveer acceso a los datos
     * Esto permite que sea procesado un solo archivo de datos
     * sea procesado más de una vez.
     */
    public void reestablece()
    {
        iteradorDeDatos = entradas.iterator();
    }

    /**
     * Imprime los datos.
     */    
    public void imprimeDatos()
    {
        for(EntradaLog entrada : entradas) {
            System.out.println(entrada);
        }
    }

    /**
     * Provee una muestra de datos simulados
     * NOTA: para simplificar la creación de estos datoa
     * nunca son generados días despúes del día 28.
     * @param datos Donde se almacenana los objetos de datos simulados EntradaLog.
     */
    private void crearDatosSimulados(ArrayList<EntradaLog> datos)
    {
        // Para cada item de datos (anio, mes, dia, hora, min) se lista
        // el menor valor válido.
        int[] menor = { 2006, 1, 1, 0, 0, };
        // Para cada item de datos (anio, mes, dia, hora, min) se lista el rango
        // de valores válidos. (Notar la simplificación de tener solo 28 días
        // en cualquier mes para evitar generar fechas inválidas.)
        int[] rango = { 3, 12, 28, 24, 60 };
        // Use una semilla fija para generar los datos al azar, de tal manera
        // que los datos sean reproducibles.
        Random rand = new Random(12345);
        // Construya cada línea simulada en un buffer cadena.
        StringBuffer linea = new StringBuffer();
        // Establece cuantas lineas simuladas son necesarias.
        int numLineas = 100;
        // El número de valores de datos por linea simulada.
        int itemsPorLinea = menor.length;
        for(int i = 0; i < numLineas; i++) {
            for(int j = 0; j < itemsPorLinea; j++) {
                int value = menor[j]+rand.nextInt(rango[j]);
                linea.append(value);
                linea.append(' ');
            }
            // Convierte la linea a EntradaLog.
            EntradaLog entrada = new EntradaLog(linea.toString());
            datos.add(entrada);
            linea.setLength(0);
        }
    }
}
