import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Contestador represante un objeto generador de respuestas.
 * Se lo usa para generar una respuesta automática por azar seleccionando 
 * una frase de una lista predefinida de respuestas.
 * 
 * @version    0.2
 * @author     Michael Kolling and David J. Barnes
 */
public class Contestador
{
    private Random generadorDeAzar;
    private ArrayList<String> respuestas;

    /**
     * Crea un Contestador
     */
    public Contestador()
    {
        generadorDeAzar = new Random();
        respuestas = new ArrayList<String>();
        rellenarRespuestas();
    }

    /**
     * Genera una respuesta
     * 
     * @return   Una cadena que se podría mostrar como respuesta
     */
    public String generarRespuesta()
    {
        // Pick a random number for the index in the default response 
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        int indice = generadorDeAzar.nextInt(respuestas.size());
        return respuestas.get(indice);
    }

    /**
     * Construye una lista de respuestas por defecto desde donde se tomará
     * una cuando no sepamso más qué decir.
     */
	private void rellenarRespuestas() {
		respuestas.add("Parece complicado. ¿Podría describir \n"
				+ "el problema más detalladamente?");
		respuestas
				.add("Hasta ahora, ningún cliente informó \n"
						+ "sobre este problema. ¿Cuál es la configuración de su equipo?");
		respuestas.add("Lo que dice parece interesante, "
				+ "cuénteme un poco más");
		respuestas.add("Necesito un poco más de información.");
		respuestas.add("¿Verificó si tienen algún conflicto con una dll?");
		respuestas.add("Ese problema está explicado en el manual.\n"
				+ "¿Leyó el manual?");
		respuestas.add("Su descripción es un poco confusa.\n"
				+ "¿Cuenta con algún experto que lo ayude a \n"
				+ "describir el problma de manera más precisa?");
		respuestas.add("Eso no es una falla, es una característica\n"
				+ "del programa!");
		respuestas.add("¿Ha podido elaborar esto?");
	}
}
